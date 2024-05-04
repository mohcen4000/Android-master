package com.uc2.dzprostatecare.ui.fragment.Pathway;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.InfoPathwayDialog;
import com.uc2.dzprostatecare.pojo.Patient;

public class TreatmentFragment extends Fragment {

    int idp;
    TextView surgery,hormonal,radiation,chemeo,immun,bispho;
    RelativeLayout sur,hor,rad,chem,imm,bi;


    public TreatmentFragment() {
        // Required empty public constructor
    }
    TextView tx1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_treatment, container, false);

        Intent i = getActivity().getIntent();

        Bundle b=i.getExtras();

        surgery=view.findViewById(R.id.details1);
        hormonal=view.findViewById(R.id.details2);
        radiation=view.findViewById(R.id.details3);
        chemeo=view.findViewById(R.id.details4);
        immun=view.findViewById(R.id.details5);
        bispho=view.findViewById(R.id.details6);

        sur=view.findViewById(R.id.s);
        hor=view.findViewById(R.id.h);
        rad=view.findViewById(R.id.r);
        chem=view.findViewById(R.id.c);
        imm=view.findViewById(R.id.i);
        bi=view.findViewById(R.id.b);

        bispho.setVisibility(View.GONE);
        imm.setVisibility(View.GONE);
        sur.setVisibility(View.GONE);

        surgery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoPathwayDialog infoPathwayDialog=new InfoPathwayDialog(v.getContext());
                infoPathwayDialog.showInfoDialog("Surgery","",R.drawable.ic_pill);
            }
        });
        hormonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoPathwayDialog infoPathwayDialog=new InfoPathwayDialog(v.getContext());
                infoPathwayDialog.showInfoDialog("Hormonal Therapy","",R.drawable.ic_pill);
            }
        });

        radiation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoPathwayDialog infoPathwayDialog=new InfoPathwayDialog(v.getContext());
                infoPathwayDialog.showInfoDialog("Radiation therapy","",R.drawable.ic_pill);

            }
        });

        chemeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoPathwayDialog infoPathwayDialog=new InfoPathwayDialog(v.getContext());
                infoPathwayDialog.showInfoDialog("Chemotherapy","",R.drawable.ic_pill);

            }
        });

        immun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoPathwayDialog infoPathwayDialog=new InfoPathwayDialog(v.getContext());
                infoPathwayDialog.showInfoDialog("Immunotherapy","",R.drawable.ic_pill);

            }
        });

        bispho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoPathwayDialog infoPathwayDialog=new InfoPathwayDialog(v.getContext());
                infoPathwayDialog.showInfoDialog("Bisphosphona","",R.drawable.ic_pill);
            }
        });







        idp=b.getInt("id");



        tx1=view.findViewById(R.id.current_treatmentnote);
        tx1.setText("Currently you are in the treatment");
        return view;
    }
}
