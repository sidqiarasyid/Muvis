package com.danta.sidqi.projectptsxi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import io.realm.Realm;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {
    List<Model> list;
    public FavAdapter (List<Model> list){
        this.list = list;
    }

    @NonNull
    @Override
    public FavAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.favorite_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.ViewHolder holder, int position) {
        Model model = list.get(position);
        holder.txtfavttl.setText(model.getOriginal_title());
        holder.txtfavformat.setText(model.getRelease_date());
        Picasso.get().load(model.getPoster_path()).into(holder.img);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pass = new Intent(v.getContext(), FavDetail.class);
                pass.putExtra("titlefav", model.getOriginal_title());
                pass.putExtra("imagefav", model.getPoster_path());
                pass.putExtra("overviewfav", model.getOverview());
                pass.putExtra("datefav", model.getRelease_date());
                v.getContext().startActivity(pass);
            }
        });



    }

    @Override
    public int getItemCount() {
        return  (list != null) ? list.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtfavttl, txtfavformat;
        ImageView img;
        CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtfavttl = itemView.findViewById(R.id.txt_fav_ttl);
            txtfavformat = itemView.findViewById(R.id.txt_fav_format);
            img = itemView.findViewById(R.id.img_fav);
            card = itemView.findViewById(R.id.card_fav);

        }
    }
}
