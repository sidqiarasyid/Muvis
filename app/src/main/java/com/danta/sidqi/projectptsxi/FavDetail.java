package com.danta.sidqi.projectptsxi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import io.realm.Realm;

public class FavDetail extends AppCompatActivity {
    TextView txtfavTitle, txtfavDate, txtfavOverview;
    ImageView img;
    Button btn_fav_fav;
    String titlefav, datefav, overviewfav, imagefav;
    Bundle bundlefav;
    RealmHelper realmHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_detail);
        txtfavTitle = findViewById(R.id.txt_title_fav);
        txtfavDate = findViewById(R.id.txt_format_fav);
        txtfavOverview = findViewById(R.id.txt_fav_overview);
        img = findViewById(R.id.img_detailfav);



        

        bundlefav = getIntent().getExtras();
        if (bundlefav != null){
            titlefav = bundlefav.getString("titlefav");
            imagefav = bundlefav.getString("imagefav");
            overviewfav = bundlefav.getString("overviewfav");
            datefav = bundlefav.getString("datefav");
        }
        txtfavTitle.setText(titlefav);
        txtfavOverview.setText(overviewfav);
        txtfavDate.setText(datefav);
        Picasso.get().load(imagefav).into(img);




    }
}