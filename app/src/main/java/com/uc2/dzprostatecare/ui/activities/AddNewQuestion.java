package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.RequestHandler;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AddNewQuestion extends AppCompatActivity {

    EditText ed_questionDetails;
    ImageView question_back;
    ProgressDialog progressDialog;
    Patient p;
    TextView btn_confirm;

    int idp;


    final Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_question);

        btn_confirm=findViewById(R.id.add_btn);

        question_back=findViewById(R.id.question_back);

        ed_questionDetails=findViewById(R.id.questiondetails);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");


        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        //p= (Patient) intent.getSerializableExtra("patient");
        idp=b.getInt("id");

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String myFormat = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

                String detail = ed_questionDetails.getText().toString().trim();
                if (detail.isEmpty()) {
                    ed_questionDetails.setError("Please Enter a question");
                }
                else {
                    progressDialog.show();

                addNewQuestion(idp,detail,Register.toMysqlDate(sdf.format(myCalendar.getTime())));
                finish();

                }

                progressDialog.dismiss();
            }


        });

        question_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

}




    private void addNewQuestion(int idp,String content,String date){
    /*

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_ADD_QUESTION,
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
                params.put("content", content);
                params.put("dateasked", date);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
     */
    }
}