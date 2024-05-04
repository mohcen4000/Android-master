package com.uc2.dzprostatecare.ui.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.RequestHandler;
import com.uc2.dzprostatecare.ui.activities.profile.Address;
import com.uc2.dzprostatecare.ui.activities.profile.Phone;
import com.uc2.dzprostatecare.ui.activities.profile.Carer;
import com.uc2.dzprostatecare.ui.activities.profile.Email;
import com.uc2.dzprostatecare.ui.activities.profile.FirstName;
import com.uc2.dzprostatecare.ui.activities.profile.LastName;
import com.uc2.dzprostatecare.ui.activities.profile.YearOfBirth;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfile extends AppCompatActivity {

    LinearLayout bar;
    Patient p1,p;
    ImageView im;
    RelativeLayout rl1,rl2,rl3,rl4,rl5,rl6,rl7;
    TextView firstName1,lastName1,yearBirth1,phoneinp,email1,carer1,address1;
    TextView progtext;
    int idp;
    static int percent;
    private Bitmap bitmap;
    CircleImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        bar=findViewById(R.id.profilebar);
        image=findViewById(R.id.profileCircleImageView);

        LinearLayout commonCardContainer = (LinearLayout) findViewById(R.id.profilebar);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) commonCardContainer.getLayoutParams();
        params.width = 50;
        params.weight=5;
        commonCardContainer.setLayoutParams(params);

        progtext=findViewById(R.id.progtext1);

        progtext.setText("15%");

        firstName1=findViewById(R.id.first_name_val);
        lastName1=findViewById(R.id.last_name_val);
        yearBirth1=findViewById(R.id.year_of_birth_val);
        phoneinp = findViewById(R.id.phone_number_val);
        email1=findViewById(R.id.email_val);
        carer1=findViewById(R.id.carer_val);
       address1=findViewById(R.id.address_val);


        im=findViewById(R.id.edit_profile_back);
        rl1=findViewById(R.id.first_name_ed);
        rl2=findViewById(R.id.last_name_ed);
        rl3=findViewById(R.id.year_ed);
        rl4=findViewById(R.id.carer_ed);
        rl5=findViewById(R.id.email_ed);
        rl6=findViewById(R.id.phone_ed);
        rl7=findViewById(R.id.address_ed_a);


        Intent intent=getIntent();
       // p= (Patient) intent.getSerializableExtra("p");
        Bundle b=intent.getExtras();
        idp=b.getInt("id");

        getDataEditProfile(idp);






        rl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditProfile.this, FirstName.class);
                Bundle b=new Bundle();
                 b.putInt("id",idp);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        rl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditProfile.this, LastName.class);
                Bundle b=new Bundle();
                b.putInt("id",idp);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        rl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditProfile.this, YearOfBirth.class);
                Bundle b=new Bundle();
                b.putInt("id",idp);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        rl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditProfile.this, Carer.class);
                Bundle b=new Bundle();
                b.putInt("id",idp);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        rl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditProfile.this, Email.class);
                Bundle b=new Bundle();
                b.putInt("id",idp);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        rl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditProfile.this, Phone.class);
                Bundle b=new Bundle();
                b.putInt("id",idp);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        rl7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditProfile.this, Address.class);
                Bundle b=new Bundle();
                b.putInt("id",idp);
                intent.putExtras(b);
                startActivity(intent);
            }
        });



        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getDataEditProfile(idp);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getDataEditProfile(idp);
    }

    private void getDataEditProfile(int id){

    }

    public void chooseFile()
    {
        Intent intent=new Intent();
        intent.setType("image/");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data !=null && data.getData()!=null)
        {
        Uri filepath=data.getData();
            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                image.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }

           uploadPicture(String.valueOf(idp),getStringImg(bitmap));


        }
    }

    private void uploadPicture(final String id,final String photo) {
    /*


        final ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setMessage("Uploading");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST,
                Constants.URL_UPLOAD_PIC,  new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    Boolean success=jsonObject.getBoolean("error");
                    if(!success)
                    {
                        Toast.makeText(EditProfile.this, "Success", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                    Toast.makeText(EditProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(EditProfile.this, "Try Again 2!", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("id",id);
                params.put("photo",photo);

                return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

     */
    }

    public String getStringImg(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);

        byte[] imageByteArray=byteArrayOutputStream.toByteArray();
        String encodesImage= Base64.encodeToString(imageByteArray,Base64.DEFAULT);

       return encodesImage;
    }
}