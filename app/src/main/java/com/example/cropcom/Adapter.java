package com.example.cropcom;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<String> titles, descriptions, imageUrls;

    public  Adapter(Context context, List<String> titles, List<String> descriptions, List<String> imageUrls){
        this.inflater = LayoutInflater.from(context);
        this.titles = titles;
        this.descriptions = descriptions;
        this.imageUrls = imageUrls;

        Log.d("TAG", "Adapter: " + titles);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    String title = titles.get(position);
    String desc = descriptions.get(position);
    String img = imageUrls.get(position);

    holder.title.setText(title);
    holder.content.setText(desc);
        Picasso.get().load(img).into(holder.listImg);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView listImg;
        TextView title, content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listImg = itemView.findViewById(R.id.listImage);
            title = itemView.findViewById(R.id.dataTitle);
            content = itemView.findViewById(R.id.dataDescriptions);


        }
    }
}
