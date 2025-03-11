package com.mycompany.motorphpayroll;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Admin class responsible for managing employee records.
 */
public class Admin {
    private static final String EMPLOYEE_CSV = "C:\\Users\\Papa\\Downloads\\Copy of MotorPH Employee Data - Employee Details.csv";

    public Admin() {
        System.out.println("Admin panel initialized.");
    }

    /**
     * Adds an employee record to the CSV file.
     *
     * @param employeeNumber Employee ID
     * @param firstName First name
     * @param lastName Last name
     * @param birthday Birthdate
     * @param sssNumber SSS Number
     * @param philHealthNumber PhilHealth Number
     * @param pagIbigNumber Pag-IBIG Number
     * @param hourlyRate Hourly wage
     */
    public void addEmployee(String employeeNumber, String firstName, String lastName, String birthday, 
                            String sssNumber, String philHealthNumber, String pagIbigNumber, double hourlyRate) {
        try (FileWriter writer = new FileWriter(EMPLOYEE_CSV, true)) {
            String newEmployee = String.join(",", employeeNumber, firstName, lastName, birthday, 
                                              sssNumber, philHealthNumber, pagIbigNumber, String.valueOf(hourlyRate));
            writer.append(newEmployee).append("\n");
            System.out.println("✅ Employee added successfully: " + firstName + " " + lastName);
        } catch (IOException e) {
            System.err.println("❌ Error writing to employee file: " + e.getMessage());
        }
    }
}
