package com.mycompany.motorphpayroll;

import java.util.List;
import java.util.Scanner;

public class MotorPhPayroll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login as:\n1. Admin\n2. Employee");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice == 1) {
            adminMenu(scanner);
        } else if (choice == 2) {
            employeeMenu(scanner);
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    private static void adminMenu(Scanner scanner) {
        Admin admin = new Admin(); // Initialize Admin instance

        System.out.println("\nAdmin Panel:");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee Details");
        System.out.print("Enter choice: ");
        int adminChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (adminChoice == 1) {
            System.out.print("Enter Employee Number: ");
            String empNum = scanner.nextLine();
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();
            System.out.print("Enter SSS Number: ");
            String sss = scanner.nextLine();
            System.out.print("Enter PhilHealth Number: ");
            String philHealth = scanner.nextLine();
            System.out.print("Enter Pag-IBIG Number: ");
            String pagIbig = scanner.nextLine();
            System.out.print("Enter Hourly Rate: ");
            double hourlyRate = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            admin.addEmployee(empNum, firstName, lastName, dob, sss, philHealth, pagIbig, hourlyRate);
            System.out.println("Employee added successfully.");
        } else if (adminChoice == 2) {
            displayEmployees();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void employeeMenu(Scanner scanner) {
        System.out.print("\nEnter your Employee Number: ");
        String empNum = scanner.nextLine();
        
        double salary = PayrollCalculator.computeSalary(empNum);
        if (salary != -1) {
            System.out.println("Your computed salary: PHP " + salary);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void displayEmployees() {
        String employeeFile = "C:\\Users\\Papa\\Downloads\\Copy of MotorPH Employee Data - Employee Details.csv";
        List<Employee> employees = CSVReaderUtil.readEmployeesFromCSV(employeeFile);
        
        System.out.println("\nEmployee Details:\n");
        for (Employee emp : employees) {
            System.out.println(emp);
            System.out.println("----------------------");
        }
    }
}
