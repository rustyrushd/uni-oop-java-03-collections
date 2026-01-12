/*
 * A Java app that creates and stores (in memory) student information: name, email and course.
 * The app takes looped user input to instantiate objects with class attributes and then stores
 * these student objects in an ArrayList.
 * Before instantiation, it is ensured that the first letter of name and course is capitalized.
 * Also a check for duplicated email is made and if true, reprompts the user for a unique email.
 * The ArrayList is printed back to the user using a for-each loop and toString().
 *
 * Author: rgm
 *
 * [1.2.1] - 2025-10-21
 */


package ie.uni.collections;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();
    LinkedHashSet<String> studentEmails = new LinkedHashSet<>();

    Scanner scan1 = new Scanner(System.in);
    System.out.println("Please enter the number of students: ");
    int count = scan1.nextInt();
    scan1.nextLine();

    // prompt user for count number of students and attribute input
    for (int i = 0; i < count; i++) {
      System.out.println("Please enter Student name: ");
      String name = firstCap(scan1.nextLine().toLowerCase().trim());

      System.out.println("Please enter Student email: ");
      String email = scan1.nextLine().toLowerCase().trim();

      // check if email already exists and keep prompting until a unique email is entered
      while (studentEmails.contains(email)) {
        System.out.println("That email is already in the system. Please enter another email:");
        email = scan1.nextLine().toLowerCase().trim();
      }

      System.out.println("Please enter Course: ");
      String course = firstCap(scan1.nextLine().toLowerCase().trim());
      Student student1 = new Student(name, email, course);

      studentList.add(student1);
      studentEmails.add(email);
    }

    scan1.close();

    System.out.println("\nStudent Arraylist contains:");
    for (Student student : studentList) {
      System.out.println(student);
    }

    System.out.println("\nEmail LinkedHashSet contains:");
    for (String email : studentEmails) {
      System.out.print(email + " ");
    }
  }

  // capitalizes the first letter in a String
  static String firstCap(String text) {
    char fLetter = Character.toUpperCase(text.charAt(0));
    String rest = text.substring(1);
    return fLetter + rest;
  }
}