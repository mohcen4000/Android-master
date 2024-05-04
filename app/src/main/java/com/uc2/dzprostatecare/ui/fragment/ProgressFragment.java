package com.uc2.dzprostatecare.ui.fragment;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.uc2.dzprostatecare.AAChartCoreLib.AAChartCreator.AAChartModel;
import com.uc2.dzprostatecare.AAChartCoreLib.AAChartCreator.AAChartView;
import com.uc2.dzprostatecare.AAChartCoreLib.AAChartCreator.AASeriesElement;
import com.uc2.dzprostatecare.AAChartCoreLib.AAChartEnum.AAChartType;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Constants;
import com.uc2.dzprostatecare.pojo.Patient;
import com.uc2.dzprostatecare.pojo.PhysicalData;
import com.uc2.dzprostatecare.ui.activities.Register;
import com.uc2.dzprostatecare.ui.activities.learn_about_pca.Glucose;
import com.uc2.dzprostatecare.ui.activities.physical_data.Pressure;
import com.uc2.dzprostatecare.ui.activities.physical_data.Psa;
import com.uc2.dzprostatecare.ui.activities.physical_data.Pulse;
import com.uc2.dzprostatecare.ui.activities.physical_data.Temperature;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ProgressFragment extends Fragment {


    AAChartView aaChartView;
    ProgressDialog progressdialog;
    Patient p;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    int idp;

    ImageView plus_psa,plus_pressure,plus_temp,plus_pulse,plus_glucose;

    LinearLayout psa,glucose,pressure,temp,pulse;
    TextView psa_range,gluc,pres,tem,pu;


    public ProgressFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_progress, container, false);


        Intent i = getActivity().getIntent();
        Bundle bundle=i.getExtras();

       //p= (Patient) i.getSerializableExtra("patient");
       idp=bundle.getInt("id");




        plus_psa=view.findViewById(R.id.plus_psa);
        plus_pressure=view.findViewById(R.id.plus_pressure);
        plus_pulse=view.findViewById(R.id.pluse_pulse);
        plus_temp=view.findViewById(R.id.plus_temp);
        plus_glucose=view.findViewById(R.id.plus_glucose);

        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(calendar.getTime());

        getPhy(idp, date);


        progressdialog = new ProgressDialog(getContext());
        progressdialog.setMessage("Please Wait....");
        progressdialog.show();

        aaChartView = view.findViewById(R.id.chart);
        float a=0;
        float radius=20;
        float maxx=6;
       // AAStyle aaStyle=new AAStyle();
        AAChartModel aaChartModel = new AAChartModel()
                .chartType(AAChartType.Area)
                .borderRadius(radius)
                .title("")
                .borderRadius(radius)
                .subtitle("")
                .categories(new String[]{"12 March","17 March","19 March"})
                .xAxisVisible(true)
                .yAxisVisible(false)
                .yAxisMin(a)
                .yAxisMax(maxx)
                .dataLabelsEnabled(true)
                .yAxisGridLineWidth(0f)
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("PSA")
                                .data(new Object[]{7.0, 6.9, 7}),
                        new AASeriesElement()
                                .name("Glucose")
                                .data(new Object[]{0.2, 0.8, 5.7}),
                        new AASeriesElement()
                                .name("Pressure")
                                .data(new Object[]{0.9, 0.6, 3.5}),
                        new AASeriesElement()
                                .name("Pulse")
                                .data(new Object[]{3.9, 4.2, 5.7})
                });

        aaChartView.aa_drawChartWithChartModel(aaChartModel);

        psa_range=view.findViewById(R.id.value_psa);
        gluc=view.findViewById(R.id.glucose_value);
        pu=view.findViewById(R.id.pulse_value);
        tem=view.findViewById(R.id.temp_value);
        pres=view.findViewById(R.id.pressure_value);


        psa=view.findViewById(R.id.psa_add);
        glucose=view.findViewById(R.id.glucose_add);
        pressure=view.findViewById(R.id.pressure_add);
        pulse=view.findViewById(R.id.pulse_add);
        temp=view.findViewById(R.id.temp_add);





        psa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),Psa.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        glucose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), Glucose.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), Pressure.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        pulse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), Pulse.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), Temperature.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",idp);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });





        return view;


    }


    @Override
    public void onStart() {
        super.onStart();
        progressdialog.dismiss();
    }


    @Override
    public void onResume() {
        super.onResume();
        getPhy(idp,Register.toMysqlDate(date));

    }



    public void getPhy(int id,String date){}

    public void getPhybetween(String date1,String date2)
    {

    }




}