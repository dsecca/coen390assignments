package test.conucoursemanager; /**
 * Created by David on 2017-01-19.
 */

import java.util.Random;

public class Assignment {
    private static int assignmentNumber = 0;
    private String assignmentTitle;
    private int assignmentGrade;

    /*Constructor*/
    private Assignment(String title, int grade){
        //Assign a title and grade to assignment.
        //Increment assignment id for creation of every new assignment
        assignmentNumber++;
        assignmentTitle = title;
        assignmentGrade = grade;
    }

    public String getAssignmentTitle(){
        return assignmentTitle;
    }

    public int getAssignmentGrade(){
        return assignmentGrade;
    }

    public static Assignment getRandomAssignment(){
        Random randnum = new Random();
        int randAssignmentNum = randnum.nextInt(100) + 1;
        String randomTitle = "Assignment " + assignmentNumber;

        return new Assignment(randomTitle,randAssignmentNum);
    }


}
