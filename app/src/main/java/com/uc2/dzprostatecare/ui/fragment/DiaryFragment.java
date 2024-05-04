package com.uc2.dzprostatecare.ui.fragment;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Consultation;
import com.uc2.dzprostatecare.ui.activities.SettingsActivity;
import com.uc2.dzprostatecare.ui.adapter.ConsPeriodAdapter;
import java.util.ArrayList;
import java.util.Calendar;


import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;



public class DiaryFragment extends Fragment {


    RecyclerView PeriodRecycler;
    ArrayList<Consultation> consultations;
    ArrayList<Consultation> evening;
    ArrayList<Consultation> night;
    ImageView navig;
    int idp;

    private RecyclerView.Adapter consPeriodAdapter;
    private RecyclerView.LayoutManager cLayoutManager;


    public DiaryFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_diary, container, false);

        consultations=new ArrayList<>();
        consultations.add(new Consultation(3,R.drawable.ic_pill,"08 AM - 09 AM","You are good","Medication"));
        consultations.add(new Consultation(4,R.drawable.ic_icons__biopsy,"09 AM - 11 AM","You are good","PSA test result"));


        evening=new ArrayList<>();

        //evening.add(new Consultation(R.drawable.ic_pill,"13 PM - 15 PM","You are good","Medication"));
        //consultations.add(new Consultation("17 PM - 19 AM","You are good","PSA test result"));
        //evening.add(new Consultation(R.drawable.ic_pill,"15 PM - 17 PM","You are good","Sport Time"));
        evening.add(new Consultation(2,R.drawable.ic_tray,"17 - 19  PM","You are good","Food Time"));

        night=new ArrayList<>();


        //night.add(new Consultation(R.drawable,"19 PM - 21 PM","You are good","Physical Data Check"));
        night.add(new Consultation(1,R.drawable.ic_moon_,"21 PM","You are good","Sleep Time"));




        Intent intent=getActivity().getIntent();
        Bundle bundle=intent.getExtras();
        idp=bundle.getInt("id");

        setPeriodRecycler(consultations,view,R.id.morninng);
        setPeriodRecycler(evening,view,R.id.evening_recycler);
        setPeriodRecycler(night,view,R.id.night_recycler);

        navig=view.findViewById(R.id.navigation);

        navig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), SettingsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });


        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }

            @Override
            public void onCalendarScroll(HorizontalCalendarView calendarView,
                                         int dx, int dy) {

            }

            @Override
            public boolean onDateLongClicked(Calendar date, int position) {
                return true;
            }
        });








        return view;
    }


    private  void setPeriodRecycler(ArrayList<Consultation> consultations,View view,int resID){

        PeriodRecycler= view.findViewById(resID);
//        PeriodRecycler.setHasFixedSize(true);
        cLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        consPeriodAdapter = new ConsPeriodAdapter(consultations);
        PeriodRecycler.setLayoutManager(cLayoutManager);
        PeriodRecycler.setAdapter(consPeriodAdapter);

    }

    private  void setPeriodRecycler(ArrayList<Consultation> consultations,View view){

        PeriodRecycler= view.findViewById(R.id.morninng);
//        PeriodRecycler.setHasFixedSize(true);
        cLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        consPeriodAdapter = new ConsPeriodAdapter(consultations);
        PeriodRecycler.setLayoutManager(cLayoutManager);
        PeriodRecycler.setAdapter(consPeriodAdapter);

    }

   /* private void updateLabel(View v) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        EditText t=v.findViewById(R.id.inputDate);
        t.setText(sdf.format(myCalendar.getTime()));
    } */

}