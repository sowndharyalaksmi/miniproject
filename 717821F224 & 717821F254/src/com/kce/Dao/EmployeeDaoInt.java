package com.kce.Dao;
import com.kce.bean.Employee;

public interface EmployeeDaoInt {

    public void createEmployee(Employee emp);
    public void showAllEmployee();
    public void showemployeeThroughTheirID(int id);
    public void updateEmployee(int id,String name);
    public void deleteEmployee(int id);
}