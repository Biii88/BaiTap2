package test2;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private List<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.addStudent(); 
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudentById(String id) {
        boolean removed = students.removeIf
        (student -> student.getId().equals(id));
        if (!removed) {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                student.displayInfo();
                System.out.println("-----------------------");
            }
        }
    }

    public Student findTopStudent() {
        Student topStudent = null;
        for (Student student : students) {
            if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }

    public void displayStudentsWithScholarship() {
        boolean found = false;
        for (Student student : students) {
            if (student.isScholarship()) {
                student.displayInfo();
                found = true;
                System.out.println("-----------------------");
            }
        }
        if (!found) {
            System.out.println("No students with scholarships.");
        }
    }

    public double calculateTotalTuition() {
        double totalTuition = 0;
        for (Student student : students) {
            totalTuition += student.calculateTuition();
        }
        return totalTuition;
    }
      public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        System.out.println("Student not found.");
        return null;
    }

}