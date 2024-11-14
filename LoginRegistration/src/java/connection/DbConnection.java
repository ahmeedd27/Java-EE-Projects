
package connection;

import java.sql.*;
// connection with database
public class DbConnection {
     static Connection con;
      
       public static Connection getConnection() {
         try{
             DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
              con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ahmedjdbc?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aa8112003#");
         }catch(SQLException ex){
             System.out.println(ex);
         }
          
           return con;
       }
}
