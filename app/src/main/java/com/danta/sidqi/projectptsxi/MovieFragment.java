package com.danta.sidqi.projectptsxi;

import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MovieFragment extends Fragment {
    ArrayList<Model> movieList;
    RecyclerView rv_movie;
    MovieAdapter movieAdapter;



    String URL = "https://www.thesportsdb.com/api/v1/json/2/all_sports.php";




    public MovieFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        movieList = new ArrayList<>();
        rv_movie = view.findViewById(R.id.rvmovies);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addData();

    }

    void addData(){

        AndroidNetworking.get(URL).build().getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray result = response.getJSONArray("sports");
                    for (int i = 0; i < result.length(); i++){
                        JSONObject object = result.getJSONObject(i);
                        String original_title = object.getString("strSport");
                        String overview = object.getString("strSportDescription");
                        String poster_path = object.getString("strSportThumb");
                        String release_date = object.getString("strFormat");
                        movieList.add(new Model(original_title, overview, poster_path, release_date));

                    }
                    movieAdapter = new MovieAdapter(movieList);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
                    rv_movie.setLayoutManager(manager);
                    rv_movie.setAdapter(movieAdapter);
                } catch (JSONException e) {
                    Log.d("error", e.toString());

                }
            }
            @Override
            public void onError(ANError anError) {
                Log.d("Error", anError.toString());

            }
        });
    }
}