package com.uc2.dzprostatecare.ui;

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
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.Question;
import com.uc2.dzprostatecare.pojo.Symptomm;
import com.uc2.dzprostatecare.ui.activities.EditSymptoms;
import com.uc2.dzprostatecare.ui.adapter.QuestionAdapter;
import com.uc2.dzprostatecare.ui.adapter.SymptomAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Symptom extends AppCompatActivity {

    ImageView backsym,addSymp;
    SymptomAdapter symptomAdapter;
    RecyclerView symptomRecycler;
    ArrayList<Symptomm> symp;
    public int itemID;
    public int idPat;
    public String name;
    public String date;
    public String note;
    public String severity;
    Patient p;
    int idp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);

        backsym=findViewById(R.id.s_back);
        addSymp=findViewById(R.id.add_new_sym);

        Intent i = getIntent();

        //p= (Patient) i.getSerializableExtra("patient");
        Bundle b=i.getExtras();
        idp=b.getInt("id");


        backsym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addSymp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), EditSymptoms.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                //bundle.putSerializable("id",p);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        ArrayList<Symptomm>symptom=new ArrayList<>();




        symptomRecycler=findViewById(R.id.symptoms_rec);

    }

    private  void setSymptomRecycler(ArrayList<Symptomm> symptomDataList, RecyclerView symptomRecycler){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        symptomRecycler.setLayoutManager(layoutManager);
        symptomAdapter = new SymptomAdapter(symptomDataList,this);
        symptomRecycler.setAdapter(symptomAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, idp+"", Toast.LENGTH_SHORT).show();
        getData(idp);
    }

    private void getData(int idd) {
        /*
        // creating a new variable for our request queue
        symp=new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(this);
        String uri = String.format(Constants.URL_GET_SYMPTOM+"/"+"?id=%1$s", idd);
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
                        idPat=object.getInt("os_id_patient");
                        itemID=object.getInt("os_id_symptom");
                        date = object.getString("os_date");
                        note = object.getString("os_notes");
                        severity = object.getString("os_severity");
                        name = object.getString("os_name");

                        Symptomm s=new Symptomm(itemID,idPat,date,severity,note,name);
                        symp.add(s);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    setSymptomRecycler(symp,symptomRecycler);

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