package com.danta.sidqi.projectptsxi;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private ArrayList<Model> movieList;
    private Context context;



    public MovieAdapter(ArrayList<Model> list, Context context){
        this.movieList = list;
        this.context = context;
    }


    public MovieAdapter(ArrayList<Model> movieList) {
        this.movieList = movieList;

    }



    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Model model = movieList.get(position);
        holder.txtName.setText(movieList.get(position).getOriginal_title());
        holder.txtDate.setText(movieList.get(position).getRelease_date());
        Picasso.get()
                .load(movieList.get(position).getPoster_path())
                .placeholder(R.drawable.posttteerrr)
                .error(R.drawable.posttteerrr)
                .resize(140, 190)
                .into(holder.img);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pass = new Intent(view.getContext(), DetailActivity.class);
                pass.putExtra("title", model.getOriginal_title());
                pass.putExtra("overview", model.getOverview());
                pass.putExtra("date", model.getRelease_date());
                view.getContext().startActivity(pass);
            }
        });
    }


    @Override
    public int getItemCount() {
        return (movieList != null) ? movieList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtDate;
        ImageView img;
        CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtttl);
            txtDate = itemView.findViewById(R.id.txtreleasedate);
            img = itemView.findViewById(R.id.img_mov);
            card = itemView.findViewById(R.id.card_movie);


        }
    }
}
