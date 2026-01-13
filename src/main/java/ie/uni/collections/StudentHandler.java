package ie.uni.collections;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class StudentHandler {

  private final List<Student> studentList = new ArrayList<>();
  private final LinkedHashSet<String> studentEmails = new LinkedHashSet<>();

  // Input for count number of students
  public void addStudents(Scanner scan1, int count) {
    for (int i = 0; i < count; i++) {
      System.out.println("Student " + (i + 1));
      System.out.println("Please enter Student name: ");
      String name = firstCap(scan1.nextLine().toLowerCase().trim());

      System.out.println("Please enter Student email: ");
      String email = duplicateEmailCheck(scan1, scan1.nextLine().toLowerCase().trim());

      System.out.println("Please enter Course: ");
      String course = firstCap(scan1.nextLine().toLowerCase().trim());
      // TODO: check for empty entries

      studentEmails.add(email);
      studentList.add(new Student(name, email, course));
    }
  }

  // Capitalizes the first letter in a String
  public String firstCap(String text) {
    char firstLetter = Character.toUpperCase(text.charAt(0));
    String rest = text.substring(1);
    return firstLetter + rest;
  }

  // Check if email already exists and keep prompting until a unique email is entered
  private String duplicateEmailCheck(Scanner scan2, String emailAddress) {
    while (studentEmails.contains(emailAddress)) {
      System.out.println("That email is already in the system. Please enter another email:");
      emailAddress = scan2.nextLine().toLowerCase().trim();
    }
    return emailAddress;
  }

  public void printStudentArrayList() {
    System.out.println("\nStudent Arraylist contains:");
    for (Student student : studentList) {
      System.out.println(student);
    }
  }

  public void printEmailLinkedHashSet() {
    System.out.println("\nEmail LinkedHashSet contains:");
    for (String email : studentEmails) {
      System.out.print(email + " ");
    }
  }
}