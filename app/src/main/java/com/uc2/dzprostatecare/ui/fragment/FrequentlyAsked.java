package com.uc2.dzprostatecare.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Question;
import com.uc2.dzprostatecare.ui.adapter.QuestionAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class FrequentlyAsked extends Fragment {

    QuestionAdapter questionAdapter;
    RecyclerView questionRecycler;
    ArrayList<Question> qst;

    int idp;


    int id_patient,question_id,q_status;
    String q_answer, date_asked, date_answered,q_title;

    ArrayList<Question> questions;


    public FrequentlyAsked() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_frequently_asked, container, false);

        questions=new ArrayList<>();

        Intent i = getActivity().getIntent();
        //p= (Patient) i.getSerializableExtra("patient");
        Bundle b=i.getExtras();
        idp=b.getInt("id");

      //  questions.add(new Question("How common is prostate cancer?","02/06/2021","answered",""));
      //  questions.add(new Question("How does prostate cancer compare with other cancers?","02/06/2021","answered",""));
       // questions.add(new Question("Are some men more likely to be diagnosed with prostate cancer?","02/06/2021","answered",""));
        questions.add(new Question(1,"How curable is prostate cancer? How curable is prostate cancer? How curable is prostate cancer?","02/06/2021","faq","",""));
        questions.add(new Question( 2,"How curable is prostate cancer?","02/06/2021","faq","",""));
        questions.add(new Question(3,"How curable is prostate cancer?","02/06/2021","faq","",""));
        //questions.add(new Question("What are the symptoms of prostate cancer?","02/06/2021","answered",""));
        questions.add(new Question(4,"How is prostate cancer treated?","02/06/2021","faq","",""));


        questionRecycler=view.findViewById(R.id.frequently_recycler);
        //setQuestionRecycler(questions,questionRecycler);



        getData(112);


        return view;
    }

    private  void setQuestionRecycler(ArrayList<Question> questionDataList, RecyclerView questionRecycler){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        questionRecycler.setLayoutManager(layoutManager);
        questionAdapter = new QuestionAdapter( questionDataList,getContext());
        questionRecycler.setAdapter(questionAdapter);

    }

    private void getData(int idd) {}
}