package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Appointment;
import com.uc2.dzprostatecare.pojo.Testimony;
import com.uc2.dzprostatecare.ui.adapter.AdapterTestimonies;
import com.uc2.dzprostatecare.ui.adapter.AppointmentAdapter;

import java.util.ArrayList;

public class PsycologicalCare extends AppCompatActivity {

    ImageView back;
    AdapterTestimonies testimoniesAdapter;
    RecyclerView testRecycler;
    ArrayList<Testimony> testimonies=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psycological_care);

        testRecycler=findViewById(R.id.recyclere_testimonies);

        testimonies.add(new Testimony("Alex",R.drawable.tm1,"youtube","ccc","dddd"));
        testimonies.add(new Testimony("Carry",R.drawable.tm2,"youtube","ccc","dddd"));
        testimonies.add(new Testimony("Orlex",R.drawable.tm3,"youtube","ccc","dddd"));
        setTestinomyRecycler(testimonies,testRecycler);

        back=findViewById(R.id.back_psy);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private  void setTestinomyRecycler(ArrayList<Testimony> testimonies, RecyclerView testinomyRecycler){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
        testinomyRecycler.setLayoutManager(layoutManager);
         testimoniesAdapter= new AdapterTestimonies( testimonies,getApplicationContext());
        testinomyRecycler.setAdapter(testimoniesAdapter);

    }
}