package DaoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import model.User;

public class DaoMethods {

    PreparedStatement pst;

    public boolean addUser(User u) {
        boolean set = false;
        String sql = "insert into user(id , name, email , country ) values(? , ? ,?, ?)";
        try {
            Connection con = DbConnection.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, u.getId());
            pst.setString(2, u.getName());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getCountry());
            set = pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;
    }

    public List<User> readUsers() {
        String sql = "select * from user";
        
        List<User> l=new ArrayList<>();
        Connection con = DbConnection.getConnection();

        try {
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               int id= rs.getInt("id") ;
                String name=rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
               User e=new User(id , name , email, country);
               l.add(e);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     return l;
    }
    
    
    public boolean updateUser(User u){
        boolean set=false;
        
        Connection con=DbConnection.getConnection();
        String sql="update user set name = ?,email= ?, country =? where id = ?";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, u.getName());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getCountry());
            pst.setInt(4, u.getId());
            set=pst.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;
    }
    
    public boolean deleteUser(int id){
        boolean set=false;
        Connection con=DbConnection.getConnection();
        String sql="delete from user where id=? ";
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            set=pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return set;
    }
}
