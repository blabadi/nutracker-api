package com.bashar.nutracker.core.repo.api;

import com.bashar.nutracker.core.dm.Entry;

import java.util.List;

/**
 * Created by Bashar on 2017-09-10.
 */
public interface EntryRepoApi {
    Entry create(Entry e);

    List<Entry> getAll();
}
