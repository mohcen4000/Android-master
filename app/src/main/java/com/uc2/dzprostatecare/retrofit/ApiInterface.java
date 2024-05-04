package com.uc2.dzprostatecare.retrofit;



import com.uc2.dzprostatecare.pojo.FoodData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("fooddata.json")
    Call<List<FoodData>> getAllData();


    // lets make our model class of json data.

}
