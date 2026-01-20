package ie.uni.collections;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import org.apache.commons.validator.routines.EmailValidator;


public class StudentHandler {

  private final List<Student> STUDENT_LIST = new ArrayList<>();
  private final LinkedHashSet<String> STUDENT_EMAILS = new LinkedHashSet<>();
  private static final EmailValidator VALIDATOR = EmailValidator.getInstance();
  private final String STUDENT_ARRAY_LIST_FILENAME = "student_arraylist.txt";

  // Input attributes for count number of students
  public void addStudents(Scanner scan1, int count) {
    loadStudentEmails();
    for (int i = 0; i < count; i++) {
      System.out.println("\nStudent " + (i + 1));
      System.out.println("Please enter Student name: ");
      String name = firstCap(scan1.nextLine().toLowerCase().trim());

      System.out.println("Please enter Student email: ");
      String email = emailCheck(scan1, scan1.nextLine().toLowerCase().trim());

      System.out.println("Please enter Course: ");
      String course = firstCap(scan1.nextLine().toLowerCase().trim());
      // TODO: check for empty entries

      Student student = new Student(name, email, course);
      STUDENT_EMAILS.add(email);
      STUDENT_LIST.add(student);
      writeToFile(student);
    }
  }

  // Parse student emails from file to populate LinkedHashSet
  private void loadStudentEmails(){
    Pattern emailPattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");
    try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_ARRAY_LIST_FILENAME))) {
      String line;
      while ((line = br.readLine()) != null) {
        Matcher matcher = emailPattern.matcher(line);
        if (matcher.find()) {
          String email = matcher.group();
          STUDENT_EMAILS.add(email);
        }
      }
    } catch (IOException ex) {
      System.out.println("Could not read file: " + ex.getMessage());
    }
  }

  // Capitalizes the first letter in a String
  public String firstCap(String text) {
    char firstLetter = Character.toUpperCase(text.charAt(0));
    String rest = text.substring(1);
    return firstLetter + rest;
  }

  // Check if email is both valid and unique, keep prompting until entered
  private String emailCheck(Scanner scan2, String emailAddress) {
    while (!VALIDATOR.isValid(emailAddress) | STUDENT_EMAILS.contains(emailAddress)) {
      if (!VALIDATOR.isValid(emailAddress)) {
        System.out.println("That email is invalid. Please enter a valid email address:");
        emailAddress = scan2.nextLine().toLowerCase().trim();
      } else if (STUDENT_EMAILS.contains(emailAddress)) {
        System.out.println("That email is already in the system. Please enter another email:");
        emailAddress = scan2.nextLine().toLowerCase().trim();
      }
    }
    return emailAddress;
  }

  private void writeToFile(Student student) {
    try (PrintWriter out = new PrintWriter(new FileWriter(STUDENT_ARRAY_LIST_FILENAME, true))) {
      out.println(student);
      System.out.println("Saved to " + STUDENT_ARRAY_LIST_FILENAME);
    } catch (IOException ex) {
      System.err.println("Error writing to: " + ex.getMessage());
    }
  }

  public void printStudentArrayList() {
    System.out.println("\nThe following student(s) were saved to "
        + STUDENT_ARRAY_LIST_FILENAME + ":");
    for (Student student : STUDENT_LIST) {
      System.out.println(student);
    }
  }

  public void printEmailLinkedHashSet() {
    System.out.println("\nEmail LinkedHashSet contains:");
    for (String email : STUDENT_EMAILS) {
      System.out.print(email + " ");
    }
  }
}