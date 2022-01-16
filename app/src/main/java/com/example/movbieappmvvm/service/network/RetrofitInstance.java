package com.example.movbieappmvvm.service.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance
{
    public static  String Base_Url="https://api.themoviedb.org/";
    public  static Retrofit retrofit;

    public static Retrofit getRetrofitInstance()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
