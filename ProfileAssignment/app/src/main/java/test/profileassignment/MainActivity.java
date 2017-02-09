package test.profileassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button mainActivityButton = null;
    protected Toolbar mainToolbar = null;
    private SharedPreferenceHelper sharedPreferenceHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainToolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);
        mainActivityButton = (Button) findViewById(R.id.mainActivityButton);
        sharedPreferenceHelper = new SharedPreferenceHelper(MainActivity.this);

        mainActivityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Bring user to profile page so they can edit their information
                goToProfileActivity();
            }
        });
    }

    //Check whether a profile was created
    protected void onStart(){
        super.onStart();
        //Get the profile from Shared Preferences
        Profile profile = sharedPreferenceHelper.getProfile();

        if(profile.getName() == null){
            goToProfileActivity();
        }
        else{
            mainActivityButton.setText(profile.getName());
        }
    }
    public void goToProfileActivity(){
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}
