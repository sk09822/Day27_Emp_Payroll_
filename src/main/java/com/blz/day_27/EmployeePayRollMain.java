package com.blz.day_27;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayRollMain {

    ArrayList<EmployeePayRoll> empList = new ArrayList<>();
    public static String myFolder = "EmpPayRoll";

    public void readEmpPayRollData() {

        EmployeePayRoll emp = new EmployeePayRoll();
        Scanner sc = new Scanner(System.in);
        System.out.print( "Enter Employee Name : ");
        String name = sc.nextLine();
        emp.setName(name);
        System.out.print( "Enter Employee Id : ");
        int id = sc.nextInt();
        emp.setId(id);
        System.out.print( "Enter Employee Salary : ");
        int salary = sc.nextInt();
        emp.setSalary(salary);
        empList.add(emp);
    }
    public void writeEmpPayRollData() {

        for(EmployeePayRoll emp : empList) {

            System.out.print( "\nEmployee Name : " + emp.getName());
            System.out.print( "\nEmployee Id : " + emp.getId());
            System.out.print( "\nEmployee Salary : " + emp.getSalary());
        }
    }
    public void writeDataIntoFile() throws IOException {

        Path filePath = Paths.get(myFolder+"\\employeeFile.txt");

        if(Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
        StringBuffer payRollBuffer = new StringBuffer();
        empList.forEach((emp) -> {
            String payRollString = emp.getName().toString().concat(", ");
            payRollString += String.valueOf(emp.getId()).toString().concat(", ");
            payRollString += String.valueOf(emp.getSalary()).toString().concat("\n");
            payRollBuffer.append(payRollString);
        });
        try {

            Files.write(filePath,payRollBuffer.toString().getBytes());

        }catch(IOException e) {
            System.out.print("Unable to write Payroll details into file" + e.getMessage());
        }
        System.out.print("\nNumber of entries in file : " + Files.lines(filePath).count());
    }
    public static void main( String[] args ) {

        EmployeePayRollMain payRoll = new EmployeePayRollMain();
        payRoll.readEmpPayRollData();
        payRoll.writeEmpPayRollData();
        try {
            payRoll.writeDataIntoFile();
        }catch(IOException e) {
            System.out.print("Unable to write Payroll details into file" + e.getMessage());
        }
        FileOperations file = new FileOperations();
        try {
            file.checkFileOperations();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}