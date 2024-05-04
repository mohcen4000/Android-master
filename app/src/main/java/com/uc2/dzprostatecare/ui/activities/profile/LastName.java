package com.uc2.dzprostatecare.ui.activities.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.RequestHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LastName extends AppCompatActivity {
    ImageView back;
    EditText ed1;
    TextView save;
    Patient p1;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_name);



        back=findViewById(R.id.edit_profile_back_last);
        ed1=findViewById(R.id.last_name_ed);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
       // Patient p= (Patient) bundle.getSerializable("p");

        id=bundle.getInt("id");


        getDataEditProfile(id);



        save=findViewById(R.id.btn_lastname);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastName=ed1.getText().toString();
                updateLastname(id,lastName);
                finish();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getDataEditProfile(id);


    }



    private void updateLastname(int id, String lastName) {}

    private void getDataEditProfile(int id){}


}