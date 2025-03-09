package com.mycompany.motorphpayroll;

import java.util.List;

public class PayrollCalculator {
    private static final double HOURLY_RATE = 100.0; // Set your hourly rate here
    private static final double SSS_DEDUCTION = 0.045; // 4.5% of gross salary
    private static final double PHILHEALTH_DEDUCTION = 0.03; // 3% of gross salary
    private static final double PAGIBIG_DEDUCTION = 0.02; // 2% of gross salary

    public static double computeSalary(String employeeNumber) {
        String attendanceFile = "C:\\Users\\Papa\\Downloads\\Copy of MotorPH Employee DataHoursWorked - Employee Details.csv";
        List<Attendance> attendanceList = CSVReaderUtil.readAttendanceFromCSV(attendanceFile);

        double totalHoursWorked = 0;

        // Find total worked hours for the given employee
        for (Attendance att : attendanceList) {
            if (att.getEmployeeNumber().equals(employeeNumber)) {
                totalHoursWorked += att.getTotalWorkedHours();
            }
        }

        if (totalHoursWorked == 0) {
            return -1; // Employee not found
        }

        // Compute gross salary
        double grossSalary = totalHoursWorked * HOURLY_RATE;

        // Compute deductions
        double sss = grossSalary * SSS_DEDUCTION;
        double philHealth = grossSalary * PHILHEALTH_DEDUCTION;
        double pagIbig = grossSalary * PAGIBIG_DEDUCTION;
        double totalDeductions = sss + philHealth + pagIbig;

        // Compute net salary
        double netSalary = grossSalary - totalDeductions;

        return netSalary;
    }
}
