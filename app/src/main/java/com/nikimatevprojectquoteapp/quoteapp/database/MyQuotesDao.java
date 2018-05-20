package com.nikimatevprojectquoteapp.quoteapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.nikimatevprojectquoteapp.quoteapp.database.EntityQuotes;

import java.util.List;

@Dao
public interface MyQuotesDao {

    @Query("SELECT * FROM entityquotes")
    List<EntityQuotes>getAllQuotes();

    @Insert
    void insertAll(EntityQuotes... entityQuotes);
}
