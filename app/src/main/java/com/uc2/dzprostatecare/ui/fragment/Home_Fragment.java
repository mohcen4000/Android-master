package com.uc2.dzprostatecare.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.ui.Symptom;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.Suggestion;
import com.uc2.dzprostatecare.ui.activities.Advices;
import com.uc2.dzprostatecare.ui.activities.Appoin;
import com.uc2.dzprostatecare.ui.activities.AskMe;
import com.uc2.dzprostatecare.ui.activities.LearnAbout1;
import com.uc2.dzprostatecare.ui.activities.MainActivity;
import com.uc2.dzprostatecare.ui.activities.Pathway;
import com.uc2.dzprostatecare.ui.activities.QuestionActivity;
import com.uc2.dzprostatecare.ui.adapter.AdapterSuggestion;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {

    AdapterSuggestion suggestionAdapter;
    RecyclerView suggestionRecycler;
    ArrayList<Suggestion> suggestionList = new ArrayList<>();
    Patient p;


    LinearLayout question,appointment,meet,symptom,pathway,askme,learnabout,advices;

    int id;



    public Home_Fragment() {
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

        View view=inflater.inflate(R.layout.fragment_home_, container, false);

        Intent i = getActivity().getIntent();

        //p= (Patient) i.getSerializableExtra("patient");

        Bundle b=i.getExtras();

        id=b.getInt("id");


        question=view.findViewById(R.id.question_list);
        appointment=view.findViewById(R.id.appointment_list);
        symptom=view.findViewById(R.id.symptoms_list);
        meet=view.findViewById(R.id.messages_list);
        pathway=view.findViewById(R.id.pathway);
        askme=view.findViewById(R.id.askme);
        learnabout=view.findViewById(R.id.learnAbout);
        advices=view.findViewById(R.id.advices);


        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), QuestionActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
                //bundle.putSerializable("patient",p);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        symptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Symptom.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
                //bundle.putSerializable("patient",p);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        askme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AskMe.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
                //bundle.putSerializable("patient",p);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        pathway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Pathway.class);
                Bundle bundle=new Bundle();
                //bundle.putSerializable("patient",p);
                bundle.putInt("id",id);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        advices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Advices.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
                //bundle.putSerializable("patient",p);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        learnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MainActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
                //bundle.putSerializable("patient",p);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

       appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Appoin.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
               //bundle.putSerializable("patient",p);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        meet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LearnAbout1.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
                //bundle.putSerializable("patient",p);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        suggestionList.add(new Suggestion("Welcome","Please visit the help center to know how to use proman","new",70,id));
        suggestionList.add(new Suggestion("Complete profile","Personalise your information : Complete your profile","new",70,id));
        suggestionList.add(new Suggestion("Add your Physical Data","Visualise your vital sign, add th","new",70,id));
        suggestionList.add(new Suggestion("Diary","Get organise : consult your diary list","new",70,id));
        suggestionList.add(new Suggestion("Eat Healthy food","Get daily meals : be healthy","new",70,id));
        suggestionList.add(new Suggestion("Learn About PCa","Learn more about prostate cancer","new",70,id));
        suggestionRecycler=view.findViewById(R.id.suggestion_recycler);
        setSuggestionRecycler(suggestionList,suggestionRecycler);

        return view;
    }



    private  void setSuggestionRecycler(ArrayList<Suggestion> suggestionsDataList, RecyclerView suggestionRecycler){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        suggestionRecycler .setLayoutManager(layoutManager);
        suggestionAdapter = new AdapterSuggestion(suggestionsDataList);
        suggestionRecycler.setAdapter(suggestionAdapter);

    }
}