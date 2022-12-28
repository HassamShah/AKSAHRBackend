package com.example.aksahrbackend.connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnetion {


   public static Connection getConnection()
    {
         String url = "jdbc:oracle:thin:@//172.16.1.153:1521/system";
         String  username ="interview";
         String password= "aksa@4321";
        Connection connection = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established!");
            return connection;

        }catch (Exception e){
            System.out.println(e.toString());
        }
    return connection;
    }

}
