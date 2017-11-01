package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.core.dm.Entry;
import com.bashar.nutracker.core.service.EntrySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Bashar on 2017-08-27.
 */
@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("entry")
public class EntryApi {

    @Autowired
    EntrySvc entrySvc;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<Entry> getAll(){
        return entrySvc.getEntries();
    }

    @RequestMapping(value="/from/{start}/to/{end}", method = RequestMethod.GET)
    public List<Entry> getAll(@PathVariable("start") String start, @PathVariable("end") String end){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date startDate, endDate = null;
        try {
            startDate = sdf.parse(start);
            endDate = sdf.parse(end);
        } catch (ParseException e) {
            throw new InvalidParameterException();
        }
        if (startDate.equals(endDate)){
            endDate = new Date(endDate.getYear(), endDate.getMonth(), endDate.getDate(), 23, 59, 59);
        }
        return entrySvc.getEntries(startDate, endDate);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Entry create(@RequestBody Entry entry){
        System.out.println("create "+ entry);
        return entrySvc.create(entry);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody Entry entry){
        System.out.println("update" + entry);
        entrySvc.update(entry);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        System.out.println("delete id:" + id);
        entrySvc.delete(id);
    }

}
