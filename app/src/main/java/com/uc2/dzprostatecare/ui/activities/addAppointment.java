package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

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

public class addAppointment extends AppCompatActivity {

    ImageView appback;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    DateTimePickerEditText d;
    EditText otherReason;
    TextView sub;
    int idp;
    RadioGroup rg2;
    RadioButton rb2;
    ArrayList<Urologist> uro;
    int id;
    String firstname, lastname,phone, email, birth, grade;
    AwesomeSpinner my_spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        my_spinner = (AwesomeSpinner) findViewById(R.id.my_spinner1);

        getUrologists();



        d=findViewById(R.id.d_date);
        sub=findViewById(R.id.btn_submit_app);

        /*
        Intent i=getIntent();
        Bundle b =i.getExtras();

        idp=b.getInt("id");
        */



        otherReason=findViewById(R.id.pther_reason);

        calendar = Calendar.getInstance();

        rg2=findViewById(R.id.rangebar1);


        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb2=findViewById(checkedId);

            }
        });

        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(calendar.getTime());


        d.setText(date);


        appback=findViewById(R.id.app_back);



        AwesomeSpinner my_spinner2 = (AwesomeSpinner) findViewById(R.id.my_spinner2);
        List<String> categories2 = new ArrayList<String>();
        categories2.add("Some Concerns About Diagnosis");
        categories2.add("Some Concerns About Treatment");
        categories2.add("Some Concerns About Medicine");


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

       sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reason;

                if (!my_spinner.isSelected()) {
                    Toast.makeText(addAppointment.this, "Enter the doctor Name", Toast.LENGTH_SHORT).show();
                } else if (!my_spinner2.isSelected() && otherReason.getText().toString().trim().isEmpty()) {
                    Toast.makeText(addAppointment.this, "Enter the reason of Appointment", Toast.LENGTH_SHORT).show();
                }else if(rb2==null){
                    Toast.makeText(addAppointment.this, "Enter the type of appointment", Toast.LENGTH_SHORT).show();
                }
                else if (d.getText().toString().trim().isEmpty()) {
                    Toast.makeText(addAppointment.this, "Enter the date of appointment ", Toast.LENGTH_SHORT).show();
                }
                else {



                    if(my_spinner2.isSelected())
                    {
                        reason= my_spinner2.getSelectedItem().toString();
                    }
                    else
                    {
                        reason=otherReason.getText().toString();
                    }

                    addNewAppointment(idp,my_spinner.getSelectedItem().toString(),rb2.getText().toString(),d.getText().toString(),reason);
                    finish();
                }
            }
        });

    }

    private void addNewAppointment(int idp,String idu,String appType,String bookedOn,String reason){
        /*
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_ADD_APPOINTMENT,
                new com.android.volley.Response.Listener<String>() {
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
                params.put("c_id_patient", String.valueOf(idp));
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



                    ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(addAppointment.this, android.R.layout.simple_spinner_item, categories);

                    my_spinner.setAdapter(categoriesAdapter);

                    my_spinner.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
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
}