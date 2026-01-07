package ie.uni.collections;

public class Student {
  private final String STUDENT_NAME;
  private final String STUDENT_EMAIL;
  private final String STUDENT_COURSE;

  public Student(String stName, String stEmail, String stId) {
    this.STUDENT_NAME = stName;
    this.STUDENT_EMAIL = stEmail;
    this.STUDENT_COURSE = stId;
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