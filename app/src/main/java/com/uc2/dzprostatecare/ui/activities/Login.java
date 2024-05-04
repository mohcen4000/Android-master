package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.uc2.dzprostatecare.pojo.InternetDialog;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.RequestHandler;
import com.uc2.dzprostatecare.pojo.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText username,password;
    TextView login,forgot_password,register,fr,en,ar,skip;
    ImageView qrcode;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        forgot_password=findViewById(R.id.forgot_password);

        fr=findViewById(R.id.francais);
        en=findViewById(R.id.english);
        ar=findViewById(R.id.arabic);

        login=findViewById(R.id.login);
        qrcode=findViewById(R.id.btn_qrcode);
        register=findViewById(R.id.register);


        Boolean internet=checkConnection(getApplicationContext());


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    final String user, pass;

                    user = String.valueOf(username.getText());
                    pass = String.valueOf(password.getText());



                    if(internet){
                    userLogin(user,pass);

                    }

                    else{
                        /*
                        InternetDialog internetDialog=new InternetDialog(Login.this);
                        internetDialog.showNoInternetDialog();
                        */
                    }

                }
            });


        qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), LoginQR.class);
                startActivity(intent);
            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ResetPassword.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });


        fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                en.setTextColor(getResources().getColor(R.color.lang));
                ar.setTextColor(getResources().getColor(R.color.lang));
                fr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });


        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fr.setTextColor(getResources().getColor(R.color.lang));
                ar.setTextColor(getResources().getColor(R.color.lang));
                en.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fr.setTextColor(getResources().getColor(R.color.lang));
                en.setTextColor(getResources().getColor(R.color.lang));
                ar.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        skip=findViewById(R.id.skip);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id= 0;

                Intent intent=new Intent(getApplicationContext(),Home.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);

                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });



    }



    private void userLogin(String username,String password){ /*
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {


                            JSONObject obj = new JSONObject(response);

                            if (!obj.getBoolean("error")) {
                                int id = obj.getInt("id");
                                String firstname = obj.getString("firstname");
                                String lastname = obj.getString("lastname");
                                String email = obj.getString("email");
                                int phone = obj.getInt("phone");
                                String accountstatus = obj.getString("accountstatus");
                                String familiasituation = obj.getString("familiasituation");
                                String placeresidence = obj.getString("placeresidence");
                                String ethencity = obj.getString("ethencity");
                                // String region=obj.getString("region");
                                String emergency_number = obj.getString("emergency_number");
                                String smoking = obj.getString("smoking");
                                String alcohol_intake = obj.getString("alcohol_intake");
                                String jobdescription = obj.getString("jobdescription");
                                String address = obj.getString("address");
                                String bloodtype = obj.getString("bloodtype");
                                String birthdate = obj.getString("birthdate");
                                String password = obj.getString("password");
                                //String familyhistory=obj.getString("familyhistory");


                                Intent intent = new Intent(getApplicationContext(), Home.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("id", id);

                                intent.putExtras(bundle);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(
                                        getApplicationContext(),
                                        obj.getString("message"),
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //     Toast.makeText(
                            //             getApplicationContext(),
                            //           e.getMessage(),
                            //         Toast.LENGTH_LONG
                            //).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        InternetDialog internetDialog = new InternetDialog(Login.this);
                        internetDialog.showNoInternetDialog();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

         */
        Intent intent = new Intent(getApplicationContext(), Home.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }


    public static boolean checkConnection(Context ctx) {
        return true;
        /*
        ConnectivityManager connectivityManager = (ConnectivityManager)
                ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected() ||
                (networkInfo.getType() != ConnectivityManager.TYPE_WIFI &&
                        networkInfo.getType() != ConnectivityManager.TYPE_MOBILE)) {
        // No internet connection
            return false;
        } else
            return true;


    }
    */
    }


}
