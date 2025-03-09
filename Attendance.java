package com.mycompany.motorphpayroll;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Attendance {
    private final String employeeNumber;
    private final LocalDateTime loginTime;
    private final LocalDateTime logoutTime;

    // Constructor
    public Attendance(String employeeNumber, String login, String logout) {
        this.employeeNumber = employeeNumber;
        
        // Define the date format used in the CSV file
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.loginTime = LocalDateTime.parse(login, formatter);
        this.logoutTime = LocalDateTime.parse(logout, formatter);
    }

    public long getTotalWorkedHours() {
        // Compute the total hours worked
        Duration duration = Duration.between(loginTime, logoutTime);
        return duration.toHours(); // Returns total hours worked
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public double calculateSalary(double hourlyRate) {
        return getTotalWorkedHours() * hourlyRate;
    }
}
