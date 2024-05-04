package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.itextpdf.text.Font;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.ui.adapter.ViewPagerAdapter;
import com.uc2.dzprostatecare.ui.fragment.FrequentlyAsked;
import com.uc2.dzprostatecare.ui.fragment.Pathway.MyQuestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;



public class QuestionActivity extends AppCompatActivity {



    private TabLayout tb;
    private ViewPager vp;
    ImageView askqs,backQst;
    Patient p;
    int idp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        tb=findViewById(R.id.tb);
        vp=findViewById(R.id.vp);
        backQst=findViewById(R.id.question_back);

        askqs=findViewById(R.id.add_new_question);

        Intent i = getIntent();

        Bundle bundle=i.getExtras();

        idp=bundle.getInt("id");

        //p= (Patient) i.getSerializableExtra("patient");

        createAdapter();

        tb.setupWithViewPager(vp);



        askqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(QuestionActivity.this, AddNewQuestion.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
               // bundle.putSerializable("patient",p);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    backQst.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });



    }


    private void createAdapter() {
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FrequentlyAsked(),"Frequently Asked");
        viewPagerAdapter.addFragment(new MyQuestion(),"My Questions");
        vp.setAdapter(viewPagerAdapter);

    }




}