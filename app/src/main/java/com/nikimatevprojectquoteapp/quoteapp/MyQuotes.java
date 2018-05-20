package com.nikimatevprojectquoteapp.quoteapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.List;


public class MyQuotes extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    public MyQuotes() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_quotes,container,false);
        recyclerView = view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //adapter = new QuotesAdapter();
        //recyclerView.setAdapter(adapter);


        return view;
    }


}
