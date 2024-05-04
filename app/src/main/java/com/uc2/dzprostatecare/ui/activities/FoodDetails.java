package com.uc2.dzprostatecare.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.uc2.dzprostatecare.R;

public class FoodDetails extends AppCompatActivity {

    RatingBar ratingBar;
    TextView ratingg;
    ImageView backk,img5;
    String name,img,tx;
    TextView n,tx8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail_conf);

       ratingBar=findViewById(R.id.ratingBar);

       ratingBar.setDrawingCacheBackgroundColor(getResources().getColor(R.color.blue1));
       //ratingBar.color

       ratingg=findViewById(R.id.rating);
       backk=findViewById(R.id.imageViewback);
       n=findViewById(R.id.name);

       img5=findViewById(R.id.imageView5);
       tx8=findViewById(R.id.textView8);

       Intent intent=getIntent();
       Bundle b=intent.getExtras();
       name=b.getString("name");
       img=b.getString("image");
       tx=b.getString("note");


       n.setText(name);
       tx8.setText(tx);

        Glide.with(this).load(img).into(img5);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                ratingg.setText(rating+"");

            }
        });

        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}