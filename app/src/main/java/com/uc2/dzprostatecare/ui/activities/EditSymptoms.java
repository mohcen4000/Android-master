package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
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
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.isapanah.awesomespinner.AwesomeSpinner;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.RequestHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditSymptoms extends AppCompatActivity {

    private Calendar calendar;
    String timeFin;
    private SimpleDateFormat dateFormat,dateFormat2;
    TextView addSymp;
    private String date,time;
    RadioGroup rd;
    RadioButton rb;
    EditText t;
    DateTimePickerEditText d;
    EditText notes;
    ImageView iv1;
    Patient p;
    int idp;
    String n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_symptoms);

       /*
        Bundle b=new Bundle();

        Intent intent=getIntent();
        //p= (Patient) intent.getSerializableExtra("patient");

        Bundle bb=intent.getExtras();
        idp=bb.getInt("id");

         */

        AwesomeSpinner my_spinner = (AwesomeSpinner) findViewById(R.id.my_spinner);
        /* Optimisation
        categories.addAll(Arrays.asList(
        "Anxiety",
        "Appetite Loss",
        "Bleeding",
        "Confusion or Delirium",
        "Constipation",
        "Depression",
        "Diarrhea",
        "Difficulty Chewing or Swallowing",
        "Dry Mouth",
        "Headache",
        "Insomnia",
        "Nausea",
        "Pain",
        "Shortness of Breath",
        "Sore Mouth",
        "Vomiting"
        ));
         */
        List<String> categories = new ArrayList<String>();
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

        addSymp=findViewById(R.id.btn_submit_symp);

        d=findViewById(R.id.dt_date1);
        t=findViewById(R.id.dt_time1);




        TimePickerDialog timePickerDialog = new TimePickerDialog(EditSymptoms.this, new TimePickerDialog.OnTimeSetListener() {
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








        rd=findViewById(R.id.rangebar2);

        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb=findViewById(checkedId);
            }
        });

        notes=findViewById(R.id.sympt_notes);

        iv1=findViewById(R.id.sym_back);

        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat2 = new SimpleDateFormat("HH:mm");
        date= dateFormat.format(calendar.getTime());
        time= dateFormat2.format(calendar.getTime());


        d.setText(date);
        t.setText(time);

        String timee=t.getText().toString();

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        my_spinner.setAdapter(categoriesAdapter);

        my_spinner.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {
                //TODO YOUR ACTIONS
             n=itemAtPosition;
            }
        });


        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addSymp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if (!my_spinner.isSelected()) {
                    Toast.makeText(EditSymptoms.this, "Enter symptom Name", Toast.LENGTH_SHORT).show();
                } else if (rb==null) {
                    Toast.makeText(EditSymptoms.this, "Enter the severity", Toast.LENGTH_SHORT).show();
                }else if(d.getText().toString().trim().isEmpty()){
                    Toast.makeText(EditSymptoms.this, "Enter the date of symptom", Toast.LENGTH_SHORT).show();
                }
                else if (t.getText().toString().trim().isEmpty()) {
                    Toast.makeText(EditSymptoms.this, "Enter the time of symptom ", Toast.LENGTH_SHORT).show();
                }
                else if (notes.getText().toString().trim().isEmpty()) {
                    Toast.makeText(EditSymptoms.this, "Enter the note", Toast.LENGTH_SHORT).show();
                } else {

                    addSymptom(idp,n,d.getText().toString(),rb.getText().toString(),notes.getText().toString(),timee);
                    finish();
                }

            }
        });



    }

    private void addSymptom(int idp,String name,String date,String severity,String notes,String time){
    /*

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_ADD_SYMPTOM,
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
                params.put("id", String.valueOf(idp));
                params.put("date", date);
                params.put("severity", severity);
                params.put("notes", notes);
                params.put("name", name);
                params.put("time", time);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
     */
    }
}