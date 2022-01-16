package com.example.movbieappmvvm.service.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.movbieappmvvm.service.model.MovieModel;
import com.example.movbieappmvvm.service.model.Result;
import com.example.movbieappmvvm.service.network.ApiServices;
import com.example.movbieappmvvm.service.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepositoryImplementation implements MovieRepository {
    private MovieModel movieModel;
    private List<Result> mResult;
    private static Context mcontext;
    private static MovieRepositoryImplementation instance;
    private MutableLiveData mutableLiveData;
    public static MovieRepositoryImplementation getInstance(Context context)
    {
        if(instance==null)
        {
            mcontext=context;
            instance=new MovieRepositoryImplementation();
        }
        return instance;

    }

    //make it livedata
    @Override
    public MutableLiveData<List<Result>>getTopRatedMovieList()
    {
        if(mutableLiveData==null)
        {
            mutableLiveData=new MutableLiveData();
        }
        ApiServices apiServices= RetrofitInstance.getRetrofitInstance().create(ApiServices.class);
        Call<MovieModel> call=apiServices.getTopRatedMovieList();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                movieModel=response.body();
                mResult=movieModel.getResults();

                mutableLiveData.postValue(mResult);


            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });

        return mutableLiveData;

    }

}
