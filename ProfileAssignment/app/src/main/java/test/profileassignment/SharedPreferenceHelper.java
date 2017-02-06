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

    /*public void saveProfile(Profile profile){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName",profile);
        editor.commit();
    }*/

    public String getProfileName(){
        return sharedPreferences.getString("profileName",null);
    }
}