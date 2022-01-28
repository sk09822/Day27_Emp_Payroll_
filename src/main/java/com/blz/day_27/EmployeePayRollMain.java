package com.blz.day_27;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayRollMain {

    ArrayList<EmployeePayRoll> empList = new ArrayList<>();

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
    public static void main( String[] args ) {

//    	EmployeePayRollMain payRoll = new EmployeePayRollMain();
//    	payRoll.readEmpPayRollData();
//    	payRoll.writeEmpPayRollData();

        FileOperations file = new FileOperations();
        try {
            file.checkFileOperations();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}