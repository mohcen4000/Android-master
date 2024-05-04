package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.ui.adapter.ProstateCancerAdapter;
import com.uc2.dzprostatecare.pojo.Article;
import com.uc2.dzprostatecare.ui.fragment.Pathway.InfoFragment;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    TextView information;
    ProstateCancerAdapter prostateCancerAdapter;
    RecyclerView articleRecycler;
    List<Article> articleList = new ArrayList<>();
    EditText search;
    TextView informations,news;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);






        articleList.add(new Article("What Is Prostate Cancer?","Description,Symptoms,Risk Factors","The prostate is a small gland about the size of a walnut. It forms part of the male reproductive system. The prostate sits below the bladder, in front of in front of the rectum and close to nerves, blood vessels and muscles that control erections and bladder function. These muscles include the pelvic floor muscles, a hammock-like layer of muscles at the base of the pelvis.",true,R.drawable.prostatecancer));
        articleList.add(new Article("Prostate Cancer Pathway","Pathway Description","",false,R.drawable.prostatecancerpathway));
        articleList.add(new Article("PCa Treatment","Treatment Plans,Risk Factors","",true,R.drawable.pcatreatment));
        articleList.add(new Article("Living With PCa","Life Style,Habits","",false,R.drawable.pcalifestyle));


        articleRecycler = findViewById(R.id.container);
        setArticleRecycler(articleList,articleRecycler);


        articleRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "frag", Toast.LENGTH_SHORT).show();
            }
        });


        search=findViewById(R.id.seach);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                search(s.toString());
            }
        });



      //loadInfo();

      /*  informations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              loadInfo();
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;
                fragment=new newsFragment();
                transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container,fragment);
                transaction.commit();
            }
        });

       */

    }


    public void loadInfo()
    {
        Fragment fragment=null;
        fragment=new InfoFragment();
        transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }

    private  void setArticleRecycler(List<Article> articleDataList,RecyclerView articleRecycler){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        articleRecycler .setLayoutManager(layoutManager);
        prostateCancerAdapter = new ProstateCancerAdapter(this, articleDataList);
        articleRecycler.setAdapter(prostateCancerAdapter);

    }

    public void search(String text)
    {
        ArrayList<Article> filteredList = new ArrayList<>();

        for (Article item : articleList) {
            if (item.getArticleName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        prostateCancerAdapter.filterList(filteredList);
    }



}
