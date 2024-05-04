package com.uc2.dzprostatecare.ui.activities.physical_data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.PhysicalData;
import com.uc2.dzprostatecare.pojo.RequestHandler;
import com.uc2.dzprostatecare.pojo.Test;
import com.uc2.dzprostatecare.pojo.TestResult;
import com.uc2.dzprostatecare.ui.activities.Register;
import com.uc2.dzprostatecare.ui.activities.profile.FirstName;
import com.uc2.dzprostatecare.ui.adapter.TestAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Pressure extends AppCompatActivity {

    TextView save,title,content_title;
    ImageView psaback;
    final Calendar myCalendar = Calendar.getInstance();
    TextView inputBirthDate;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    EditText pressure;
    boolean isOld;

    int idp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        save=findViewById(R.id.btn_pressure);
        title=findViewById(R.id.title_pressure);
        content_title=findViewById(R.id.content_title_pressure);

        isOld=false;

        Intent i =getIntent();

        //Patient p= (Patient) i.getSerializableExtra("p");
        Bundle bundle=i.getExtras();
        idp=bundle.getInt("id");

        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(calendar.getTime());


        inputBirthDate=findViewById(R.id.date_pressure);

        psaback=findViewById(R.id.pressure_back_first);

        pressure=findViewById(R.id.pressure_ed);

        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOld==true)
                {

                    addPressure(idp,pressure.getText().toString(),Register.toMysqlDate(sdf.format(myCalendar.getTime())));
                }
                else{
                    addPressure(idp,pressure.getText().toString(),Register.toMysqlDate(date));
                }
                finish();
            }
        });

        getPhy(idp,Register.toMysqlDate(date));

        psaback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
                isOld=true;
                getPhy(idp,Register.toMysqlDate(sdf.format(myCalendar.getTime())));
            }

        };

        inputBirthDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Pressure.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void addPressure(int id,String pressure,String adate) {
        /*

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_UPDATE_PRESSURE,
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
                params.put("pressure", pressure);
                params.put("date", adate);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
         */
    }


    private void updateLabel() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        inputBirthDate.setText(sdf.format(myCalendar.getTime()));
    }



    public void getPhy(int id,String date){
        /*


        String uri = String.format(Constants.URL_GET_PSA+"/"+"?id=%1$s&date=%2$s", id,date);



        StringRequest stringRequest = new StringRequest(Request.Method.GET, uri,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // progressBar.setVisibility(View.GONE);

                        try {

                            JSONArray array = new JSONArray(response);


                            for (int i = 0; i<array.length(); i++){


                                JSONObject object = array.getJSONObject(i);


                                JSONObject obj=object.getJSONObject(i+"");

                                int idphy=obj.getInt("pd_id");
                                String pdglucose=obj.getString("pd_glucose");
                                String pdpulse=obj.getString("pd_pulse");
                                String pdpsa=obj.getString("pd_psa");
                                String pdpressure=obj.getString("pd_pressure");
                                String temperature=obj.getString("pd_temperature");

                                if(pdpressure!="")
                                {

                                    title.setText("Update Pressure");
                                    content_title.setText("Update your Pressure");
                                }
                                else
                                {
                                    title.setText("Add PSA");
                                    content_title.setText("Add your Pressure");
                                }




                                PhysicalData physicalData=new PhysicalData(idphy,pdpsa,pdpulse,pdpressure,temperature,pdglucose);

                                pressure.setText(physicalData.getPressure());
                               pressure.setSelection(pressure.getText().length());






                            }

                        }catch (Exception e){
                            // Toast.makeText(Psa.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //progressBar.setVisibility(View.GONE);
                Toast.makeText(Pressure.this, error.toString(),Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(Pressure.this).add(stringRequest);

         */
    }


}