
package DaoImpl;
import java.sql.*;



public class DbConnection {
    private static Connection con;
    
       public static Connection getConnection(){
           
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aa8112003#");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         return con;
       }
        
        public static void main(String[] args) {
            System.out.println(getConnection());
    }
 
}
