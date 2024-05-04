package com.uc2.dzprostatecare.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Appointment;
import com.uc2.dzprostatecare.pojo.Symptomm;
import com.uc2.dzprostatecare.ui.Symptom;
import com.uc2.dzprostatecare.ui.activities.ModifyAppointment;
import com.uc2.dzprostatecare.ui.activities.ModifySymptom;

import java.util.ArrayList;

public class SymptomAdapter extends RecyclerView.Adapter<SymptomAdapter.SymptomViewHolder> {

    private ArrayList<Symptomm> items;
    public static Context context;
    private SymptomAdapter.OnItemLongClickListener mListner;


    public interface OnItemLongClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListner(SymptomAdapter.OnItemLongClickListener listner) {
        mListner = listner;
    }

    public static class SymptomViewHolder extends RecyclerView.ViewHolder {
        public TextView date_symptom;
        public TextView name_symptom;
        public TextView severity_symptom;
        LinearLayout itm;

        public SymptomViewHolder(View itemView, final SymptomAdapter.OnItemLongClickListener listener) {
            super(itemView);
            date_symptom = itemView.findViewById(R.id.symptom_date);
            name_symptom = itemView.findViewById(R.id.symptom_title);
            severity_symptom = itemView.findViewById(R.id.sym_status);
            itm=itemView.findViewById(R.id.sym_item);



        }
    }

    public SymptomAdapter(ArrayList<Symptomm> items,Context context) {
        this.items = items;
        this.context=context;
    }

    @Override
    public SymptomAdapter.SymptomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_symptom, parent, false);
        SymptomAdapter.SymptomViewHolder evh = new SymptomAdapter.SymptomViewHolder(v, mListner);
        return evh;
    }

    @Override
    public void onBindViewHolder(SymptomAdapter.SymptomViewHolder holder, int position) {
        Symptomm currentItem = items.get(position);

        ArrayList<Integer> color;
        color=new ArrayList<>();
        color.add(R.drawable.item_1);
        color.add(R.drawable.item_4);
        color.add(R.drawable.item_3);
        color.add(R.drawable.item_2);
        int max=3;
        int min=0;

        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        holder.date_symptom.setText(items.get(position).getDate());
        holder.name_symptom.setText(items.get(position).getName());
        holder.severity_symptom.setText(items.get(position).getSeverity());

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

                Symptomm sy=items.get(position);
                Intent intent=new Intent(holder.itemView.getContext(), ModifySymptom.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("sy",sy);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
