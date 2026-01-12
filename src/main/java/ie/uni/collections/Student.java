package ie.uni.collections;

public class Student {
  private final String STUDENT_NAME;
  private final String STUDENT_EMAIL;
  private final String STUDENT_COURSE;

  public Student() {
    this.STUDENT_NAME = "";
    this.STUDENT_EMAIL = "";
    this.STUDENT_COURSE = "";
  }

  public Student(String studentName, String studentEmail, String studentId) {
    this.STUDENT_NAME = studentName;
    this.STUDENT_EMAIL = studentEmail;
    this.STUDENT_COURSE = studentId;
  }

  public String getSTUDENT_NAME() {
    return STUDENT_NAME;
  }

  public String getSTUDENT_EMAIL() {
    return STUDENT_EMAIL;
  }

  public String getSTUDENT_COURSE() {
    return STUDENT_COURSE;
  }

  @Override
  public String toString() {
    return "Student{" +
        " Name = '" + STUDENT_NAME + '\'' +
        ", Email = '" + STUDENT_EMAIL + '\'' +
        ", Course = '" + STUDENT_COURSE + '\'' +
        '}';
  }
}