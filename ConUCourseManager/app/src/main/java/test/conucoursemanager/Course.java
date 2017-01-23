package test.conucoursemanager; /**
 * Created by David on 2017-01-19.
 */

import java.util.ArrayList;
import java.util.Random;

public class Course {
    private static int courseID = 0;
    private String courseName;
    private ArrayList<Assignment> assignments;

    private Course(String name, ArrayList<Assignment> assignment){
        Random r = new Random();
        courseID = r.nextInt(499) + 1;
        courseName = name;
        assignments = assignment;
    }

    public String getCourseName(){
        return courseName;
    }

    public ArrayList<Assignment> getAssignments(){
        return assignments;
    }

    public static Course getRandomCourse(){
        //Generate random assignments to this course
        Random randnum = new Random();
        int randCourseNum = randnum.nextInt(5) + 1;
        ArrayList<Assignment> tempAssignments = new ArrayList<Assignment>();

        for(int i = 0; i < randCourseNum; i++){
            tempAssignments.add(Assignment.getRandomAssignment());
        }

        return new Course("Course " + courseID, tempAssignments);
    }

    public int getAverageGrades(){
        int sum = 0;
        int avg = 0;
        for(int i = 0; i < assignments.size(); i++){
            if(i == 0){
                sum = assignments.get(i).getAssignmentGrade();
            }
            else{
                sum += assignments.get(i).getAssignmentGrade();
            }
        }
        avg = sum/assignments.size();

        return avg;
    }


}
