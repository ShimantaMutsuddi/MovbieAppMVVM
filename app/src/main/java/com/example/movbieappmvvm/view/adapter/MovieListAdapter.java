package com.example.movbieappmvvm.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movbieappmvvm.R;
import com.example.movbieappmvvm.service.model.Result;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder>
{

    private Context mContext;
    private List<Result> mList;

    public MovieListAdapter(Context mContext, List<Result> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_row,parent,false);
        return new MyViewHolder(view);*/
        View view=LayoutInflater.from(mContext).inflate(R.layout.single_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.title.setText(mList.get(position).getTitle());
        holder.rating.setText(mList.get(position).getVoteAverage().toString());
        holder.releasedate.setText(mList.get(position).getReleaseDate());
        //String url = myUrls.get(position);

        Glide
                .with(mContext)
                .load("https://image.tmdb.org/t/p/w500/"+mList.get(position).getPosterPath())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        if(mList!=null)
        {
            return mList.size();
        }
        else
        {
            return 0;
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView title,rating,releasedate;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            rating=itemView.findViewById(R.id.rating);
            releasedate=itemView.findViewById(R.id.date);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }

}
