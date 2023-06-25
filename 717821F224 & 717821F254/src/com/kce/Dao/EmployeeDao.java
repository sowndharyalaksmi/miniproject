package com.kce.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.kce.bean.Employee;
import com.kce.util.DBConnection;

public class EmployeeDao implements EmployeeDaoInt{
    static Connection con=null;

    public static void createTable() {
//    	con=DBConnection.createDBConnetion();
//    	try {
//    	 Statement statement=con.createStatement();
//        statement.execute("drop table employee");
//        String createTableQuery = "CREATE TABLE employee (EmployeeId INT, EmployeeName VARCHAR(255), salary INT,Experience INT)";
//        statement.executeUpdate(createTableQuery);
//           System.out.println("Table created successfully.");
//             
//        } catch (Exception e) {
//            System.err.println("Error creating table: " + e.getMessage());
//        }
    }
    public void createEmployee(Employee user) {
       con =DBConnection.createDBConnetion();
      String query="insert into employee values(?,?,?,?)";
       try{
           PreparedStatement pstm=con.prepareStatement(query);
           pstm.setInt(1,user.getEmployeeId());
           pstm.setString(2,user.getEmployeeName());
           pstm.setInt(3,user.getSalary());
           pstm.setInt(4,user.getExperience());
          int cnt= pstm.executeUpdate();
          if(cnt>0)
              System.out.println("Customer Data Inserted Successfully !!!");


       }catch (Exception e){
           System.out.println(e);
       }

    }

    @Override
    public void showAllEmployee() {
        con=DBConnection.createDBConnetion();
        String query="select * from employee";
        System.out.println("Employee Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n","EmployeeID","EmployeeName","Salary","Experience");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t\t%s\t\t%d\t %d Years\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4));
                       
                System.out.println("---------------------------------------------");

            }
            

        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void showemployeeThroughTheirID(int EmployeeId) {
        con=DBConnection.createDBConnetion();
        String query="select * from employee where id="+EmployeeId;
        try{
            Statement stmt=con.createStatement();
           ResultSet result= stmt.executeQuery(query);
           while (result.next()){
               System.out.format("%d\t%s\t%f\t%d\n",
                       result.getInt(1),
                       result.getString(2),
                       result.getInt(3),
                       result.getInt(4));

           }

        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void updateEmployee(int EmployeeId, String EmployeeName) {
        con=DBConnection.createDBConnetion();
        String query="update customer set EmployeeName=? where EmployeeId=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,EmployeeName);
            pstm.setInt(2,EmployeeId);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Customer Details updated successfully !!");

        }catch (Exception e){
           e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int EmployeeId) {
        con=DBConnection.createDBConnetion();
        String query="delete from Customer where Employeeid=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,EmployeeId);
           int cnt= pstm.executeUpdate();
           if(cnt!=0)
               System.out.println("Customer Data Deleted Successfully!!! "+EmployeeId);

        }catch (Exception e){
            System.out.println(e);
        }
    }


}