package com.bashar.nutracker.core.entry;

import com.bashar.nutracker.core.entry.Entry;

import java.util.Date;
import java.util.List;

/**
 * Created by Bashar on 2017-09-10.
 */
public interface EntryRepoApi {
    Entry create(Entry e);

    List<Entry> getAll();

    List<Entry> getByPeriod(String owner, Date start, Date end);

    boolean updateUserEntry(Entry entry);

    void deleteUserEntry(String id, String owner);
}

