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
    List<Model> favList;
    FavAdapter favAdapter;

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
        Realm.init(view.getContext());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        helper = new RealmHelper(realm);
        favList = helper.getAllModel();

        favAdapter = new FavAdapter(favList);
        RecyclerView.LayoutManager rvmanager = new LinearLayoutManager(getActivity());

        rv_fav.setAdapter(favAdapter);
        rv_fav.setLayoutManager(rvmanager);



        return view;

    }
}