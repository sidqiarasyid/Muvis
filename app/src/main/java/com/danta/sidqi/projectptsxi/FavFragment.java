package com.danta.sidqi.projectptsxi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.Realm;
import io.realm.RealmConfiguration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FavFragment extends Fragment {
    RecyclerView rv_fav;
    ArrayList<Model> favList;
    MovieAdapter favAdapter;

    Realm realm;
    RealmHelper helper;



    public FavFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        favList = new ArrayList<>();
        rv_fav = view.findViewById(R.id.rvfavorite);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        rv_fav.setLayoutManager(manager);
        favAdapter = new MovieAdapter(favList);
        rv_fav.setAdapter(favAdapter);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(config);

        helper = new RealmHelper(realm);
        favList = helper.getAllModel();



        return view;

    }
}