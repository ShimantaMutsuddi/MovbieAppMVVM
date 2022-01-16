package com.example.movbieappmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movbieappmvvm.service.model.Result;
import com.example.movbieappmvvm.service.repository.MovieRepositoryImplementation;
import com.example.movbieappmvvm.service.repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel
{
    private MovieRepository movieRepository;

    public MovieListViewModel(@NonNull Application application) {
        super(application);
        movieRepository= MovieRepositoryImplementation.getInstance(application);
    }

    public LiveData<List<Result>> getTopRatedMovieList()
    {
        return movieRepository.getTopRatedMovieList();
    }
}
