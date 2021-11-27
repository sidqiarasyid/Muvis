package com.danta.sidqi.projectptsxi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView txtDtlTitle, txtDtlDate, txtDtlOverview;
    ImageView img;
    Button btn_fav;
    String title, date, overview, image;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        txtDtlTitle = findViewById(R.id.txt_detail_ttl);
        txtDtlDate = findViewById(R.id.txt_detail_format);
        btn_fav = findViewById(R.id.btn_fav);
        img = findViewById(R.id.img_detail);
        txtDtlOverview = findViewById(R.id.txt_detail_overview);

        bundle = getIntent().getExtras();
        if (bundle != null){
            title = bundle.getString("title");
            date = bundle.getString("date");
            overview = bundle.getString("overview");
            image = bundle.getString("image");


        }
        txtDtlTitle.setText(title);
        txtDtlDate.setText(date);
        txtDtlOverview.setText(overview);
        Picasso.get().load(image).into(img);

        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model model = new Model(title, image,date, overview, false);
                RealmHelper.save(model);
                Toast.makeText(DetailActivity.this, "Added to favorite", Toast.LENGTH_SHORT).show();
            }
        });
    }
}