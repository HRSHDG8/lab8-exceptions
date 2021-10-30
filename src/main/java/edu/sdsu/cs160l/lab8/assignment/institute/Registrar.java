package edu.sdsu.cs160l.lab8.institute;

import edu.sdsu.cs160l.lab8.exceptions.ClassFullException;
import edu.sdsu.cs160l.lab8.exceptions.NoSuchCourseException;
import edu.sdsu.cs160l.lab8.exceptions.StudentAlreadyEnrolledException;

import java.util.*;

public class Registrar {
  private final Map<String, Course> courseList;
  private final List<String> validCourseList;

  public Registrar() {
    courseList = new HashMap<>();
    courseList.put("CS210", new Course("CS210"));
    courseList.put("CS310", new Course("CS310"));
    courseList.put("CS410", new Course("CS410"));
    validCourseList = Collections.unmodifiableList(Arrays.asList("CS210", "CS310", "CS410"));
  }

  /**
   * This piece holds on 2 points for implementation
   */
  public void enrollStudent(String courseName, Student s) throws ClassFullException, NoSuchCourseException, StudentAlreadyEnrolledException {
    //TODO check if courseName is a valid courseName if not throw a new NoSuchCourseException
    // you may use the isValidCourse function


    Course course = courseList.get(courseName);
    course.enrollStudent(s);

  }

  private boolean isNotValidCourse(String courseName) {
    return !validCourseList.contains(courseName);
  }
}
