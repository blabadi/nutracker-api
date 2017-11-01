package com.bashar.nutracker.core.repo.mongo;

import com.bashar.nutracker.core.dm.Entry;
import com.bashar.nutracker.core.repo.api.EntryRepoApi;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Override
    public List<Entry> getByPeriod(Date start, Date end) {
        Query findQuery = new Query();
        findQuery.addCriteria(Criteria.where("createdAt").gte(start).lte(end));
        return operations.find(findQuery, Entry.class);
    }

    public boolean update(Entry entry){
        Query findQuery = new Query();
        findQuery.addCriteria(Criteria.where("_id").is(entry.getId()));
        Update update = new Update();
        update.set("amount", entry.getAmount());
        WriteResult res = operations.updateFirst(findQuery, update, Entry.class);
        return res.wasAcknowledged();
    }

    @Override
    public void delete(String id) {
        operations.remove(new Query().addCriteria(Criteria.where("_id").is(id)), Entry.class);
    }
}