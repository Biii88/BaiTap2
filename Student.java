package test2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person {
    private float gpa;
    private String major;
    private double tuition = 10000000; 
    private boolean scholarship;

    public Student(float gpa, String major, double tuition, boolean scholarship, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
        this.tuition = tuition;
        this.scholarship = scholarship;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuition() {
        return tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getFullName());
        System.out.println("Date of Birth: " + sdf.format(getDateOfBirth()));
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
        System.out.println("Tuition: " + calculateTuition());
        System.out.println("Scholarship: " + (scholarship ? "Yes" : "No"));
    }

    public double calculateTuition() {
        if (gpa >= 9) {
            scholarship = true;
            return tuition * 0.5; 
        } else {
            scholarship = false;
            return tuition;
        }
    }

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        setId(sc.nextLine());
        System.out.print("Enter Name: ");
        setFullName(sc.nextLine());
        System.out.print("Enter Major: ");
        setMajor(sc.nextLine());
        System.out.print("Enter GPA: ");
        setGpa(Float.parseFloat(sc.nextLine()));
        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
        try {
            setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Wrong Format!");
        }
    }
}