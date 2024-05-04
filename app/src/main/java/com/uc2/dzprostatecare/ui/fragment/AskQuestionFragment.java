package com.uc2.dzprostatecare.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.Question;
import com.uc2.dzprostatecare.pojo.Test;
import com.uc2.dzprostatecare.pojo.TestResult;
import com.uc2.dzprostatecare.ui.activities.AddNewQuestion;
import com.uc2.dzprostatecare.ui.adapter.TestAdapter;
import com.uc2.dzprostatecare.ui.adapter.ViewPagerAdapter;
import com.uc2.dzprostatecare.ui.fragment.Pathway.MyQuestion;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class AskQuestionFragment extends Fragment {

    FloatingActionButton fab;
    private TabLayout tb;
    private ViewPager vp;
    ImageView askqs;
    Patient p;




    public AskQuestionFragment() {
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
      View view=inflater.inflate(R.layout.fragment_ask_question, container, false);

       fab=view.findViewById(R.id.add);

       tb=view.findViewById(R.id.tb);
       vp=view.findViewById(R.id.vp);

       askqs=view.findViewById(R.id.add_new_question);

        Intent i = getActivity().getIntent();

        p= (Patient) i.getSerializableExtra("patient");


    createAdapter();

    tb.setupWithViewPager(vp);

       
       fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(getContext(), AddNewQuestion.class);
               startActivity(intent);
           }
       });

       askqs.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),AddNewQuestion.class);
               Bundle bundle=new Bundle();
               bundle.putSerializable("patient",p);
               intent.putExtras(bundle);
               startActivity(intent);
           }
       });


        return view;


    }

    private void createAdapter() {
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getFragmentManager());
        viewPagerAdapter.addFragment(new FrequentlyAsked(),"Frequently Asked");
        viewPagerAdapter.addFragment(new MyQuestion(),"My Questions");
        vp.setAdapter(viewPagerAdapter);

    }


}
