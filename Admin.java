package com.mycompany.motorphpayroll;

import java.io.FileWriter;
import java.io.IOException;

public class Admin {
    private static final String EMPLOYEE_CSV = "C:\\Users\\Papa\\Downloads\\MotorPH_Employee_Details.csv";

    // Constructor
    public Admin() {
        System.out.println("Admin panel initialized.");
    }

    // Method to add an employee and save to CSV
    public void addEmployee(String employeeNumber, String firstName, String lastName, String birthday, 
                            String sssNumber, String philHealthNumber, String pagIbigNumber, double hourlyRate) {
        try (FileWriter writer = new FileWriter(EMPLOYEE_CSV, true)) {
            String newEmployee = String.join(",", employeeNumber, firstName, lastName, birthday, 
                                              sssNumber, philHealthNumber, pagIbigNumber, String.valueOf(hourlyRate));
            writer.append(newEmployee).append("\n");
            System.out.println("Employee added successfully: " + firstName + " " + lastName);
        } catch (IOException e) {
            System.out.println("Error writing to employee file: " + e.getMessage());
        }
    }
}
