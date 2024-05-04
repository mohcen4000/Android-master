package com.uc2.dzprostatecare.ui.fragment.Pathway;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.Test;
import com.uc2.dzprostatecare.pojo.TestResult;
import com.uc2.dzprostatecare.ui.adapter.TestAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class DiagnosisFragment extends Fragment {

    private ArrayList<Test> tests;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ScreeningFragment screeningFragment;

    int idp,idt,idu;
    int pid;
    String value,notes,addedon,returndate,status,dueon,testname,testdescription,testunit,stepo,infogiven;



    public DiagnosisFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_diagnosis, container, false);
        Intent i = getActivity().getIntent();

        Bundle bundle=i.getExtras();
        pid=bundle.getInt("id");

       // Patient p= (Patient) i.getSerializableExtra("patient");





        tests=new ArrayList<>();


        LinearLayout diagnosis=view.findViewById(R.id.diagnosis_res);

        diagnosis.setVisibility(View.GONE);


       getData(pid,"diagnosis");



        recyclerView = view.findViewById(R.id.recycler_test);






        return view;
    }


    private void getData(int idd, String step) {}
}
