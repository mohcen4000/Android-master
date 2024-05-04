package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Appointment;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.Question;
import com.uc2.dzprostatecare.pojo.Urologist;
import com.uc2.dzprostatecare.ui.adapter.AppointmentAdapter;
import com.uc2.dzprostatecare.ui.adapter.QuestionAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Appoin extends AppCompatActivity {

    AppointmentAdapter appointmentAdapter;
    RecyclerView appointmentRecycler;
    //Patient p;
    int idp;
    int id_a ,id_patient,id_uro;
    String bookedOn,status,scheduledOn,indstructions,reason,type;
    ImageView ab;
    ImageView addNewApp;




    ArrayList<Appointment> ap;
    ArrayList<Urologist> uro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoin);

        Intent i = getIntent();
        //p= (Patient) i.getSerializableExtra("patient");
        Bundle bundle=i.getExtras();
        idp=bundle.getInt("id");


        //Toast.makeText(getContext(), p.getId()+"", Toast.LENGTH_SHORT).show();

        appointmentRecycler=findViewById(R.id.appointment_recycler);
        ab=findViewById(R.id.appoin_back);
        addNewApp=findViewById(R.id.add_new_appoin);

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addNewApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),addAppointment.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getData(idp);

    }

    private  void setAppointmentRecycler(ArrayList<Appointment> appoin, RecyclerView appointmentRecycler){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        appointmentRecycler.setLayoutManager(layoutManager);
        appointmentAdapter = new AppointmentAdapter( appoin,getApplicationContext());
        appointmentRecycler.setAdapter(appointmentAdapter);

    }

    private void getData(int idd) {
    /*

        // creating a new variable for our request queue
        ap=new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String uri = String.format(Constants.URL_GET_APPOINTMENT+"/"+"?id=%1$s", idd);
        // in this case the data we are getting is in the form
        // of array so we are making a json array request.
        // below is the line where we are making an json array
        // request and then extracting data from each json object.
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
                        id_a=object.getInt("a_id");
                        id_patient=object.getInt("c_id_patient");
                        id_uro=object.getInt("c_id_urologist");
                        bookedOn = object.getString("a_bookedOn");
                        status = object.getString("a_status");
                        type=object.getString("a_type");
                        scheduledOn = object.getString("a_sheduledOn");
                        indstructions = object.getString("a_instructions");
                       reason = object.getString("a_reason");

                       Appointment appointment=new Appointment(id_a,bookedOn,status,id_patient,id_uro,type,scheduledOn,indstructions,reason);



                    ap.add(appointment);






                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    setAppointmentRecycler(ap,appointmentRecycler);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest);
     */
    }

}