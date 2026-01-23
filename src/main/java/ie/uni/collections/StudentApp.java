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

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentApp {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      StudentHandler studentHandler = new StudentHandler();
      System.out.println("Student Entry App\nPlease enter the number of new students you "
          + "would like to create:");
      int numberOfStudents = scanner.nextInt();
      scanner.nextLine(); // Ensure buffer line is consumed after nextInt()
      // TODO: option to print current students
      if (numberOfStudents <= 0) {
        System.err.println("Invalid input. Please enter a number greater than 0 next time.");
      } else {
        studentHandler.loadStudentEmails();
        studentHandler.addStudents(scanner, numberOfStudents);
        studentHandler.printStudentArrayList();
        studentHandler.printEmailLinkedHashSet(); // debugging
      }
    } catch (InputMismatchException e) {
      System.err.println("This is not a valid number. Please try again next time.");
    }
  }
}