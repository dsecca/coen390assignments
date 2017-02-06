package test.profileassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button mainActivityButton = null;
    private SharedPreferenceHelper sharedPreferenceHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityButton = (Button) findViewById(R.id.mainActivityButton);
        sharedPreferenceHelper = new SharedPreferenceHelper(MainActivity.this);

        mainActivityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Bring user to profile page so they can edit their information
                goToProfileActivity();

            }
        });
    }

    protected void onStart(){
        super.onStart();
        String profileName = sharedPreferenceHelper.getProfileName();

        if(profileName == null){
            mainActivityButton.setText(profileName);
        }
        else{
            goToProfileActivity();
        }
    }
    public void goToProfileActivity(){
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}
