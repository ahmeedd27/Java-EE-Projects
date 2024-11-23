
package db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.FileInformation;


public class DbQueries {
    Connection con=DbConnection.getConnection();
    FileInformation f;
    PreparedStatement pst;
    public boolean saveFile(int id , String name , String filename , String filepath) throws SQLException{
       boolean set=false;
        String sql="insert into employee(id , ename , filename , filepath) values(? , ? , ? , ?)";
        pst=con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setString(3, filename);
        pst.setString(4, filepath);
        set=pst.executeUpdate()>0;
        if(set){
             return set;
        }
        else{
            return false;
        }
    }
    public List<FileInformation> getAll() throws SQLException{
        List<FileInformation> l=new ArrayList<>();
        String sql="select * from employee";
        pst=con.prepareStatement(sql);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            f=new FileInformation(rs.getInt("id"),rs.getString("ename") , rs.getString("filename") ,rs.getString("filepath"));
            l.add(f);
        }
        return l;
    }
    
}
