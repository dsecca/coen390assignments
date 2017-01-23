package test.conucoursemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class mainActivity extends AppCompatActivity {

    protected Button viewMyGrades = null;
    protected Toolbar viewMainToolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set up the UI
        setupUI();
    }

    protected void setupUI(){
        //Bind toolbar element to viewMainToolbar variable
        viewMainToolbar = (Toolbar) findViewById(R.id.main_toolbar);

        //Allow to modify toolbar parameters
        setSupportActionBar(viewMainToolbar);

        //Set main menu title in toolbar
        getSupportActionBar().setTitle("ConU Course Manager");

        //Bind view my grades button element to viewMyGrades variable
        viewMyGrades = (Button) findViewById(R.id.viewMyGrades);

        //Set listener for clicking to grades activity
        viewMyGrades.setOnClickListener(clickViewMyGrades);
    }

    //Define what clicking View My Grades button does
    private Button.OnClickListener clickViewMyGrades = new Button.OnClickListener(){
        //Whenever View My Grades button is clicked, move to gradesActivity
        public void onClick(View v){
            //Change activity
            //Here we create the Intent (or action to be performed)
            Intent changeToViewMyGradesActivity = new Intent(mainActivity.this, gradesActivity.class);
            //Perform the intent
            mainActivity.this.startActivity(changeToViewMyGradesActivity);
        }
    };

}
