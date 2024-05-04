package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.toolbox.StringRequest;
import com.uc2.dzprostatecare.R;
import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class ResetPassword extends AppCompatActivity {

    TextView back,submit;
    EditText email;
    StringRequest stringRequest;
    String emailStr;
    String URL="http://192.168.137.1:8081/LogIn/ForgotPassword.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        submit=findViewById(R.id.reset);
        back=findViewById(R.id.back);

        email=findViewById(R.id.email);

        sendEmail();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void sendEmail() {
    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String emai;

            emai = String.valueOf(email.getText());
            if (!emai.equals("") ) {
                //Start ProgressBar first (Set visibility VISIBLE)
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[1];
                        field[0] = "email";
                        //Creating array for data
                        String[] data = new String[1];
                        data[0] = emai;
                        PutData putData = new PutData("http://192.168.137.1:8081/LogIn/ForgotPassword.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                //End ProgressBar (Set visibility to GONE)
                                if(result.equals("SUCCESS")) {
                                    Toast.makeText(getApplicationContext(),"EMAIL SENT SUCCESS!",Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),"Failed"+result,Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        //End Write and Read data with URL
                    }
                });

            }
            else
            {
                Toast.makeText(getApplicationContext(),"Field required",Toast.LENGTH_SHORT).show();
            }
        }
    });

    }
}

