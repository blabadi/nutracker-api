package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.core.entry.Entry;
import com.bashar.nutracker.core.entry.EntrySvc;
import com.bashar.nutracker.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Bashar on 2017-08-27.
 */
//this annotation has to be on each controller, cant go on base only
@RestController
@RequestMapping("/api/entry")
public class EntryApi {

    @Autowired
    EntrySvc entrySvc;

    @Autowired
    UserService userSvc;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<Entry> getAll(){
        return entrySvc.getEntries();
    }

    @RequestMapping(value="/from/{start}/to/{end}", method = RequestMethod.GET)
    public List<Entry> getUserEntriesInPeriod(@PathVariable("start") String start,
                                              @PathVariable("end") String end,
                                              // see how this works: https://stackoverflow.com/questions/8764545/how-to-get-active-users-userdetails
                                              @AuthenticationPrincipal User activeUser){
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
        return entrySvc.getUserEntriesInPeriod(activeUser.getUsername(), startDate, endDate);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Entry create(@RequestBody Entry entry, @AuthenticationPrincipal User activeUser){
        System.out.println("create "+ entry);
        entry.setOwner(activeUser.getUsername());
        return entrySvc.create(entry);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody Entry entry, @AuthenticationPrincipal User activeUser){
        System.out.println("update" + entry);
        entry.setOwner(activeUser.getUsername());
        entrySvc.updateUserEntry(entry);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id, @AuthenticationPrincipal User activeUser){
        System.out.println("delete id:" + id);
        entrySvc.deleteUserEntry(id, activeUser.getUsername());
    }

}
