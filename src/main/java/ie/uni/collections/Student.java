package ie.uni.collections;

public class Student {
  private final String STUDENT_NAME;
  private final String STUDENT_EMAIL;
  private final String STUDENT_COURSE;

  public Student(String studentName, String studentEmail, String studentId) {
    this.STUDENT_NAME = studentName;
    this.STUDENT_EMAIL = studentEmail;
    this.STUDENT_COURSE = studentId;
  }

  public String getEmail() {
    return STUDENT_EMAIL;
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