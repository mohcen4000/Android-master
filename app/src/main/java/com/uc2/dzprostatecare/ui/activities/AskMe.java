package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.ui.TreatmentPlans;
import com.uc2.dzprostatecare.pojo.Patient;

public class AskMe extends AppCompatActivity {

    LinearLayout treatment,info,lifestyle,living;
    Patient p;
    ImageView askback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_me);

        treatment=findViewById(R.id.treatment_plans);
        info=findViewById(R.id.general_info);
        lifestyle=findViewById(R.id.lifestyle);
        living=findViewById(R.id.living_with_pca);
        askback=findViewById(R.id.aske_back);

        treatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AskMe.this, TreatmentPlans.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AskMe.this,MainActivity.class);
                startActivity(intent);
            }
        });

        lifestyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AskMe.this,FoodActivity.class);
                startActivity(intent);
            }
        });

        askback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       living.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AskMe.this,PsycologicalCare.class);
                startActivity(intent);
            }
        });


    }
}