package test.profileassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ProfileActivity extends AppCompatActivity {

    protected Toolbar profileToolbar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileToolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(profileToolbar);

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
