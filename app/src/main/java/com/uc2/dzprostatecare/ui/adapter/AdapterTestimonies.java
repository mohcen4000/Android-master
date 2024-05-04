package com.uc2.dzprostatecare.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Testimony;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterTestimonies extends RecyclerView.Adapter<AdapterTestimonies.ExampleViewHolder> {
    private List<Testimony> items;
    public static Context context;
    private AdapterTestimonies.OnItemLongClickListener mListner;
    public interface OnItemLongClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListner(AdapterTestimonies.OnItemLongClickListener listner){
        mListner=listner;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView img;
        public TextView name;


        public ExampleViewHolder(View itemView, final OnItemLongClickListener listener) {
            super(itemView);

            img=itemView.findViewById(R.id.profile_image);
            name=itemView.findViewById(R.id.name_testi);






        }
    }

    public AdapterTestimonies(ArrayList<Testimony> items, Context context) {
        this.items = items;
        this.context=context;
    }
    @Override
    public AdapterTestimonies.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_testimony, parent, false);
        AdapterTestimonies.ExampleViewHolder evh = new AdapterTestimonies.ExampleViewHolder(v,mListner);
        return evh;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull AdapterTestimonies.ExampleViewHolder holder, int position) {

    holder.img.setImageResource(items.get(position).getItemID());
    holder.name.setText(items.get(position).getName());





    }
    @Override
    public int getItemCount() {
        return items.size();
    }


}
