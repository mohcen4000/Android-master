package com.uc2.dzprostatecare.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.RequestHandler;
import com.uc2.dzprostatecare.pojo.SessionManager;
import com.uc2.dzprostatecare.ui.activities.Home;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.uc2.dzprostatecare.ui.activities.Login.checkConnection;

public class LoginQR extends AppCompatActivity {
    CodeScanner codeScanner;
    CodeScannerView scannerView;

    //    SessionManager sessionManager=new SessionManager(getApplicationContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_q_r);

        scannerView = findViewById(R.id.scannerView);
        Boolean internet = checkConnection(getApplicationContext());
        codeScanner = new CodeScanner(getApplicationContext(), scannerView);
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final String us, pas;
                        String[] parts = result.getText().split(" ");
                        us = parts[0].split(":")[1];
                        pas = parts[1].split(":")[1];

                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (internet)
                                    userLogin(us, pas);
                                else
                                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        codeScanner.startPreview();
    }


    private void userLogin(String username, String password) {
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
        finish();
        /*
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject obj = new JSONObject(response);

                            if(!obj.getBoolean("error")){

                                int id=obj.getInt("id");
                                String firstname=obj.getString("firstname");
                                String lastname=obj.getString("lastname");
                                String email=obj.getString("email");
                                int phone =obj.getInt("phone");
                                String accountstatus=obj.getString("accountstatus");
                                String familiasituation=obj.getString("familiasituation");
                                String placeresidence=obj.getString("placeresidence");
                                String ethencity=obj.getString("ethencity");
                                String emergency_number=obj.getString("emergency_number");
                                String smoking=obj.getString("smoking");
                                String alcohol_intake=obj.getString("alcohol_intake");
                                String jobdescription=obj.getString("jobdescription");
                                String address=obj.getString("address");
                                String bloodtype=obj.getString("bloodtype");
                                String birthdate=obj.getString("birthdate");
                                String password=obj.getString("password");



                                Patient patient=new Patient(id,firstname,lastname,email,password,phone,birthdate,bloodtype,address,jobdescription,alcohol_intake,smoking,
                                        emergency_number,"cccc"," ",ethencity,placeresidence,familiasituation,accountstatus);


                                //Toast.makeText(Login.this, "onResponse no error intent", Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(getApplicationContext(),Home.class);
                                Bundle bundle=new Bundle();
                                bundle.putSerializable("patient",patient);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(
                                        getApplicationContext(),
                                        obj.getString("message"),
                                        Toast.LENGTH_LONG
                                ).show();
                            }
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
                params.put("username", username);
                params.put("password", password);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
         */
    }
}