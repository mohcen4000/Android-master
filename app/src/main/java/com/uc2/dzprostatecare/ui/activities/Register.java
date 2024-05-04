package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.button.MaterialButton;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.RequestHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.uc2.dzprostatecare.ui.activities.Login.checkConnection;

public class Register extends AppCompatActivity {


    final Calendar myCalendar = Calendar.getInstance();
    ImageView back;
    private EditText inputFirstName, inputLastName, inputBirthDate,inputEmail, inputPhone,inputPassword, inputConfirmPassword;
    private Button buttonSignUp;
    private ProgressBar signUpProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Boolean internet=checkConnection(getApplicationContext());

        signUpProgress    = findViewById(R.id.progressBarSignUp);

        findViewById(R.id.imgBack).setOnClickListener(view -> onBackPressed());
        findViewById(R.id.textSignIn).setOnClickListener(view -> onBackPressed());

        inputFirstName       = findViewById(R.id.inputFirstName);
        inputLastName        = findViewById(R.id.inputLastName);
        inputBirthDate       = findViewById(R.id.inputBirthDate);
        inputEmail           = findViewById(R.id.inputEmail);
        inputPhone           = findViewById(R.id.inputPhonenumber);
        inputPassword        = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        buttonSignUp         = findViewById(R.id.buttonSignUp);


        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        inputBirthDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Register.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });




        buttonSignUp.setOnClickListener(view -> {
            if (inputFirstName.getText().toString().trim().isEmpty()) {
                Toast.makeText(Register.this, "Enter first name", Toast.LENGTH_SHORT).show();
            } else if (inputLastName.getText().toString().trim().isEmpty()) {
                Toast.makeText(Register.this, "Enter last name", Toast.LENGTH_SHORT).show();
            }else if(inputBirthDate.getText().toString().trim().isEmpty()){
                Toast.makeText(Register.this, "Enter your birthdate", Toast.LENGTH_SHORT).show();
            }
            else if (inputEmail.getText().toString().trim().isEmpty()) {
                Toast.makeText(Register.this, "Enter email", Toast.LENGTH_SHORT).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.getText().toString()).matches()) {
                Toast.makeText(Register.this, "Enter valid email", Toast.LENGTH_SHORT).show();
            }else if(inputPhone.getText().toString().trim().isEmpty())
            {
                Toast.makeText(Register.this, "Enter phone", Toast.LENGTH_SHORT).show();
            }
            else if (!Patterns.PHONE.matcher(inputPhone.getText().toString()).matches()) {
                Toast.makeText(Register.this, "Enter valid Phone Number", Toast.LENGTH_SHORT).show();
            }
            else if (inputPassword.getText().toString().trim().isEmpty()) {
                Toast.makeText(Register.this, "Enter password", Toast.LENGTH_SHORT).show();
            } else if (inputConfirmPassword.getText().toString().trim().isEmpty()) {
                Toast.makeText(Register.this, "Confirm your password", Toast.LENGTH_SHORT).show();
            }
            else if (!inputPassword.getText().toString().equals(inputConfirmPassword.getText().toString())) {
                Toast.makeText(Register.this, "Password & confirm password must be same", Toast.LENGTH_SHORT).show();
            }

            else if (!inputPassword.getText().toString().equals(inputConfirmPassword.getText().toString())) {
                Toast.makeText(Register.this, "Password & confirm password must be same", Toast.LENGTH_SHORT).show();
            } else {
                String year=inputBirthDate.getText().toString().charAt(6)+""+
                        inputBirthDate.getText().toString().charAt(7)+""+inputBirthDate.getText().toString().charAt(8)+""+inputBirthDate.getText().toString().charAt(9);
                if(internet)
                    signUp();
                else
                    Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_SHORT).show();
            }


        });

    }

    private void signUp(){

        buttonSignUp.setVisibility(View.INVISIBLE);
        signUpProgress.setVisibility(View.VISIBLE);

        String FirstName,LastName,BirthDate,Email,Phone,Password,ConfirmPassword;

        FirstName =inputFirstName.getText().toString();
        LastName=inputLastName.getText().toString();
        BirthDate=inputBirthDate.getText().toString();
        Email=inputEmail.getText().toString();
        Phone=inputPhone.getText().toString();
        Password=inputPassword.getText().toString();
        ConfirmPassword=inputConfirmPassword.getText().toString();


        String dt=toMysqlDate(BirthDate);


    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        EditText t=findViewById(R.id.inputBirthDate);
        t.setText(sdf.format(myCalendar.getTime()));
    }

    public static String toMysqlDate(String BirthDate)
    {
        String year=BirthDate.charAt(6)+""+BirthDate.charAt(7)+""+BirthDate.charAt(8)+""+BirthDate.charAt(9);
        String month=BirthDate.charAt(3)+""+BirthDate.charAt(4);
        String day=BirthDate.charAt(0)+""+BirthDate.charAt(1);
        String dt=year+"-"+month+"-"+day;
        return dt;
    }

    public static String toDate(String BirthDate)
    {
        String year=BirthDate.charAt(6)+""+BirthDate.charAt(7)+""+BirthDate.charAt(8)+""+BirthDate.charAt(9);
        String month=BirthDate.charAt(3)+""+BirthDate.charAt(4);
        String day=BirthDate.charAt(0)+""+BirthDate.charAt(1);
        String dt=day+"/"+month+"/"+year;
        return dt;
    }


}
