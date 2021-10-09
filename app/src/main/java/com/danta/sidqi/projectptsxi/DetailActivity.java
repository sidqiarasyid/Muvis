package com.danta.sidqi.projectptsxi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView txtDtlTitle, txtDtlDate, txtDtlOverview;
    Button btn_fav;
    String title, date, overview;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtDtlTitle = findViewById(R.id.txt_detail_ttl);
        txtDtlDate = findViewById(R.id.txt_detail_date);
        txtDtlOverview = findViewById(R.id.txt_overview_home);

        bundle = getIntent().getExtras();
        if (bundle != null){
            title = bundle.getString("title");
            date = bundle.getString("date");
            overview = bundle.getString("overview");

        }
        txtDtlTitle.setText(title);
        txtDtlDate.setText(date);
        txtDtlOverview.setText(overview);

        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model model = new Model(title, date, overview);
                RealmHelper.save(model);
            }
        });
    }
}