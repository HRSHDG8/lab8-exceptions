package edu.sdsu.cs160l.lab8.assignment;

import edu.sdsu.cs160l.lab8.assignment.institute.Registrar;
import edu.sdsu.cs160l.lab8.assignment.institute.Student;
import edu.sdsu.cs160l.lab8.exceptions.ClassFullException;
import edu.sdsu.cs160l.lab8.exceptions.NoSuchCourseException;
import edu.sdsu.cs160l.lab8.exceptions.StudentAlreadyEnrolledException;

/**
 * Create a report explaining in one or more lines (carries 2 points)
 * 1) checked vs unchecked exceptions.
 * 2) why using exceptions as conditions is a bad idea.
 * 3) what is try with resources
 * 4) the flow of try catch finally
 */
public class Lab8 {

  private static final Registrar registrar = new Registrar();

  public static void main(String[] args) {
    Student hmac = new Student(825000001L, "hmac");
    Student john = new Student(825000002L, "john");
    Student jane = new Student(825000003L, "jane");
    Student nullStudent = null;
    executeTryCatch("CS210", hmac);
    // adding hmac again should give StudentAlreadyEnrolledException
    executeTryCatch("CS210", hmac);
    // adding null student should give NullPointerException
    executeTryCatch("CS210", nullStudent);
    executeTryCatch("CS210", john);
    // adding 3rd valid student to CS210 should give ClassFullException
    executeTryCatch("CS210", jane);

    // adding student to an invalid course should give NoSuchCourseException
    executeTryCatch("CS510", jane);
  }

  private static void executeTryCatch(String courseName, Student student) {
    try {
      registrar.enrollStudent(courseName, student);
    } catch (ClassFullException e) {
      System.err.println("Class Full Exception :: " + e.getMessage());
    } catch (NoSuchCourseException e) {
      System.err.println("No Such Course Exception :: " + e.getMessage());
    } catch (StudentAlreadyEnrolledException e) {
      System.err.println("Student " + student.toString() + " already enrolled to the course :: " + e.getMessage());
    } catch (Exception e) {
      System.err.println("Generic exception :: " + e.getClass().getName() + " :: " + e.getMessage());
    } finally {
      System.out.println("Code ends here");
    }
  }
}
