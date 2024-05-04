package com.uc2.dzprostatecare.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Article;
import com.uc2.dzprostatecare.ui.activities.learn_about_pca.InfoDetail;

import java.util.ArrayList;
import java.util.List;

public class ProstateCancerAdapter extends RecyclerView.Adapter<ProstateCancerAdapter.ProstateCancerViewHolder> {

    Context context;
    List<Article> prostateCancerDataList;


    public ProstateCancerAdapter(Context context, List<Article> prostateCancerDataList) {

        this.context = context;
        this.prostateCancerDataList = prostateCancerDataList;
    }

    @NonNull
    @Override
    public ProstateCancerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recent_row_item, parent, false);

        // here we create a recyclerview row item layout file
        return new ProstateCancerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProstateCancerViewHolder holder, int position) {

        holder.articleName.setText(prostateCancerDataList.get(position).getArticleName());
        holder.articleSummary.setText(prostateCancerDataList.get(position).getArticleSummary());
        //holder.articleFavorite.setImageResource(prostateCancerDataList.get(position).getImageUrl());
        holder.placeImage.setImageResource(prostateCancerDataList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Article article=prostateCancerDataList.get(position);
                Intent intent=new Intent(holder.itemView.getContext(), InfoDetail.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("art",article);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return prostateCancerDataList.size();
    }

    public static final class ProstateCancerViewHolder extends RecyclerView.ViewHolder{


        ImageView placeImage,articleFavorite;
        TextView articleName, articleSummary;


        public ProstateCancerViewHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.article_pic);
            articleName = itemView.findViewById(R.id.article_name);
            articleSummary = itemView.findViewById(R.id.article_summary);
          //  articleFavorite=itemView.findViewById(R.id.image);



        }
    }

    public void filterList(ArrayList<Article> filteredList) {
        prostateCancerDataList = filteredList;
        notifyDataSetChanged();
    }
}
