package com.uc2.dzprostatecare.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.InfoPathwayDialog;

public class TreatmentPlans extends AppCompatActivity {

    int idp;
    TextView surgery,hormonal,radiation,chemeo,immun,bispho;
    RelativeLayout sur,hor,rad,chem,imm,bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_plans);

        surgery=findViewById(R.id.details11);
        hormonal=findViewById(R.id.details12);
        radiation=findViewById(R.id.details13);
        chemeo=findViewById(R.id.details14);
        immun=findViewById(R.id.details15);
        bispho=findViewById(R.id.details16);

        sur=findViewById(R.id.surg);
        hor=findViewById(R.id.hor);
        rad=findViewById(R.id.rad);
        chem=findViewById(R.id.chemo);
        imm=findViewById(R.id.imm);
        bi=findViewById(R.id.bis);

        bi.setVisibility(View.GONE);
        imm.setVisibility(View.GONE);
        sur.setVisibility(View.GONE);

        surgery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoPathwayDialog infoPathwayDialog=new InfoPathwayDialog(v.getContext());
                infoPathwayDialog.showInfoDialog("Surgery","This treatment is 85% suitable for you",R.drawable.ic_pill);
            }
        });
        hormonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoPathwayDialog infoPathwayDialog=new InfoPathwayDialog(v.getContext());
                infoPathwayDialog.showInfoDialog("Hormonal Therapy","This treatment is 80% suitable for you",R.drawable.ic_pill);
            }
        });

        radiation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoPathwayDialog infoPathwayDialog=new InfoPathwayDialog(v.getContext());
                infoPathwayDialog.showInfoDialog("Radiation therapy","This treatment is 70% suitable for you",R.drawable.ic_pill);

            }
        });

        chemeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoPathwayDialog infoPathwayDialog=new InfoPathwayDialog(v.getContext());
                infoPathwayDialog.showInfoDialog("Chemotherapy","This treatment is 50% suitable for you",R.drawable.ic_pill);

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
    }
}