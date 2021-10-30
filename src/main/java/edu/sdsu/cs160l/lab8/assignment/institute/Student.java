package edu.sdsu.cs160l.lab8.institute;

public class Student {
  private final Long redId;
  private final String name;

  public Student(Long redId, String name) {
    this.redId = redId;
    this.name = name;
  }

  public Long getRedId() {
    return redId;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Student{" +
       "redId=" + redId +
       ", name='" + name + '\'' +
       '}';
  }
}
