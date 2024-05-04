package com.uc2.dzprostatecare.ui.adapter;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.uc2.dzprostatecare.pojo.Consultation;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Question;
import com.uc2.dzprostatecare.ui.activities.ModifyQuestion;

import java.util.ArrayList;
import java.util.List;


public class ConsPeriodAdapter extends RecyclerView.Adapter<ConsPeriodAdapter.ExampleViewHolder> {

    List<Consultation> items;
    private ConsPeriodAdapter.OnItemLongClickListener mListner;

    public interface OnItemLongClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListner(ConsPeriodAdapter.OnItemLongClickListener listner){
        mListner=listner;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        TextView EventType, time;
        ImageView im;
        public ExampleViewHolder(View itemView, final OnItemLongClickListener listener) {
            super(itemView);
            EventType = itemView.findViewById(R.id.consperiod);
            time = itemView.findViewById(R.id.peri);
            im=itemView.findViewById(R.id.eventtype);

        }
    }

    public ConsPeriodAdapter(ArrayList<Consultation> items) {
        this.items = items;
    }
    @Override
    public ConsPeriodAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diary, parent, false);
        ConsPeriodAdapter.ExampleViewHolder evh = new ConsPeriodAdapter.ExampleViewHolder(v,mListner);
        return evh;
    }
    @Override
    public void onBindViewHolder(ConsPeriodAdapter.ExampleViewHolder holder, int position) {
        Consultation currentItem = items.get(position);

        holder.EventType.setText(items.get(position).getName());
        holder.time.setText(items.get(position).getDate());
        holder.im.setImageResource(items.get(position).itemID);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure to Confirm that you make this event?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing, but close the dialog

                        confirmEvent(items.get(position).getIdConsultation(),v);



                        dialog.dismiss();
                        //  finish();

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing

                        dialog.dismiss();
                        //finish();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();


            }
        });
    }

    private void confirmEvent(int idConsultation, View v) {
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}


