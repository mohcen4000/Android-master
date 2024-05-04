package com.uc2.dzprostatecare.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.ui.fragment.DiaryFragment;
import com.uc2.dzprostatecare.ui.fragment.Home_Fragment;
import com.uc2.dzprostatecare.ui.fragment.ProgressFragment;
import com.uc2.dzprostatecare.ui.fragment.NotificationFragment;
import com.uc2.dzprostatecare.R;

import static android.view.View.VISIBLE;

public class Home extends AppCompatActivity{

    BottomNavigationView btm;
    FloatingActionButton fab;
    FragmentTransaction transaction;
    View notificationBadge;
    int notificationNumber;
    Patient p;
    int idp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_home);


        btm = findViewById(R.id.btm);
        btm.setBackground(null);
        fab = findViewById(R.id.fab);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
      //  p= (Patient) bundle.getSerializable("patient");
        idp=bundle.getInt("id");

        getIntent().putExtra("id", idp);

        Toast.makeText(this, idp+"whoah", Toast.LENGTH_SHORT).show();






        Home_Fragment fragment=new Home_Fragment();
        transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_home,fragment);
        transaction.commit();

        btm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()) {
                    case R.id.home:
                        fragment=new Home_Fragment();
                        break;
                    case R.id.progress:
                        fragment=new ProgressFragment();
                        break;
                    case R.id.Diary:
                        fragment=new DiaryFragment();
                        break;
                    case R.id.notification:
                        fragment=new NotificationFragment();
                        break;

                }
                transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container_home,fragment);
                transaction.commit();

                addBadgeView();

                return false;
            }
        });



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                refreshBadgeView();

            }
        });

        addBadgeView();


    }
    


    private void addBadgeView() {
        try {
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) btm.getChildAt(0);
            BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(3); //set this to 0, 1, 2, or 3.. accordingly which menu item of the bottom bar you want to show badge

            notificationBadge = LayoutInflater.from(Home.this).inflate(R.layout.custom_badge_layout, menuView, false);
            itemView.addView(notificationBadge);
            TextView tv=notificationBadge.findViewById(R.id.notifications_badge);
            notificationNumber=getNotificationNumber();
            tv.setText(notificationNumber+"");
            notificationBadge.setVisibility(VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshBadgeView() {
        try {
            boolean badgeIsVisible = notificationBadge.getVisibility() != View.GONE;
            notificationBadge.setVisibility(badgeIsVisible ? View.GONE : VISIBLE);//makes badge visible and invisible
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout);

        LinearLayout editLayout = dialog.findViewById(R.id.appointment);
        LinearLayout shareLayout = dialog.findViewById(R.id.layoutShare);
        LinearLayout uploadLayout = dialog.findViewById(R.id.layoutUpload);

        dialog.dismiss();


        editLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Intent intent=new Intent(Home.this,addAppointment.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        shareLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent=new Intent(Home.this,AddNewQuestion.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


        uploadLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Intent intent=new Intent(getApplicationContext(), EditSymptoms.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }


    public int getNotificationNumber()
    {
        return 10;
    }



}


