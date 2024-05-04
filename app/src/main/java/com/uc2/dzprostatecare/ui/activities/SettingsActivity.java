package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.DarkModePrefManager;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.RequestHandler;
import com.uc2.dzprostatecare.ui.dialog.CustomDialogEdit;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SettingsActivity extends AppCompatActivity {

    private Switch darkModeSwitch;
    Patient p;
    TextView user;
    TextView editpass,editprof;
    String pass;
    int idp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(new DarkModePrefManager(this).isNightMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }



//        user.setText(p.getFirstName()+" "+p.getLastName());


        setContentView(R.layout.activity_settings);

        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        idp=b.getInt("id");
        user=findViewById(R.id.usernameTextView);

        editpass=findViewById(R.id.edit_pass);
        editprof=findViewById(R.id.edit_profile);
        //  getDataEditProfile(p.getId());

        editpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(SettingsActivity.this);
            }
        });

        editprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingsActivity.this, EditProfile.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



        //function for enabling dark mode
        setDarkModeSwitch();




    }
    private void setDarkModeSwitch(){
        darkModeSwitch = findViewById(R.id.darkModeSwitch);
        darkModeSwitch.setChecked(new DarkModePrefManager(this).isNightMode());
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DarkModePrefManager darkModePrefManager = new DarkModePrefManager(SettingsActivity.this);
                darkModePrefManager.setDarkMode(!darkModePrefManager.isNightMode());
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();
            }
        });
    }


    public void openDialog(Activity view)
    {
        CustomDialogEdit customDialogEdit=new CustomDialogEdit();
        pass=customDialogEdit.getTex();
        final FragmentManager fm = ((FragmentActivity)view).getSupportFragmentManager();
        customDialogEdit.show(fm,"Edit Profile");


    }

    @Override
    protected void onResume() {
        super.onResume();
//        getDataEditProfile(p.getId());
    }

    private void getDataEditProfile(int id){
        /*
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_REFRESH,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {


                            JSONObject obj = new JSONObject(response);

                            if(!obj.getBoolean("error")){
                                int id=obj.getInt("id");
                                String firstname=obj.getString("firstname");
                                String lastname=obj.getString("lastname");

                                user.setText(firstname+" "+lastname);

                            }else{
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

                        Toast.makeText(
                                getApplicationContext(),
                                error.getMessage() + " err",
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
}