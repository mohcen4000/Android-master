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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Article;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Question;
import com.uc2.dzprostatecare.pojo.RequestHandler;
import com.uc2.dzprostatecare.ui.activities.ModifyQuestion;
import com.uc2.dzprostatecare.ui.activities.QuestionActivity;
import com.uc2.dzprostatecare.ui.activities.learn_about_pca.InfoDetail;
import com.uc2.dzprostatecare.ui.fragment.Pathway.MyQuestion;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ExampleViewHolder> {
    private List<Question> items;
    public static Context context;
    private QuestionAdapter.OnItemLongClickListener mListner;
    public interface OnItemLongClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListner(QuestionAdapter.OnItemLongClickListener listner){
        mListner=listner;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView question_title;
        public TextView question_date;
        public TextView question_status;
        public TextView question_txt;
        LinearLayout itm;

        public ExampleViewHolder(View itemView, final OnItemLongClickListener listener) {
            super(itemView);
            question_title=itemView.findViewById(R.id.question_title);
            question_date=itemView.findViewById(R.id.question_date);
            question_status=itemView.findViewById(R.id.question_status);
            question_txt=itemView.findViewById(R.id.date_txt);
            itm=itemView.findViewById(R.id.qst_item);




        }
    }

    public QuestionAdapter(ArrayList<Question> items, Context context) {
        this.items = items;
        this.context=context;
    }
    @Override
    public QuestionAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);
        QuestionAdapter.ExampleViewHolder evh = new QuestionAdapter.ExampleViewHolder(v,mListner);
        return evh;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.ExampleViewHolder holder, int position) {




        ArrayList<Integer> color;
        color=new ArrayList<>();
        color.add(R.drawable.item_1);
        color.add(R.drawable.item_4);
        color.add(R.drawable.item_3);
        color.add(R.drawable.item_2);
        int max=3;
        int min=0;

        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        holder.question_title.setText(items.get(position).getTitle());
        holder.question_date.setText(items.get(position).getDate());
        holder.question_status.setText(items.get(position).getStatus());


        if(items.get(position).getStatus().equals("FAQ"))
        {
            holder.question_date.setText("");
            holder.question_txt.setText("");
        }
        else
        {
            holder.question_txt.setText("Date :");
        }


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

               Question qi=items.get(position);
                Intent intent=new Intent(holder.itemView.getContext(), ModifyQuestion.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("qst",qi);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);
            }
        });

       /* holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if(!items.get(position).getStatus().equals("FAQ")) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                    builder.setTitle("Confirm");
                    builder.setMessage("Are you sure to delete this question?");

                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {

                            // Do nothing, but close the dialog
                            deleteQuestion(items.get(position).getIdQst(), v);
                            //items.remove(position);
                            Intent intent = new Intent(context, QuestionActivity.class);
                            context.startActivity(intent);
                            // items.remove(position);


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
                return false;
            }
        });*/
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    private void deleteQuestion(int id,View v) {}

}


