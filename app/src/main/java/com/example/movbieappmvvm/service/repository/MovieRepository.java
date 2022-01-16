package com.example.movbieappmvvm.service.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.movbieappmvvm.service.model.Result;

import java.util.List;

public interface MovieRepository
{
    public MutableLiveData<List<Result>> getTopRatedMovieList();
}
