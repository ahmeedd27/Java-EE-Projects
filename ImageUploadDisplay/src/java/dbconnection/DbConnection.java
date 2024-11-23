
package dbconnection;
import java.sql.*;

public class DbConnection {
    public static Connection con;
    public static Connection getConnection(){
          try{
             DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
             con=DriverManager.getConnection("jdbc:mysql://localhost:3307/imagedb?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aa8112003#");
          }   catch(SQLException e){
              System.out.println(e);
          }
          return con;
    }
}
