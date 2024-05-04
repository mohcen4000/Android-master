package com.uc2.dzprostatecare.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Appointment;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.RequestHandler;
import com.uc2.dzprostatecare.ui.activities.Appoin;
import com.uc2.dzprostatecare.ui.activities.ModifyAppointment;
import com.uc2.dzprostatecare.ui.activities.ModifyQuestion;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ExampleViewHolder> {
    private List<Appointment> items;
    public static Context context;
    private AppointmentAdapter.OnItemLongClickListener mListner;
    public interface OnItemLongClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListner(AppointmentAdapter.OnItemLongClickListener listner){
        mListner=listner;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView appoint_type;
        public TextView appoint_date;
        public TextView appoint_status;
        LinearLayout itm;

        public ExampleViewHolder(View itemView, final OnItemLongClickListener listener) {
            super(itemView);
            appoint_type=itemView.findViewById(R.id.appointment_title);
            appoint_date=itemView.findViewById(R.id.appointment_date);
            appoint_status=itemView.findViewById(R.id.appointment_status);
            itm=itemView.findViewById(R.id.appoin_item);




        }
    }

    public AppointmentAdapter(ArrayList<Appointment> items, Context context) {
        this.items = items;
        this.context=context;
    }
    @Override
    public AppointmentAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment, parent, false);
        AppointmentAdapter.ExampleViewHolder evh = new AppointmentAdapter.ExampleViewHolder(v,mListner);
        return evh;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull AppointmentAdapter.ExampleViewHolder holder, @SuppressLint("RecyclerView") int position) {


        ArrayList<Integer> color;
        color=new ArrayList<>();
        color.add(R.drawable.item_1);
        color.add(R.drawable.item_4);
        color.add(R.drawable.item_3);
        color.add(R.drawable.item_2);
        int max=3;
        int min=0;

        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        holder.appoint_type.setText(items.get(position).getType());
        String d="";
        Toast.makeText(context, items.get(position).getStatus()+"", Toast.LENGTH_SHORT).show();
        if(items.get(position).getStatus().equals("0"))
        { d=  items.get(position).getBookedOn(); }
        else
        { d=  items.get(position).getScheduledOn(); }



        holder.appoint_date.setText(d);
        holder.appoint_type.setText(items.get(position).getType());


        holder.itm.setBackground(ContextCompat.getDrawable(context, color.get(random_int)));
        color.remove(random_int);
        if(color.size()==0)
        {
            color.add(R.drawable.item_1);
            color.add(R.drawable.item_4);
            color.add(R.drawable.item_3);
            color.add(R.drawable.item_2);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Appointment ap=items.get(position);
                Intent intent=new Intent(holder.itemView.getContext(), ModifyAppointment.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("app",ap);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    private void deleteAppoint(int id,View v) {}

}
