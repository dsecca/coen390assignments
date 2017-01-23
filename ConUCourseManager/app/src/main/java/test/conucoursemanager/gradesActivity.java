package test.conucoursemanager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class gradesActivity extends AppCompatActivity {

    protected Toolbar viewMyGradesToolbar = null;
    protected ArrayList<Course> courses;//Store random courses in this vector
                                        //Run this array through array adapter and populate ListView
    protected ListView gradesListView = null; //ListView will contain a set of Views: course_data.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        setupUI();

        //Generate random courses and store them in courses array
        courses = createCourses();
        //Display courses to the ListView
        displayCourses();

    }

    //Create the menu on the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_grades, menu);

        return true;
    }

    //Decide what to do when the up button is hit
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();//Go back to main activity
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void setupUI(){
        //Set up the toolbar
        viewMyGradesToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(viewMyGradesToolbar);

        //Enable the Up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setup the list view
        gradesListView = (ListView) findViewById(R.id.gradesListView);
    }

    //Generate 1 to 7 courses to display, then store those course
    //in this activity's "courses" array list method
    protected static ArrayList<Course> createCourses(){
        Random randnum = new Random();
        int randCourseNum = randnum.nextInt(7) + 1;
        ArrayList<Course> tempCourses = new ArrayList<Course>();

        for(int i = 0; i < randCourseNum; i++){
            tempCourses.add(Course.getRandomCourse());
        }

        return tempCourses;
    }

    protected void displayCourses(){
        //Get all String items to be listed in an array.
        Vector<String> courseInfo = new Vector<String>();
        String grade;

        //For each randomly generated course, add the course name, assignments,
        // assignment grades and average of all assignments and prepare to display
        //them to the ListView
        for(int i = 0; i < courses.size(); i++){
            courseInfo.add(courses.get(i).getCourseName());
            //Add data from each assignment pertaining to the course in courses.get(i)
            for(int j = 0; j < courses.get(i).getAssignments().size(); j++){

                grade = Integer.toString(courses.get(i).getAssignments().get(j).getAssignmentGrade());
                courseInfo.add(
                        courses.get(i).getAssignments().get(j).getAssignmentTitle()
                        + ":    "
                        + grade);
            }
            courseInfo.add(
                    "Average grade in "
                            + courses.get(i).getCourseName()
                            + ":    "
                            + courses.get(i).getAverageGrades());
            courseInfo.add("\n");
        }
        //Build the adapter
        //The parameters past to adapter are the context, display to use and data to use
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.course_data, courseInfo);
        //Configure the ListView
        gradesListView.setAdapter(adapter);
    }
}
