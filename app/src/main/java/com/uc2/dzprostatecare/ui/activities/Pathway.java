package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.InfoPathwayDialog;
import com.uc2.dzprostatecare.pojo.Test;
import com.uc2.dzprostatecare.pojo.TestResult;
import com.uc2.dzprostatecare.ui.adapter.TestAdapter;
import com.uc2.dzprostatecare.ui.fragment.Pathway.DiagnosisFragment;
import com.uc2.dzprostatecare.ui.fragment.Pathway.FollowUpFragment;
import com.uc2.dzprostatecare.ui.fragment.Pathway.ScreeningFragment;
import com.uc2.dzprostatecare.ui.fragment.Pathway.TreatmentFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pathway extends AppCompatActivity implements View.OnClickListener {


    LinearLayout screening,diagnosis,treatment,followup;
    FragmentTransaction transaction;
    TextView drname;
    ImageView back;
    Fragment fragment=null;
    int idp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pathway);

        screening=findViewById(R.id.screening);
        diagnosis=findViewById(R.id.diagnosis);
        treatment=findViewById(R.id.treatment);
        followup=findViewById(R.id.followup);
        back=findViewById(R.id.pathway_back);
        drname=findViewById(R.id.doctor_name);



        screening.setOnClickListener(this);
        diagnosis.setOnClickListener(this);
        treatment.setOnClickListener(this);
        followup.setOnClickListener(this);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        idp=bundle.getInt("id");
       // Patient p= (Patient) bundle.getSerializable("patient");

        getIntent().putExtra("id", idp);

        getStep(idp);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });



    }



    @Override
    public void onClick(View v) {

        LinearLayout item=findViewById(v.getId());


        switch (v.getId())
        {

            case R.id.screening:
                fragment=new ScreeningFragment();
                Toast.makeText(this, screening.isEnabled()+"", Toast.LENGTH_SHORT).show();
                ViewCompat.setBackgroundTintList(screening, ColorStateList.valueOf(Color.parseColor("#26517A")));
                ViewCompat.setBackgroundTintList(diagnosis, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                ViewCompat.setBackgroundTintList(treatment, ColorStateList.valueOf(Color.parseColor("#ffffff")));
                ViewCompat.setBackgroundTintList(followup, ColorStateList.valueOf(Color.parseColor("#ffffff")));


                break;
            case R.id.diagnosis:
                fragment=new DiagnosisFragment();
                ViewCompat.setBackgroundTintList(screening, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                ViewCompat.setBackgroundTintList(diagnosis, ColorStateList.valueOf(Color.parseColor("#26517A")));
                ViewCompat.setBackgroundTintList(treatment, ColorStateList.valueOf(Color.parseColor("#ffffff")));
                ViewCompat.setBackgroundTintList(followup, ColorStateList.valueOf(Color.parseColor("#ffffff")));

                break;
            case R.id.treatment:
                fragment=new TreatmentFragment();
                ViewCompat.setBackgroundTintList(screening, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                ViewCompat.setBackgroundTintList(diagnosis, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                ViewCompat.setBackgroundTintList(treatment, ColorStateList.valueOf(Color.parseColor("#26517A")));
                ViewCompat.setBackgroundTintList(followup, ColorStateList.valueOf(Color.parseColor("#ffffff")));

                break;
            case R.id.followup:

                fragment=new FollowUpFragment();
                ViewCompat.setBackgroundTintList(screening, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                ViewCompat.setBackgroundTintList(diagnosis, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                ViewCompat.setBackgroundTintList(treatment, ColorStateList.valueOf(Color.parseColor("#ffffff")));
                ViewCompat.setBackgroundTintList(followup, ColorStateList.valueOf(Color.parseColor("#26517A")));

                break;
        }
        transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_path,fragment);
        transaction.commit();
    }

    public void getStep(int idp){
        /*

        Toast.makeText(this, idp+"", Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(Pathway.this);

        String uri = String.format(Constants.URL_GET_STEP+"/"+"?id=%1$s", idp);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, uri, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


                for (int i = 0; i < response.length(); i++) {
                    // creating a new json object and
                    // getting each object from our json array.
                    try {
                        // we are getting each json object.
                        JSONObject object = response.getJSONObject(i);

                        // now we get our response from API in json object format.

                        // in below line we are extracting a string with
                        // its key value from our json object.
                        // similarly we are extracting all the strings from our json object.

                        String step = object.getString("step");

                       if(step.equals("new"))
                       {
                           fragment=new ScreeningFragment();
                           ViewCompat.setBackgroundTintList(screening, ColorStateList.valueOf(Color.parseColor("#26517A")));
                           ViewCompat.setBackgroundTintList(diagnosis, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                           ViewCompat.setBackgroundTintList(treatment, ColorStateList.valueOf(Color.parseColor("#ffffff")));
                           ViewCompat.setBackgroundTintList(followup, ColorStateList.valueOf(Color.parseColor("#ffffff")));
                           diagnosis.setEnabled(false);
                           treatment.setEnabled(false);
                           followup.setEnabled(false);
                           diagnosis.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View v) {

                               }
                           });
                       }
                        if(step.equals("diagnosis"))
                        {
                            fragment=new DiagnosisFragment();
                            ViewCompat.setBackgroundTintList(screening, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                            ViewCompat.setBackgroundTintList(diagnosis, ColorStateList.valueOf(Color.parseColor("#26517A")));
                            ViewCompat.setBackgroundTintList(treatment, ColorStateList.valueOf(Color.parseColor("#ffffff")));
                            ViewCompat.setBackgroundTintList(followup, ColorStateList.valueOf(Color.parseColor("#ffffff")));
                            treatment.setEnabled(false);
                            followup.setEnabled(false);


                        }

                        if(step.equals("treatment"))
                        {
                            fragment=new TreatmentFragment();
                            ViewCompat.setBackgroundTintList(screening, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                            ViewCompat.setBackgroundTintList(diagnosis, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                            ViewCompat.setBackgroundTintList(treatment, ColorStateList.valueOf(Color.parseColor("#26517A")));
                            ViewCompat.setBackgroundTintList(followup, ColorStateList.valueOf(Color.parseColor("#ffffff")));




                            followup.setEnabled(false);



                        }

                        if(step.equals("follow-up"))
                        {
                            fragment=new TreatmentFragment();
                            ViewCompat.setBackgroundTintList(screening, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                            ViewCompat.setBackgroundTintList(diagnosis, ColorStateList.valueOf(Color.parseColor("#3E92E3")));
                            ViewCompat.setBackgroundTintList(treatment, ColorStateList.valueOf(Color.parseColor("#ffffff")));
                            ViewCompat.setBackgroundTintList(followup, ColorStateList.valueOf(Color.parseColor("#26517A")));
                        }



                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.container_path,fragment);
                        transaction.commit();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Pathway.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest);
    }
         */
    }


}