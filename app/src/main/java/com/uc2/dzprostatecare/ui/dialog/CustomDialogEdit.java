package com.uc2.dzprostatecare.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.uc2.dzprostatecare.R;

public class CustomDialogEdit extends AppCompatDialogFragment {

    EditText editText;
    String textOne;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());

        LayoutInflater inflater=getActivity().getLayoutInflater();

        View view=inflater.inflate(R.layout.activity_edit_profile_dialog,null);



        builder.setView(view)
                .setTitle("Edit Password")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    textOne=editText.getText().toString();
                        Toast.makeText(getActivity(), textOne, Toast.LENGTH_SHORT).show();
                    }
                });

        editText=view.findViewById(R.id.firstRow);

        //Toast.makeText(this, p.getFirstName()+" "+pass, Toast.LENGTH_SHORT).show();

        return builder.create();
    }

    public String getTex()
    {
        return textOne;
    }


}
