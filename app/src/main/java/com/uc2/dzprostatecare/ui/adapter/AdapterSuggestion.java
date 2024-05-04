package com.uc2.dzprostatecare.ui.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.uc2.dzprostatecare.ui.activities.EditProfile;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Suggestion;
import com.uc2.dzprostatecare.ui.activities.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class AdapterSuggestion extends RecyclerView.Adapter<AdapterSuggestion.ExampleViewHolder> {

    List<Suggestion> items;
    Intent intent;
    private AdapterSuggestion.OnItemLongClickListener mListner;

    public interface OnItemLongClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListner(AdapterSuggestion.OnItemLongClickListener listner){
        mListner=listner;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        TextView title,content,sugguestion;
        Button btn;
        public ExampleViewHolder(View itemView, final OnItemLongClickListener listener) {
            super(itemView);
           title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            sugguestion=itemView.findViewById(R.id.delete_sugguestion);
            btn=itemView.findViewById(R.id.btn_title);
        }
    }

    public AdapterSuggestion(ArrayList<Suggestion> items) {
        this.items = items;
        this.intent=intent;
    }
    @Override
    public AdapterSuggestion.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_suggestion, parent, false);
        AdapterSuggestion.ExampleViewHolder evh = new AdapterSuggestion.ExampleViewHolder(v,mListner);
        return evh;
    }
    @Override
    public void onBindViewHolder(AdapterSuggestion.ExampleViewHolder holder, int position) {
        Suggestion currentItem = items.get(position);
        holder.content.setText(currentItem.getContent());
        holder.title.setText(currentItem.getTitle());
        holder.sugguestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), position+"", Toast.LENGTH_SHORT).show();
               // items.remove(currentItem);

            }
        });


        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), currentItem.getTitle()+"", Toast.LENGTH_SHORT).show();
                if(currentItem.getTitle().equals("Complete profile"))
                {
                    Intent intent=new Intent(v.getContext(), EditProfile.class);
                    Bundle b=new Bundle();
                    b.putInt("id",currentItem.getIdp());
                    intent.putExtras(b);
                    v.getContext().startActivity(intent);
                }
                if(currentItem.getTitle().equals("Welcome"))
                {
                    /*Intent intent=new Intent(v.getContext(), EditProfile.class);
                    Bundle b=new Bundle();
                    b.putInt("id",currentItem.getIdp());
                    intent.putExtras(b);
                    v.getContext().startActivity(intent);*/
                }
                if(currentItem.getTitle().equals("Learn About PCa"))
                {
                    Intent intent=new Intent(v.getContext(), MainActivity.class);
                    Bundle b=new Bundle();
                    b.putInt("id",currentItem.getIdp());
                    intent.putExtras(b);
                    v.getContext().startActivity(intent);
                }
            }
        });




    }
    @Override
    public int getItemCount() {
        return items.size();
    }

}


