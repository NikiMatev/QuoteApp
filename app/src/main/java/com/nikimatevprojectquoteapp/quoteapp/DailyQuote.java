package com.nikimatevprojectquoteapp.quoteapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nikimatevprojectquoteapp.quoteapp.database.AppDatabase;
import com.nikimatevprojectquoteapp.quoteapp.database.EntityQuotes;
import com.nikimatevprojectquoteapp.quoteapp.model.Quote;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DailyQuote extends Fragment {

    private ProgressBar pb;
    private TextView newQuote;
    private TextView authorQuote;
    private Button btnQuote;
    private Button btnSave;
    Quote quote;

    public DailyQuote() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_quote, container, false);
        pb = (ProgressBar) view.findViewById(R.id.progressBar);
        newQuote = (TextView) view.findViewById(R.id.txt_quote);
        authorQuote = (TextView) view.findViewById(R.id.txt_quoteAuthor);
        getQuote();
        final AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(),AppDatabase.class,"entityquotes")
                .allowMainThreadQueries()
                .build();

        btnQuote = (Button) view.findViewById(R.id.btn_getQuote);
        btnQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.setVisibility(View.VISIBLE);
                getQuote();
            }
        });

        btnSave = (Button) view.findViewById(R.id.btn_saveQuote);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.myQuotesDao().insertAll(new EntityQuotes(newQuote.getText().toString(), authorQuote.getText().toString()));

//                MyQuotes myQuotes = new MyQuotes();
//                FragmentManager manager = getFragmentManager();
//                manager.beginTransaction().replace(R.id.


            }
        });
        return view;


    }

    public void getQuote(){
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("http://api.forismatic.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService api = rf.create(ApiService.class);

        api.getQuote().enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                quote = response.body();
                pb.setVisibility(View.INVISIBLE);
                displayQuote();
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {

            }
        });
    }

    public void displayQuote(){

        newQuote.setText(quote.getQuoteText());

        authorQuote.setText(quote.getQuoteAuthor());
    }




}

