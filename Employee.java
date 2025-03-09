package com.mycompany.motorphpayroll;

public class Employee {
    private final String employeeNumber;
    private final String firstName;
    private final String lastName;
    private final String birthday;
    private final String sssNumber;
    private final String philHealthNumber;
    private final String pagIbigNumber;
    private final double hourlyRate; // New field for salary computation

    // Constructor
    public Employee(String employeeNumber, String firstName, String lastName, String birthday,
                    String sssNumber, String philHealthNumber, String pagIbigNumber, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sssNumber = sssNumber; 
        this.philHealthNumber = philHealthNumber; 
        this.pagIbigNumber = pagIbigNumber; 
        this.hourlyRate = hourlyRate; // Assign hourly rate
    }

    // Getters
    public String getEmployeeNumber() { return employeeNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getBirthday() { return birthday; }
    public String getSssNumber() { return sssNumber; }
    public String getPhilHealthNumber() { return philHealthNumber; }
    public String getPagIbigNumber() { return pagIbigNumber; }
    public double getHourlyRate() { return hourlyRate; } // New getter method

    @Override
    public String toString() {
        return "Employee No: " + employeeNumber + ", Name: " + firstName + " " + lastName + 
               ", Birthday: " + birthday + ", SSS: " + sssNumber + 
               ", PhilHealth: " + philHealthNumber + ", Pag-IBIG: " + pagIbigNumber + 
               ", Hourly Rate: " + hourlyRate;
    }
}
