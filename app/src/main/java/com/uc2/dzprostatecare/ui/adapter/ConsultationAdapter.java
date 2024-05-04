package com.uc2.dzprostatecare.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Consultation;

import java.util.ArrayList;

public class ConsultationAdapter extends RecyclerView.Adapter<ConsultationAdapter.ProstateCancerViewHolder> {

    private ArrayList<Consultation> items;
    private TestAdapter.OnItemLongClickListener mListner;

    public interface OnItemLongClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListner(TestAdapter.OnItemLongClickListener listner) {
        mListner = listner;
    }

    public static class ProstateCancerViewHolder extends RecyclerView.ViewHolder {
        public TextView date_consultation;
        public TextView name_consultation;
        public TextView detail_consultation;

        public ProstateCancerViewHolder(View itemView, final TestAdapter.OnItemLongClickListener listener) {
            super(itemView);
            date_consultation = itemView.findViewById(R.id.consultation_date);
            name_consultation = itemView.findViewById(R.id.consul_follow_up);
            detail_consultation = itemView.findViewById(R.id.details1);



        }
    }

    public ConsultationAdapter(ArrayList<Consultation> items) {
        this.items = items;
    }

    @Override
    public ConsultationAdapter.ProstateCancerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.consultation_item, parent, false);
        ConsultationAdapter.ProstateCancerViewHolder evh = new ConsultationAdapter.ProstateCancerViewHolder(v, mListner);
        return evh;
    }

    @Override
    public void onBindViewHolder(ConsultationAdapter.ProstateCancerViewHolder holder, int position) {
        Consultation currentItem = items.get(position);

        holder.date_consultation.setText(items.get(position).getDate());
        holder.name_consultation.setText(items.get(position).getName());
        holder.detail_consultation.setText(items.get(position).getSummary());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
