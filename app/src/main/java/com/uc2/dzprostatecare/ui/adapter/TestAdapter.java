package com.uc2.dzprostatecare.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.InfoPathwayDialog;
import com.uc2.dzprostatecare.pojo.TestResult;
import com.uc2.dzprostatecare.ui.activities.PdfCreatorActivity;


import java.util.ArrayList;


public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ExampleViewHolder> {
    private ArrayList<TestResult> items;
    public static Context context;
    private TestAdapter.OnItemLongClickListener mListner;
    public interface OnItemLongClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListner(TestAdapter.OnItemLongClickListener listner){
        mListner=listner;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView date_test;
        public ImageView test_image;
        public TextView test_title;
        public TextView test_notes;
        public TextView test_status;
        public TextView test_value;
        public TextView test_result_type;
        public ImageView pdf,info;
        public ExampleViewHolder(View itemView, final OnItemLongClickListener listener) {
            super(itemView);
            date_test=itemView.findViewById(R.id.date);
            test_image=itemView.findViewById(R.id.test_image);
            test_title=itemView.findViewById(R.id.test_title);
            test_notes=itemView.findViewById(R.id.test_notes);
            test_status=itemView.findViewById(R.id.test_status);
            test_value=itemView.findViewById(R.id.test_value);
            test_result_type=itemView.findViewById(R.id.test_result_text);
            pdf=itemView.findViewById(R.id.get_report_mri);
            info=itemView.findViewById(R.id.info);






            pdf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  //  Intent intent=new Intent(view.getContext(), ContactDoctor.class);

                    //startActivity(new Intent(, PdfCreatorActivity.class));

                    Intent intent = new Intent(context,PdfCreatorActivity.class);
                    // intent.putExtra(RequestParamUtils.FEATURE, true);
                    context.startActivity(intent);

                }
            });
        }
    }

    public TestAdapter(ArrayList<TestResult> items, Context context) {
        this.items = items;
        this.context=context;
    }
    @Override
    public TestAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item, parent, false);
        TestAdapter.ExampleViewHolder evh = new TestAdapter.ExampleViewHolder(v,mListner);
        return evh;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(TestAdapter.ExampleViewHolder holder, int position) {
        TestResult currentItem = items.get(position);
        String status=items.get(position).getStatus();
        if(status.equals("Completed"))
        {
            holder.date_test.setText(items.get(position).getReturndate());
        }else
            if(status.equals("In Progress"))
            {
                holder.date_test.setText(items.get(position).getDueon());
            }
            else
                if(status.equals("Out Dated"))
                {
                    holder.date_test.setTextColor(R.color.red_50);
                    holder.date_test.setText(items.get(position).getDueon());
                }

        holder.test_image.setBackgroundResource(items.get(position).getTest().getPicId());
        holder.test_title.setText(items.get(position).getTest().getTestName());
        holder.test_notes.setText(items.get(position).getNotes());
        holder.test_status.setText(items.get(position).getStatus());
        if(items.get(position).getTest().getTestName().equals("mpMRI") || items.get(position).getTest().getTestName().equals("MRI")||
                items.get(position).getTest().getTestName().equals("Biopsy") || items.get(position).getTest().getTestName().equals("DRE"))
        {
            holder.test_value.setText(items.get(position).getTest().getTestUnit()+" "+String.valueOf(items.get(position).getValue()));
        }
        else {
            holder.test_value.setText(String.valueOf(items.get(position).getValue())+" "+items.get(position).getTest().getTestUnit());
        }

        if(items.get(position).getValue().equals("-"))
        {
            holder.pdf.setVisibility(View.INVISIBLE);
            holder.info.setVisibility(View.INVISIBLE);
        }
        else
        {
            holder.pdf.setVisibility(View.VISIBLE);
            holder.info.setVisibility(View.VISIBLE);
        }
        holder.test_result_type.setText("Value");

        holder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                InfoPathwayDialog infoPathwayDialog=new InfoPathwayDialog(v.getContext());
                infoPathwayDialog.showInfoDialog(items.get(position).getTest().getTestName(),items.get(position).getTest().getTestDescription(),items.get(position).getTest().getPicId());

            }
        });


    }
    @Override
    public int getItemCount() {
        return items.size();
    }

}

