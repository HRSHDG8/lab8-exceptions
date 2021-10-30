package edu.sdsu.cs160l.lab8.institute;

import edu.sdsu.cs160l.lab8.exceptions.ClassFullException;
import edu.sdsu.cs160l.lab8.exceptions.StudentAlreadyEnrolledException;

import java.util.ArrayList;
import java.util.List;

public class Course {
  private static final int MAX_COURSE_SIZE = 2;
  private final String courseName;
  private final List<Student> studentsEnrolled;

  public Course(String courseName) {
    this.courseName = courseName;
    this.studentsEnrolled = new ArrayList<>();
  }

  /**
   * This carries 4 points on this lab (2 for implementation + 2 for your explanation)
   * TODO: explain:
   * 			  *        1) why a checked exception ClassFullException is used for
   * 			  *           the failed condition - adding a student when the class size is full
   * 			  *        2) why a checked exception StudentAlreadyEnrolledException is used for
   * 			  *           the failed condition - the student is already enrolled in the class
   * 			  *        3) what are some other checked exceptions could be thrown from this code (Think at least 2 more)
   * 			  *        4) why the unchecked exception (NullPointerException)
   * 			  *           are used for the bad conditions of the two arguments.
   * 			  *           If stu is null, throw NullPointerException.
   *        *       [Your names]: Write your answers to the above questions.
   */
  public void enrollStudent(Student studentToBeEnrolled) throws StudentAlreadyEnrolledException, ClassFullException {
    //TODO check if studentToBeEnrolled is null if yes throw new NullPointerException

    //TODO check if studentToBeEnrolled is not already enrolled in the class if yes create and throw a StudentAlreadyPresentException,
    // you may leverage the studentAlreadyPresent function below

    //TODO check is class is already full if yes create and throw a ClassFullException
    // you may leverage the isClassFull function below

    //TODO if all the checks pass, add the student to the the course list "studentsEnrolled"

  }

  private boolean studentAlreadyPresent(Student s) {
    return studentsEnrolled
       .stream()
       .anyMatch(student -> student.getRedId().equals(s.getRedId()));
  }

  private boolean isClassFull() {
    return studentsEnrolled.size() >= MAX_COURSE_SIZE;
  }

  @Override
  public String toString() {
    return "Course{" +
       "courseName='" + courseName + '\'' +
       ", studentsEnrolled=" + studentsEnrolled +
       '}';
  }
}
