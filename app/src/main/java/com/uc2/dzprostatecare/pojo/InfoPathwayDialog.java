package com.uc2.dzprostatecare.pojo;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.uc2.dzprostatecare.R;

public class InfoPathwayDialog {
    private Context context;
    TextView t,d;
    ImageView i;

    public InfoPathwayDialog(){

    }
    public InfoPathwayDialog(Context context){
        this.context = context;
    }

    public void showInfoDialog(String title,String details,int pic){
        final Dialog dialog1 = new Dialog(context, R.style.df_dialog);
        dialog1.setContentView(R.layout.dialog_info);
        dialog1.setCancelable(true);
        dialog1.setCanceledOnTouchOutside(true);
        t=dialog1.findViewById(R.id.infoheading);
        d=dialog1.findViewById(R.id.infodetails);
        i=dialog1.findViewById(R.id.test_img);
        t.setText(title);
        d.setText(details);
        i.setImageResource(pic);
        dialog1.findViewById(R.id.btnSpinAndWinRedeemi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });
        dialog1.show();
    }



}