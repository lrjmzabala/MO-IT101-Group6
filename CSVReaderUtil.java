package com.mycompany.motorphpayroll;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtil {

    public static List<Employee> readEmployeesFromCSV(String filePath) {
        List<Employee> employees = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            records.remove(0); // Remove header row
            
            for (String[] record : records) {
                if (record.length >= 8) { // Ensure the record has enough columns
                    String employeeNumber = record[0];
                    String firstName = record[1];
                    String lastName = record[2];
                    String birthday = record[3];
                    String sssNumber = record[4];
                    String philHealthNumber = record[5];
                    String pagIbigNumber = record[6];
                    double hourlyRate = Double.parseDouble(record[7]); // Added hourly rate

                    employees.add(new Employee(employeeNumber, firstName, lastName, birthday, 
                                               sssNumber, philHealthNumber, pagIbigNumber, hourlyRate));
                } else {
                    System.out.println("Skipping invalid row: " + String.join(",", record));
                }
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }

        return employees;
    }

    public static List<Attendance> readAttendanceFromCSV(String filePath) {
        List<Attendance> attendanceList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            records.remove(0); // Remove header row

            for (String[] record : records) {
                if (record.length >= 3) { // Ensure there are enough columns
                    String employeeNumber = record[0];
                    String loginTime = record[1];
                    String logoutTime = record[2];

                    attendanceList.add(new Attendance(employeeNumber, loginTime, logoutTime));
                } else {
                    System.out.println("Skipping invalid row: " + String.join(",", record));
                }
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }

        return attendanceList;
    }

    // Compute salary based on attendance and hourly rate
    public static void computeSalaries(List<Employee> employees, List<Attendance> attendanceList) {
        for (Employee emp : employees) {
            double totalHoursWorked = 0.0;

            for (Attendance att : attendanceList) {
                if (att.getEmployeeNumber().equals(emp.getEmployeeNumber())) {
                    totalHoursWorked += att.getTotalWorkedHours();
                }
            }

            double grossSalary = totalHoursWorked * emp.getHourlyRate();
            System.out.println("Employee: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("Total Hours Worked: " + totalHoursWorked);
            System.out.println("Gross Salary: PHP " + grossSalary);
            System.out.println("----------------------");
        }
    }
}  // <<<<<<<< Make sure this closing brace is present!
