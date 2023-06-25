package com.kce.bean;
public class Employee {
    private int EmployeeId;
    private String EmployeeName;
    private int salary;
    private int Experience;
    

    public Employee(){

    }
    public Employee(int EmployeeId, String EmployeeName, int salary,int Experience) {
        this.EmployeeId = EmployeeId;
        this.EmployeeName = EmployeeName;
        this.salary = salary;
        this.Experience = Experience;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int Experience) {
        this.Experience = Experience;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Employeeid=" + EmployeeId +
                ", Employeename='" + EmployeeName + '\'' +
                ", salary=" + salary +
                ", Experience=" + Experience +
                '}';
    }

}