package com.uc2.dzprostatecare.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Article;
import com.uc2.dzprostatecare.ui.activities.MainActivity;


import java.util.List;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder> {

    Context context;
    List<Article> articleList;



    public RecentsAdapter(MainActivity context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recent_row_item, parent, false);

        // here we create a recyclerview row item layout file
        return new RecentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {

/*        holder.countryName.setText(recentsDataList.get(position).getCountryName());
        holder.placeName.setText(recentsDataList.get(position).getPlaceName());
        holder.price.setText(recentsDataList.get(position).getPrice());
        holder.placeImage.setImageResource(recentsDataList.get(position).getImageUrl());*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public static final class RecentsViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, countryName, price;

        public RecentsViewHolder(@NonNull View itemView) {
            super(itemView);

            /*placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.subject_title);
            countryName = itemView.findViewById(R.id.country_name);
            price = itemView.findViewById(R.id.price);*/

        }
    }
}
