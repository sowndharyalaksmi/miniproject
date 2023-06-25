package com.kce.service;
import java.io.*;
import com.kce.Dao.EmployeeDao;
import com.kce.Dao.EmployeeDaoInt;


import com.kce.bean.Employee;
public class Main {
    public static void main(String[] args) throws Exception{
        String EmployeeName;
        int EmployeeId;
        EmployeeDaoInt dao=new EmployeeDao();
        System.out.println("Welcome to Employee Management System!!!");
        EmployeeDao.createTable();
        try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))) {
            do{
            	
                System.out.println("1. Add Employee\n" +"2. Show All Employee details\n" +"3. Show Employee through Their ID \n" +"4. Update the Employee Details\n" +"5. Delete the Employee\n");

                System.out.println("Enter Choice: ");
                int ch=Integer.parseInt(br.readLine());
                switch (ch){
                    case 1:
                        Employee user=new Employee();
                        System.out.println("Enter EmployeeID : ");
                        EmployeeId=Integer.parseInt(br.readLine());
                        System.out.println("Enter EmployeeName ");
                         EmployeeName=br.readLine();
                        System.out.println("Enter salary");
                        int salary=Integer.parseInt(br.readLine());
                        System.out.println("Enter Experience");
                        int Experience=Integer.parseInt(br.readLine());
                        user.setEmployeeId(EmployeeId);
                        user.setEmployeeName(EmployeeName);
                        user.setSalary(salary);
                        user.setExperience(Experience);
                        dao.createEmployee(user);
                        break;
                    case 2:
                        dao.showAllEmployee();
                        break;
                    case 3:
                        System.out.println("Enter Employee id to show the details ");
                        int empid=Integer.parseInt(br.readLine());
                        dao.showemployeeThroughTheirID(empid);
                        break;
                    case 4:
                        System.out.println("Enter id to update the details");
                        int empid1=Integer.parseInt(br.readLine());
                        System.out.println("Enter the new name");
                         EmployeeName=br.readLine();
                        dao.updateEmployee(empid1,EmployeeName);
                        break;
                    case 5:
                        System.out.println("Enter the id to delete");
                        EmployeeId=Integer.parseInt(br.readLine());
                        dao.deleteEmployee(EmployeeId);
                        break;

                    case 6:
                        System.out.println("Thank you so much for know your details!!!");
                        System.exit(0);
                    default:
                        System.out.println("Enter valid choice !");
                        break;


                }

            }while (true);
        }
         catch (Exception e) {
            System.out.println(e);
        }

    }
}