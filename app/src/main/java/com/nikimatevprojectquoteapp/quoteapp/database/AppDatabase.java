package com.nikimatevprojectquoteapp.quoteapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {EntityQuotes.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MyQuotesDao myQuotesDao();


}
