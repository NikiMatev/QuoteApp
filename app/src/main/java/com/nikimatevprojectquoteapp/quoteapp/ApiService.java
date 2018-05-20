package com.nikimatevprojectquoteapp.quoteapp;




import com.nikimatevprojectquoteapp.quoteapp.model.Quote;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/1.0/?method=getQuote&format=json&lang=en")
    Call<Quote> getQuote();
}
