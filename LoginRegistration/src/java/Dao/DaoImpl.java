package Dao;

import connection.DbConnection;
import java.sql.*;
import model.Employee;


public class DaoImpl {
    //insert user data
     public int registerEmployee(Employee e) throws SQLException{
       Connection conn=DbConnection.getConnection();
       int result=0;
       String sql="insert into employee (ename , eemail , epassword , econtact)" +
           "values(? , ? , ? , ?);";
       PreparedStatement st=conn.prepareStatement(sql);
       
       st.setString(1, e.getName());
        st.setString(2, e.getEmail());
         st.setString(3, e.getPassword());
          st.setString(4, e.getContact());
          
          result=st.executeUpdate();
           conn.commit();  
           conn.close();
          return result;
   }
    boolean set=false;
    // take the user data to check
    public Employee log(String email , String pass) throws SQLException{
        Connection conn=DbConnection.getConnection();
       Employee e=new Employee();
        String sql="select * from employee " +
               "where eemail=? and epassword=? ";
        PreparedStatement pst=conn.prepareStatement(sql);
        pst.setString(1, email);
        pst.setString(2, pass);
        ResultSet rs=pst.executeQuery();
        if(rs.next()){
             e.setName(rs.getString("ename"));
            e.setContact(rs.getString("econtact"));
           return  e;
        }
        else{
            return null;
        }
      
    }
    
    
    
   

    
     

}
