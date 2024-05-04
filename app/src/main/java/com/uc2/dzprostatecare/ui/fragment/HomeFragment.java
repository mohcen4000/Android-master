package com.uc2.dzprostatecare.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.ui.activities.AskMe;
import com.uc2.dzprostatecare.ui.activities.ContactDoctor;
import com.uc2.dzprostatecare.ui.activities.SettingsActivity;
import com.uc2.dzprostatecare.ui.adapter.ExampleAdapter;
import com.uc2.dzprostatecare.pojo.ExampleItem;
import com.uc2.dzprostatecare.ui.activities.Pathway;
import com.uc2.dzprostatecare.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements View.OnClickListener {




    ImageView profile;
    TextView userTxt;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    LinearLayout home,ask,contact,advice;
    int id;


    public HomeFragment() {
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
            Patient p;
        View view= inflater.inflate(R.layout.fragment_home, container, false);

       /* profile = view.findViewById(R.id.userIcon);
        ask=view.findViewById(R.id.askm);


        Intent i = getActivity().getIntent();

        //p= (Patient) i.getSerializableExtra("patient");


        Bundle b=i.getExtras();

        id=b.getInt("id");

        userTxt=view.findViewById(R.id.user);

        //Toast.makeText(getContext(), p.getLastName(), Toast.LENGTH_SHORT).show();

       userTxt.setText(p.getFirstName());




        mRecyclerView = view.findViewById(R.id.recyclerView);*/
       /* mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);*/

        /*home=view.findViewById(R.id.homeContent);
        contact=view.findViewById(R.id.contact_doctor);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Pathway.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
               // bundle.putSerializable("patient",p);
                intent.putExtras(bundle);
                startActivity(intent);

              /*  Fragment fragment=null;
                LinearLayout item=v.findViewById(v.getId());
                fragment=new PathwayFragment();
                transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container_home,fragment);
                transaction.commit();*/
            /*}
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
               // bundle.putSerializable("p",p);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent = new Intent(getActivity(), ContactDoctor.class);
                Intent intent = new Intent(getActivity(), ContactDoctor.class);
                startActivity(intent);
            }
        });
        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AskMe.class);
                startActivity(intent);
            }
        });

        */


        return view;

    }




    public void onClick(View v) {
      /*  Fragment fragment=null;
        LinearLayout item=v.findViewById(v.getId());
        fragment=new PathwayFragment();
        transaction=getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_path,fragment);
        transaction.commit();*/
    }
}
