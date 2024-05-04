package com.uc2.dzprostatecare.ui.fragment.Pathway;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Advice;
import com.uc2.dzprostatecare.pojo.Consultation;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.Test;
import com.uc2.dzprostatecare.ui.adapter.ConsultationAdapter;
import com.uc2.dzprostatecare.ui.adapter.TestAdapter;

import java.util.ArrayList;


public class FollowUpFragment extends Fragment {

    private ArrayList<Consultation> consultations;
    private ArrayList<Consultation> advices;

    private RecyclerView recyclerViewCons;
    private RecyclerView.Adapter mAdapterCons;
    private RecyclerView.LayoutManager mLayoutManagerCons;

    private RecyclerView recyclerViewAdv;
    private RecyclerView.Adapter mAdapterAdv;
    private RecyclerView.LayoutManager mLayoutManagerAdv;
    int idp;


    public FollowUpFragment() {
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
        View view=inflater.inflate(R.layout.fragment_follow_up, container, false);

        Intent i = getActivity().getIntent();

        //Patient p= (Patient) i.getSerializableExtra("patient");

        Bundle b=i.getExtras();
        idp=b.getInt("id");




        consultations=new ArrayList<>();
        consultations.add(new Consultation(5,R.drawable.ic_pill,"Thursday, July 15","Not Yet","First Checkup"));
        consultations.add(new Consultation(6,R.drawable.ic_pill,"Thursday, August 12","Not Yet","Second Checkup"));
        consultations.add(new Consultation(7,R.drawable.ic_pill,"Monday, Sep 20","Not Yet","Third Checkup"));

        advices=new ArrayList<>();
        advices.add(new Consultation(8,R.drawable.ic_pill,"Important","Details","Prepare Questions"));
        advices.add(new Consultation(9,R.drawable.ic_pill,"Should","Details","Track symptoms"));
        advices.add(new Consultation(10,R.drawable.ic_pill,"Optional","Details","Eat healthy food"));


        recyclerViewCons = view.findViewById(R.id.recycler_follow_up_consultations);
        recyclerViewCons.setHasFixedSize(true);
        mLayoutManagerCons = new LinearLayoutManager(getActivity());
        mAdapterCons = new ConsultationAdapter(consultations);
        recyclerViewCons.setLayoutManager(mLayoutManagerCons);
        recyclerViewCons.setAdapter(mAdapterCons);

        recyclerViewAdv = view.findViewById(R.id.recycler_follow_up_advices);
        recyclerViewAdv.setHasFixedSize(true);
        mLayoutManagerAdv = new LinearLayoutManager(getActivity());
        mAdapterAdv = new ConsultationAdapter(advices);
        recyclerViewAdv.setLayoutManager(mLayoutManagerAdv);
        recyclerViewAdv.setAdapter(mAdapterAdv);


        return view;
    }
}
