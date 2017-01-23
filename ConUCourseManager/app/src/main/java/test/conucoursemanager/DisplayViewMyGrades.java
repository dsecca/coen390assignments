package test.conucoursemanager; /**
 * Created by David on 2017-01-19.
 */

/**
 * Created by David on 2017-01-19.
 */

import java.util.ArrayList;

public class DisplayViewMyGrades {
    public static void main(String[] a)
    {
        for(int j=0; j<5; j++) {
            Course course = Course.getRandomCourse();
            ArrayList<Assignment> assignments = course.getAssignments();
            System.out.println("\n");
            System.out.println(course.getCourseName());
            for (int i = 0; i < assignments.size(); i++) {
                System.out.println(assignments.get(i).getAssignmentTitle()
                        + " " + assignments.get(i).getAssignmentGrade());
            }
        }
    }
}

