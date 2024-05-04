package com.uc2.dzprostatecare.ui.fragment.Pathway;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.Question;
import com.uc2.dzprostatecare.ui.adapter.QuestionAdapter;
import com.uc2.dzprostatecare.ui.adapter.TestAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyQuestion extends Fragment {

    QuestionAdapter questionAdapter;
    RecyclerView questionRecycler;

    ArrayList<Question> qst;

    int id_patient,question_id,q_status;
    String q_answer, date_asked, date_answered,q_title;
    private ProgressBar progressBar;

    Patient p;

    int idp;




    public MyQuestion() {
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
        View view=inflater.inflate(R.layout.fragment_my_question, container, false);

        Intent i = getActivity().getIntent();
        //p= (Patient) i.getSerializableExtra("patient");
        Bundle b=i.getExtras();
        idp=b.getInt("id");



       //Toast.makeText(getContext(), p.getId()+"", Toast.LENGTH_SHORT).show();

        questionRecycler=view.findViewById(R.id.question_recycler);





        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getData(idp);

    }

    private void setQuestionRecycler(ArrayList<Question> questionDataList, RecyclerView questionRecycler){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        questionRecycler.setLayoutManager(layoutManager);
        questionAdapter = new QuestionAdapter( questionDataList,getContext());

        questionAdapter.notifyDataSetChanged();
        questionRecycler.setAdapter(questionAdapter);

    }

    private void getData(int idd) {}

}