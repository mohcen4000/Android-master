package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.helper.DateTimePickerEditText;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.isapanah.awesomespinner.AwesomeSpinner;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.RequestHandler;
import com.uc2.dzprostatecare.pojo.Symptomm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModifySymptom extends AppCompatActivity {

    String sname,sdate,stime,sseverity,snotes;
    int ids;
    Symptomm m;
    ImageView back,delete;
    EditText t;
    String timeFin;
    DateTimePickerEditText dt;
    RadioButton none,mild,moderate,severe,rb;
    EditText snot;
    List<String> categories;
    AwesomeSpinner my_spinner;
    TextView upda;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_symptom);

        dt=findViewById(R.id.dt_dateu);
        upda=findViewById(R.id.btn_update_symp);
        rg=findViewById(R.id.rangebar8);

        none=findViewById(R.id.noneu);
        mild=findViewById(R.id.mildu);
        moderate=findViewById(R.id.moderateu);
        severe=findViewById(R.id.severeu);


         my_spinner = (AwesomeSpinner) findViewById(R.id.my_spinner7);
        categories = new ArrayList<String>();
        categories.add("Anxiety");
        categories.add("Appetite Loss");
        categories.add("Bleeding");
        categories.add("Confusion or Delirium");
        categories.add("Constipation");
        categories.add("Depression");
        categories.add("Diarrhea");
        categories.add("Difficulty Chewing or Swallowing");
        categories.add("Dry Mouth");
        categories.add("Headache");
        categories.add("Insomnia");
        categories.add("Nausea");
        categories.add("Pain");
        categories.add("Shortness of Breath");
        categories.add("Sore Mouth");
        categories.add("Vomiting");

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        my_spinner.setAdapter(categoriesAdapter);

        my_spinner.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {
                //TODO YOUR ACTIONS
               String n=itemAtPosition;
            }
        });

        back=findViewById(R.id.sym_backu);
        delete=findViewById(R.id.delete_sysmptom);
        t=findViewById(R.id.dt_time1u);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        m= (Symptomm) bundle.getSerializable("sy");
        ids=m.getItemID();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure to delete this symptom?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing, but close the dialog


                        deleteSymp(ids);



                        dialog.dismiss();
                        finish();

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing

                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();


            }
        });

        TimePickerDialog timePickerDialog = new TimePickerDialog(ModifySymptom.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {

                String m=String.valueOf(minutes);
                if(minutes<10)
                {
                    m="0"+minutes;
                }

                timeFin=hourOfDay+":"+m;
                t.setText(timeFin);

            }
        }, 0, 0, true);







        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();


            }
        });


        snot=findViewById(R.id.sympt_notesu);


         getData(ids);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb=findViewById(checkedId);
            }
        });

         upda.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {



                     if (my_spinner.getSelectedItem().toString().trim().isEmpty()) {
                         Toast.makeText(ModifySymptom.this, "Enter symptom Name", Toast.LENGTH_SHORT).show();
                     } else if (rb.getText().toString().toString().trim().isEmpty()) {
                         Toast.makeText(ModifySymptom.this, "Enter the severity", Toast.LENGTH_SHORT).show();
                     }else if(dt.getText().toString().trim().isEmpty()){
                         Toast.makeText(ModifySymptom.this, "Enter the date of symptom", Toast.LENGTH_SHORT).show();
                     }
                     else if (t.getText().toString().trim().isEmpty()) {
                         Toast.makeText(ModifySymptom.this, "Enter the time of symptom ", Toast.LENGTH_SHORT).show();
                     }
                     else if (snot.getText().toString().trim().isEmpty()) {
                         Toast.makeText(ModifySymptom.this, "Enter the note", Toast.LENGTH_SHORT).show();
                     } else {

                         updateSymptom(ids,my_spinner.getSelectedItem(),rb.getText().toString(),dt.getText().toString(),t.getText().toString(),snot.getText().toString());
                         finish();
                     }



             }
         });


    }


    private void getData(int idd) {
        /*
        // creating a new variable for our request queue

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String uri = String.format(Constants.URL_GET_SYMPTOMM+"/"+"?id=%1$s", idd);
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

                        sname=object.getString("sname");
                        sdate=object.getString("sdate");
                        stime=object.getString("stime");
                        sseverity=object.getString("sseverity");
                        snotes=object.getString("snotes");

                        if(sseverity.equals("None"))
                        {
                            none.setChecked(true);
                        }
                        if(sseverity.equals("Mild"))
                        {
                            mild.setChecked(true);
                        }

                        if(sseverity.equals("Moderate"))
                        {
                            moderate.setChecked(true);
                        }

                        if(sseverity.equals("Severe"))
                        {
                            severe.setChecked(true);
                        }

                        t.setText(stime);
                        dt.setText(sdate);
                        snot.setText(snotes);
                        int ind=0;
                        if(categories.contains(sname))
                        {
                            ind=categories.indexOf(sname);
                        }

                        my_spinner.setSelection(ind);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


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


    private void deleteSymp(int id) {
        /*
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_DELETE_SYMPTOM,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {


                            JSONObject obj = new JSONObject(response);

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(ModifySymptom.this,
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", String.valueOf(id));
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

         */
    }

    private void updateSymptom(int id,String sympname,String severity,String date,String time,String note) {
        /*
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_UPDATE_SYMPTOM,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {


                            JSONObject obj = new JSONObject(response);

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(
                                getApplicationContext(),
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", String.valueOf(id));
                params.put("sympname", sympname);
                params.put("severity", severity);
                params.put("date",date);
                params.put("time",time);
                params.put("note",note);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

         */
    }
}