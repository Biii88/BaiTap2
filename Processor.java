package test2;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Processor {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        while (true) {
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by ID");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Display students with scholarships");
            System.out.println("7. Display total tuition of all students");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int option = -1;
            while (option == -1) {
                try {
                    option = scanner.nextInt();
                    scanner.nextLine();  
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); 
                }
            }

            switch (option) {
                case 1:
                    Student newStudent = new Student(0, "", 10000000, false, "", "", null);
                    newStudent.addStudent();
                    studentList.addStudent(newStudent);
                    break;

                case 2:
                    System.out.print("Enter ID of the student to update: ");
                    String updateId = scanner.nextLine();
                    studentList.updateStudentById(updateId);
                    break;

                case 3:
                    System.out.print("Enter ID of student to remove: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    break;

                case 4:
                    studentList.displayAllStudents();
                    break;

                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Student with the highest GPA:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students available.");
                    }
                    break;

                case 6:
                    studentList.displayStudentsWithScholarship();
                    break;

                case 7:
                    double totalTuition = studentList.calculateTotalTuition();
                    System.out.println("Total tuition of all students: " + totalTuition);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}