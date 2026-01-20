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

import java.util.Scanner;

public class StudentApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StudentHandler studentHandler = new StudentHandler();

    System.out.println("Student Entry App\nPlease enter the number of new students you would like "
        + "to create:");
    // TODO: if else for positive number, NumberFormatException/InputMismatchException for invalid number
    int numberOfStudents = scanner.nextInt();
    scanner.nextLine(); // Ensure buffer line is consumed after nextInt()

    studentHandler.addStudents(scanner, numberOfStudents);
    studentHandler.printStudentArrayList();
    studentHandler.printEmailLinkedHashSet(); // debugging
    scanner.close();
  }
}