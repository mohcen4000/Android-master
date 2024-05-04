package com.uc2.dzprostatecare.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.uc2.dzprostatecare.pojo.ExampleItem;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.ui.adapter.ExampleAdapter;

import java.util.ArrayList;


public class NotificationFragment extends Fragment {

    ImageView profile;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public NotificationFragment() {
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
        View view= inflater.inflate(R.layout.fragment_notification, container, false);

        profile=view.findViewById(R.id.pathway_back);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.medicine, "Panadol Extra", "2 comp"));
        exampleList.add(new ExampleItem(R.drawable.medicine, "Prostex", "1 comp"));
        exampleList.add(new ExampleItem(R.drawable.medicine, "Blanel", "2 comp"));
        exampleList.add(new ExampleItem(R.drawable.medicine, "Line 1", "Line 2"));
        exampleList.add(new ExampleItem(R.drawable.medicine, "Line 1", "Line 2"));
        exampleList.add(new ExampleItem(R.drawable.medicine, "Line 1", "Line 2"));




        recyclerView = view.findViewById(R.id.list_notification);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        return view;
    }
}
