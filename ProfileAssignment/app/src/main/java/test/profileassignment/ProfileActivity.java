package test.profileassignment;

import android.content.ClipData;
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
    protected Button profileSaveButton = null;
    protected static Profile profile = new Profile();
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

        //Initialize EditText variables for manipulation
        profileName = (EditText) findViewById(R.id.profileName);
        profileAge = (EditText) findViewById(R.id.profileAge);
        studentID = (EditText) findViewById(R.id.studentID);

        //Initially make fields uneditable
        profileName.setFocusable(false);
        profileAge.setFocusable(false);
        studentID.setFocusable(false);

        //Initialize save button but set it as invisible till edit button
        //is pressed
        profileSaveButton = (Button) findViewById(R.id.profileSaveButton);
        profileSaveButton.setVisibility(View.INVISIBLE);

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
                editFields();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Wen returning to the Profile Page, show the information stored within the profile
    protected void onStart(){
        super.onStart();
        Profile profile = sharedPreferenceHelper.getProfile();

        profileName.setText(profile.getName());
        profileAge.setText(profile.getAge());
        studentID.setText(profile.getID());
    }

    //Edit fields function
    protected void editFields(){
        //All fields to be editable
        profileName.setFocusableInTouchMode(true);
        profileAge.setFocusableInTouchMode(true);
        studentID.setFocusableInTouchMode(true);
        profileSaveButton.setVisibility(View.VISIBLE);

        //When save button is pressed, save fields to Shared Preferences
        profileSaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String name = profileName.getText().toString();
                String age = profileAge.getText().toString();
                String id = studentID.getText().toString();

                //Check if user put in a valid age
                if(!correctAge(age)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Must be 18-99 years old. Nothing saved!" , Toast.LENGTH_LONG);
                    toast.show();
                }
                //If user put in a valid age, we can save the data
                //NOTE: The Student ID and Name field data are monitored using the android::digits
                // declaration in the activity_profile.xml file
                else{
                    profile.saveName(name);
                    profile.saveAge(age);
                    profile.saveID(id);

                    //here we'll pass in the newly saved object to the shared preferences
                    sharedPreferenceHelper.saveProfile(profile);

                    Toast toast = Toast.makeText(getApplicationContext(), "Information Saved!" , Toast.LENGTH_LONG);
                    toast.show();

                    //Make fields unedittable again
                    profileName.setFocusable(false);
                    profileAge.setFocusable(false);
                    studentID.setFocusable(false);
                    profileSaveButton.setVisibility(View.INVISIBLE);
                }


            }
        });
    }

    //Function for checking age input by user
    protected boolean correctAge(String a){
        boolean ok = true;
        if((a.length() == 3 || a.length() == 1) ||
                (a.startsWith("1") && (a.endsWith("0")
                        ||a.endsWith("1")
                        ||a.endsWith("2")
                        || a.endsWith("3")
                        ||a.endsWith("4")
                        ||a.endsWith("5")
                        ||a.endsWith("6")
                        ||a.endsWith("7")))){
            ok = false;
        }
        return ok;
    }
}
