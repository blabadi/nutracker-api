package com.bashar.nutracker.core.service;

import com.bashar.nutracker.core.dm.Entry;
import com.bashar.nutracker.core.repo.api.EntryRepoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Bashar on 2017-09-10.
 */
@Service
public class EntrySvc {

    @Autowired
    EntryRepoApi entryRepo;

    public Entry create(Entry e) {
        return entryRepo.create(e);
    }

    public List<Entry> getEntries(){
        return  entryRepo.getAll();
    }

    public List<Entry> getEntries(Date start, Date end){
        return entryRepo.getByPeriod(start, end);
    }

    public boolean update(Entry entry) {
        return entryRepo.update(entry);
    }

    public void delete(String id) {
        this.entryRepo.delete(id);
    }
}
