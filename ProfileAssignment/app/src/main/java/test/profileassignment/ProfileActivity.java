package test.profileassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    protected Toolbar profileToolbar = null;
    protected EditText profileName = null;
    protected EditText profileAge = null;
    protected EditText studentID = null;
    protected Profile profile = new Profile();
    private SharedPreferenceHelper sharedPreferenceHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedPreferenceHelper = new SharedPreferenceHelper(ProfileActivity.this);
        profileToolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(profileToolbar);
        //Enable the Up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        profileName = (EditText) findViewById(R.id.profileName);
        profileAge = (EditText) findViewById(R.id.profileAge);
        studentID = (EditText) findViewById(R.id.studentID);

        final Button profileSaveButton = (Button) findViewById(R.id.profileSaveButton);

        profileSaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String name = profileName.getText().toString();
                String age = profileAge.getText().toString();
                String id = studentID.getText().toString();
                profile.saveName(name);
                profile.saveAge(age);
                profile.saveID(id);
                //here we'll pass in the newly saved object to the shared preferences
                sharedPreferenceHelper.saveProfile(profile);

                /*Toast toast = Toast.makeText(getApplicationContext(), "saved" , Toast.LENGTH_LONG);
                toast.show();*/

            }
        });
    }

    //Create the menu on the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_action_buttons, menu);

        return true;
    }

    //Decide what to do when a button is hit
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();//Go back to main activity
                return true;
            case R.id.action_setting:
                //call the editing button function
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
