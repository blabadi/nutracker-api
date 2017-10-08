package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.core.dm.Entry;
import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.service.EntrySvc;
import com.bashar.nutracker.core.service.FoodSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Entry create(@RequestBody Entry entry){
        System.out.println(entry);
        return entrySvc.create(entry);
    }

}
