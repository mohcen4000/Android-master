package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.helper.DateTimePickerEditText;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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
import com.uc2.dzprostatecare.pojo.Appointment;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.RequestHandler;
import com.uc2.dzprostatecare.pojo.Urologist;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModifyAppointment extends AppCompatActivity {
    Appointment appoi;
    ImageView delApp,back;
    AwesomeSpinner awesomeSpinner;
    ArrayList<Urologist> uro;
    int id;
    String firstname, lastname,phone, email, birth, grade;
    TextView update;
    ImageView appback;
    EditText other;
    RadioGroup rg2;
    RadioButton rb2;
    private Calendar calendar;
    DateTimePickerEditText d;
    private SimpleDateFormat dateFormat;
    private String date;
    int id_a,id_patient, id_uro;
    String bookedOn, status, type,scheduledOn,indstructions, reason;
    RadioButton f,o,t;
    AwesomeSpinner my_spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_appointment);

        update=findViewById(R.id.btn_updaate_app);
        other=findViewById(R.id.other_reasonu);
        appback=findViewById(R.id.app_backuu);
        f=findViewById(R.id.facetoface);
        o=findViewById(R.id.online);
        t=findViewById(R.id.telephone);
        Intent i =getIntent();
        Bundle b = i.getExtras();

        appoi= (Appointment) b.getSerializable("app");

        getData(appoi.getId());

        delApp=findViewById(R.id.delete_apppointment);
        back=findViewById(R.id.app_back);

        awesomeSpinner=findViewById(R.id.my_spinner5);

       awesomeSpinner.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {
                //TODO YOUR ACTIONS
            }
        });

       awesomeSpinner.setSelection(1);


         my_spinner2 = (AwesomeSpinner) findViewById(R.id.my_spinner6);
        List<String> categories2 = new ArrayList<String>();
        categories2.add("Some Concerns About Diagnosis");
        categories2.add("Some Concerns About Treatment");
        categories2.add("Some Concerns About my situation");

        ArrayAdapter<String> categoriesAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);


        my_spinner2.setAdapter(categoriesAdapter2);

        my_spinner2.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {
                //TODO YOUR ACTIONS
            }
        });

        appback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rg2=findViewById(R.id.rangebar5);
        d=findViewById(R.id.d_datte);


        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb2=findViewById(checkedId);

            }
        });

        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(calendar.getTime());


        d.setText(date);


        getUrologists();




       // awesomeSpinner.setSelection(appoi.getId_urologist());

        delApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure to delete this appointment?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing, but close the dialog

                        deleteAppoint(appoi.getId());



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
        appback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reason;

                if (!awesomeSpinner.isSelected()) {
                    Toast.makeText(ModifyAppointment.this, "Enter the doctor Name", Toast.LENGTH_SHORT).show();
                } else if (!my_spinner2.isSelected() && other.getText().toString().trim().isEmpty()) {
                    Toast.makeText(ModifyAppointment.this, "Enter the reason of Appointment", Toast.LENGTH_SHORT).show();
                }else if(rb2==null){
                    Toast.makeText(ModifyAppointment.this, "Enter the type of appointment", Toast.LENGTH_SHORT).show();
                }
                else if (d.getText().toString().trim().isEmpty()) {
                    Toast.makeText(ModifyAppointment.this, "Enter the date of appointment ", Toast.LENGTH_SHORT).show();
                }
                else {

                    if(!my_spinner2.getSelectedItem().toString().equals(""))
                    {
                        reason= my_spinner2.getSelectedItem().toString();
                    }
                    else
                    {
                        reason=other.getText().toString();
                    }
                    updateAppointment(appoi.getId(),awesomeSpinner.getSelectedItem().toString(),rb2.getText().toString(),d.getText().toString(),reason);



                    finish();
                }




            }
        });



    }


    private void deleteAppoint(int id) {
        /*
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_DELETE_APPOINTMENT,
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

                        Toast.makeText(ModifyAppointment.this,
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

    private void updateAppointment(int id,String idu,String appType,String bookedOn,String reason) {
        /*
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_MODIFY_APPOINTMENT,
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
                params.put("c_id_urologist", idu);
                params.put("a_bookedOn", bookedOn);
                params.put("a_type",appType);
                params.put("a_reason",reason);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

         */
    }

    private void getUrologists() {
        /*
        // creating a new variable for our request queue
        uro=new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String uri = Constants.URL_GET_UROLOGISTS;
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
                        id=object.getInt("id");
                        firstname= object.getString("firstname");
                        lastname=object.getString("lastname");
                        phone=object.getString("phone");
                        email=object.getString("email");
                        birth=object.getString("birth");
                        grade=object.getString("grade");

                        Urologist urologist=new Urologist(id,Integer.parseInt(phone),firstname,lastname,birth,grade,email);


                        uro.add(urologist);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    List<String> categories = new ArrayList<String>();

                    for(i=0;i<uro.size();i++)
                    {
                        categories.add(uro.get(i).getFirst_name()+" "+uro.get(i).getLast_name());
                    }



                    ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(ModifyAppointment.this, android.R.layout.simple_spinner_item, categories);

                    awesomeSpinner.setAdapter(categoriesAdapter);

                    awesomeSpinner.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
                        @Override
                        public void onItemSelected(int position, String itemAtPosition) {
                            //TODO YOUR ACTIONS
                        }
                    });


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

    private void getData(int idd) {
        /*
        // creating a new variable for our request queue
        //ap=new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String uri = String.format(Constants.URL_GET_APPOINTMENTT+"/"+"?id=%1$s", idd);
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
                        type=object.getString("a_type");
                        reason = object.getString("a_reason");


                        d.setText(bookedOn);



                        if(type.equals("Face to face"))
                        {
                            f.setChecked(true);
                        }
                        if(type.equals("Online"))
                        {
                            o.setChecked(true);
                        }
                        if(type.equals("Telephone"))
                        {
                            t.setChecked(true);
                        }

                        if(reason.equals("Some Concerns About Diagnosis"))
                        {
                            my_spinner2.setSelection(1);
                        }
                        else
                        { if(reason.equals("Some Concerns About Treatment"))
                        {
                            my_spinner2.setSelection(2);
                        }else
                        {
                            if(reason.equals("Some Concerns About my situation"))
                            {
                                my_spinner2.setSelection(3);
                            }
                            else {
                                other.setText(reason);
                            }
                        }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //     setAppointmentRecycler(ap,appointmentRecycler);

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