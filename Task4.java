import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Task4 {

    static int[] ids = new int[100];
    static String[] names = new String[100];
    static double[] marks = new double[100];
    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    // Add a student
    static void addStudent() {
        if (count == ids.length) {
            System.out.println("Student storage is full.");
            return;
        }

        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findStudent(id) != -1) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter marks: ");
        double mark = sc.nextDouble();

        if (mark < 0 || mark > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        ids[count] = id;
        names[count] = name;
        marks[count] = mark;
        count++;

        System.out.println("Student added successfully!");
    }

    // Find a student by ID
    static int findStudent(int id) {
        for (int i = 0; i < count; i++) {
            if (ids[i] == id) {
                return i;
            }
        }
        return -1;
    }

    // Search for a student
    static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = sc.nextInt();

        int index = findStudent(id);

        if (index != -1) {
            System.out.println("ID: " + ids[index]);
            System.out.println("Name: " + names[index]);
            System.out.println("Marks: " + marks[index]);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Update a student's details
    static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        int index = findStudent(id);

        if (index != -1) {
            System.out.print("Enter new name: ");
            names[index] = sc.nextLine();

            System.out.print("Enter new marks: ");
            double mark = sc.nextDouble();

            if (mark < 0 || mark > 100) {
                System.out.println("Invalid marks. Update cancelled.");
                return;
            }

            marks[index] = mark;
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Invalid student ID.");
        }
    }

    // Display all student records
    static void displayStudents() {
        if (count == 0) {
            System.out.println("No student records available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.println("ID: " + ids[i]);
            System.out.println("Name: " + names[i]);
            System.out.println("Marks: " + marks[i]);
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}