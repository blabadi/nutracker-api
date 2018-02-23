package com.bashar.nutracker.core.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Entry> getUserEntriesInPeriod(String owner, Date start, Date end) {
        return entryRepo.getByPeriod(owner, start, end);
    }

    public boolean updateUserEntry(Entry entry) {
        return entryRepo.updateUserEntry(entry);
    }

    public void deleteUserEntry(String id, String owner) {
        this.entryRepo.deleteUserEntry(id , owner);
    }
}
