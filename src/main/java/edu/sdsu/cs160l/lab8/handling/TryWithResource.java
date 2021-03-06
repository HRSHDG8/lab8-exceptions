package edu.sdsu.cs160l.lab8.handling;

import edu.sdsu.cs160l.lab8.assignment.institute.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class TryWithResource {
  private static final String FILE_NAME = "/log.txt";

  public static void main(String[] args) {
    try {
      writeToFile("CS310", new Student(825000001L, "sheldon"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void writeToFile(String course, Student student) throws IOException {
    try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
         OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
      String text = "Added " + student.toString() + " to " + course + "\n";
      osw.write(text);
    }
  }

  /**
   * Same thing but a lot more code
   */
  public static void writeWithoutTryWithResource(String course, Student student) throws IOException {
    FileOutputStream fos = null;
    OutputStreamWriter osw = null;
    try {
      fos = new FileOutputStream(FILE_NAME);
      osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
      String text = "Added " + student.toString() + " to " + course + "\n";
      osw.write(text);
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException io) {
          io.printStackTrace();
        }
      }
      if (osw != null) {
        try {
          osw.close();
        } catch (IOException io) {
          io.printStackTrace();
        }
      }
    }
  }
}
