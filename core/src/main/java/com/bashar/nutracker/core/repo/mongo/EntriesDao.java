package com.bashar.nutracker.core.repo.mongo;

import com.bashar.nutracker.core.dm.Entry;
import com.bashar.nutracker.core.repo.api.EntryRepoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bashar on 2017-09-03.
 */
@Repository
public class EntriesDao implements EntryRepoApi{


    @Autowired
    MongoOperations operations;

    public Entry create(Entry e) {
        operations.save(e);
        return e;
    }

    @Override
    public List<Entry> getAll() {
        return operations.findAll(Entry.class);
    }


}
