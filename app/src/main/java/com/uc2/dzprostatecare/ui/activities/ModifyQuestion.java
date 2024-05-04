package com.uc2.dzprostatecare.ui.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import com.uc2.dzprostatecare.pojo.Question;
import com.uc2.dzprostatecare.pojo.RequestHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ModifyQuestion extends AppCompatActivity {

    Question q;
    EditText qst,ans;
    TextView mod;
    ImageView mQst,deleteQst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_question);
        Intent intent=this.getIntent();
        Bundle b=intent.getExtras();
        q= (Question) b.getSerializable("qst");
        qst=findViewById(R.id.mquestiondetails);
        qst.setText(q.getTitle());
        ans=findViewById(R.id.questionAnswer);
        mod=findViewById(R.id.modify_btn);
        mQst=findViewById(R.id.m_question_back);
        deleteQst=findViewById(R.id.delete_question);



        mQst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


       mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyUp();

            }
        });

        if((q.getAnswer().equals("")))
        {
            ans.setVisibility(View.INVISIBLE);
            mod.setVisibility(View.VISIBLE);
            qst.setFocusable(true);
            deleteQst.setVisibility(View.VISIBLE);
        }
        else
        {
            ans.setVisibility(View.VISIBLE);
            mod.setVisibility(View.INVISIBLE);
            deleteQst.setVisibility(View.INVISIBLE);
            qst.setFocusable(false);
            ans.setText(q.getAnswer());
            ans.setFocusable(false);

        }


        deleteQst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            deleteQstOk();
            }
        });





    }


    public void applyUp()
    {
        if((qst.getText().toString()).equals(""))
        {
           deleteQstOk();
        }else
        { updateQuestion(q.getIdQst(),qst.getText().toString());
            finish();
        }

    }


    private void updateQuestion(int id,String newQst) {
        /*
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_UPDATE_QUESTION,
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
                params.put("newqst", newQst);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

         */
    }

    private void deleteQuestion(int id) {
        /*
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_DELETE_QUESTION,
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
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

         */
    }


    public void deleteQstOk()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirm");
        builder.setMessage("Are you sure to delete this question?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                // Do nothing, but close the dialog
                deleteQuestion(q.getIdQst());
                dialog.dismiss();
                finish();

            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing

                dialog.dismiss();
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}