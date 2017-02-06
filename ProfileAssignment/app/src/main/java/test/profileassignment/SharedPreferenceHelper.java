package test.profileassignment;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by David on 2017-02-06.
 */
/*CONTROLLER FOR SHARED PREFERENCES*/

public class SharedPreferenceHelper{

    private SharedPreferences sharedPreferences;
    public SharedPreferenceHelper(Context context){

        sharedPreferences = context.getSharedPreferences("ProfilePreference",Context.MODE_PRIVATE);
    }

    public void saveProfileName(String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName",name);
        editor.commit();
    }

    public void saveAge(String age){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileAge",age);
        editor.commit();

    }

    public void saveID(String id){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("studentID", id);
        editor.commit();
    }

    public String getProfileName(){
        return sharedPreferences.getString("profileName",null);
    }
}