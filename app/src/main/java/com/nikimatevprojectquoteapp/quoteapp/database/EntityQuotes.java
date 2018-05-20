package com.nikimatevprojectquoteapp.quoteapp.database;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class EntityQuotes {

    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo(name = "quotes")
    private String quotes;

    @ColumnInfo(name = "author")
    private String author;


    public EntityQuotes(String quotes, String author) {
        this.quotes = quotes;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
