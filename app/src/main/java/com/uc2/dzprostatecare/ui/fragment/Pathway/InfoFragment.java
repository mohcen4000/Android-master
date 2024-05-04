package com.uc2.dzprostatecare.ui.fragment.Pathway;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Article;
import com.uc2.dzprostatecare.ui.adapter.ProstateCancerAdapter;
import com.uc2.dzprostatecare.ui.adapter.RecentsAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class InfoFragment extends Fragment {

    TextView information;
    ProstateCancerAdapter prostateCancerAdapter;
    RecyclerView articleRecycler;
    List<Article> articleList = new ArrayList<>();
    EditText search;

    FragmentTransaction transaction;


    public InfoFragment() {
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
        View view=inflater.inflate(R.layout.fragment_info, container, false);

       /* information=view.findViewById(R.id.information);



        articleList.add(new Article("What Is Prostate Cancer?","Description,Symptoms,Risk Factors","",true,R.drawable.prostatecancer));
        articleList.add(new Article("Prostate Cancer Pathway","Pathway Description","",false,R.drawable.prostatecancerpathway));
        articleList.add(new Article("PCa Treatment","Treatment Plans,Risk Factors","",true,R.drawable.pcatreatment));
        articleList.add(new Article("Living With PCa","Life Style,Habits","",false,R.drawable.pcalifestyle));


        articleRecycler = view.findViewById(R.id.container);
        setArticleRecycler(articleList,articleRecycler,view);


        articleRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "frag", Toast.LENGTH_SHORT).show();
            }
        });


        search=view.findViewById(R.id.seach);
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
        });*/
        return view;
    }

    private  void setArticleRecycler(List<Article> articleDataList,RecyclerView articleRecycler,View view){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        articleRecycler .setLayoutManager(layoutManager);
        prostateCancerAdapter = new ProstateCancerAdapter(getContext(), articleDataList);
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