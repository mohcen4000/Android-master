package com.uc2.dzprostatecare.pojo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Headers;

public class ApiClient {

    private static final String BASE_URL = "https://proman-app.000webhostapp.com/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
