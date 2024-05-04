package com.uc2.dzprostatecare.pojo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.uc2.dzprostatecare.ui.activities.Home;
import com.uc2.dzprostatecare.ui.activities.Login;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAME = "NAME";
    public static final String EMAIL = "EMAIL";
    public static final String ID = "ID";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public void createSession(String name, String email, String id){

        editor.putBoolean(LOGIN, true);
        editor.putString(NAME, name);
        editor.putString(EMAIL, email);
        editor.putString(ID, id);
        editor.apply();

    }

    public void setLogin(boolean login)
    {
        editor.putBoolean(LOGIN,login);
        editor.commit();
    }



    public boolean getLoggin(){
        return sharedPreferences.getBoolean(LOGIN, false);
    }


    public void setUsername(String username)
    {
        editor.putString("KEY_USERNAME",username);
        editor.commit();
    }

    public String getUsername()
    {
        return sharedPreferences.getString("KEY USERNAME","");
    }

    public HashMap<String, String> getUserDetail(){

        HashMap<String, String> user = new HashMap<>();
        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(ID, sharedPreferences.getString(ID, null));

        return user;
    }

    public void logout(){

        editor.clear();
        editor.commit();
        Intent i = new Intent(context, Login.class);
        context.startActivity(i);
        ((Home) context).finish();

    }

}