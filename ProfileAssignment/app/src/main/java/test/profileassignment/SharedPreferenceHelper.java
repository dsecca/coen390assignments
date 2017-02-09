package test.profileassignment;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by David on 2017-02-06.
 */
/*CONTROLLER FOR SHARED PREFERENCES*/

public class SharedPreferenceHelper{

    private SharedPreferences sharedPreferences;
    protected static Profile profile = new Profile();
    public SharedPreferenceHelper(Context context){

        sharedPreferences = context.getSharedPreferences("ProfilePreference",Context.MODE_PRIVATE);
    }

    //Save the profile by using the SharedPreferneceHelper methods to save text entries
    public void saveProfile(Profile profle){
        profile = profle;
        this.saveProfileName(profile.getName());
        this.saveProfileAge(profile.getAge());
        this.saveStudentID(profile.getID());
    }
    public void saveProfileName(String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName",name);
        editor.commit();
    }

    public void saveProfileAge(String age){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileAge",age);
        editor.commit();
    }

    public void saveStudentID(String id){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("studentID",id);
        editor.commit();
    }

    //Return the profile
    public Profile getProfile(){
        return this.profile;
    }
}