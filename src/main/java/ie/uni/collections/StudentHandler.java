package ie.uni.collections;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.validator.routines.EmailValidator;


public class StudentHandler {
  private final List<Student> STUDENT_LIST = new ArrayList<>();
  private final LinkedHashSet<String> STUDENT_EMAILS = new LinkedHashSet<>();
  private static final EmailValidator VALIDATOR = EmailValidator.getInstance();
  private final String STUDENT_ARRAY_LIST_FILENAME = "student_arraylist.txt";
  private final String EMAIL_ONLY_LIST_FILENAME = "email_only_list.txt";

  // Input attributes for count number of students, store in collections then write to files
  public void addStudents(Scanner scan1, int count) {
    loadStudentEmails();
    for (int i = 0; i < count; i++) {
      System.out.println("\nStudent " + (i + 1));
      String name = firstCap(emptyEntryCheck("Please enter Student name: ", scan1));
      String email = emailCheck("Please enter Student email: ", scan1);
      String course = firstCap(emptyEntryCheck("Please enter Course: ", scan1));

      Student student = new Student(name, email, course);
      STUDENT_EMAILS.add(email);
      STUDENT_LIST.add(student);
      writeToFile(student, email);
    }
  }

  // Parse student emails from file to populate LinkedHashSet
  private void loadStudentEmails(){
    try (BufferedReader br = new BufferedReader(new FileReader(EMAIL_ONLY_LIST_FILENAME))) {
      String line;
      while ((line = br.readLine()) != null) {
        STUDENT_EMAILS.add(line);
      }
    } catch (IOException ex) {
      System.out.println("Could not read file: " + ex.getMessage());
    }
  }

  // Check if entry is not empty, keep prompting until entered
  private static String emptyEntryCheck(String prompt, Scanner sc) {
    while (true) {
      System.out.print(prompt);
      String line = sc.nextLine().toLowerCase().trim();
      if (!line.isEmpty()) {
        return line;
      }
      System.out.println("This field cannot be empty – please try again.");
    }
  }

  // Capitalizes the first letter of every word in a String
  public String firstCap(String text) {
    String[] parts = text.split("\\s+");
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < parts.length; i++) {
      String capitalized = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);
      result.append(capitalized);
      if (i < parts.length - 1) {
        result.append(' ');
      }
    }
    return result.toString();
  }

  // Check if email is both valid and unique, keep prompting until entered
  private String emailCheck(String prompt, Scanner scan2) {
    System.out.print(prompt);
    String emailAddress = scan2.nextLine();
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

  private void writeToFile(Student student, String email) {
    // Save student data in separate file
    try (PrintWriter out = new PrintWriter(new FileWriter(STUDENT_ARRAY_LIST_FILENAME, true))) {
      out.println(student);
      System.out.println("Saved to " + STUDENT_ARRAY_LIST_FILENAME);
    } catch (IOException ex) {
      System.err.println("Error writing to: " + ex.getMessage());
    }

    // Save student emails in separate file
    try(PrintWriter out = new PrintWriter(new FileWriter(EMAIL_ONLY_LIST_FILENAME, true))) {
      out.println(email);
      // System.out.println("Saved to " + EMAIL_ONLY_LIST_FILENAME); // debugging
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

  // debugging
  public void printEmailLinkedHashSet() {
    System.out.println("\nEmail LinkedHashSet contains:");
    for (String email : STUDENT_EMAILS) {
      System.out.print(email + " ");
    }
  }
}