
package DAO;


import Application.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author 1895212
 */
public class Client{
    
public Client(Connection cn, PreparedStatement ps) throws SQLException{
      
        insertClient(cn);
        //deleteClient(cn);
        //updateClient(cn);
        //listClient(cn);
        //singleClient(cn);
       
         
}

    private void singleClient(Connection cn) throws SQLException {
        PreparedStatement ps;
     
        String sql;
        sql = "select * from client where noclient='90' ";
        ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String client_name, client_phone;
            int client_no;
            
            client_name = rs.getString("nameclient");
            client_phone = rs.getString("notelephone");
            client_no = rs.getInt("noclient");
            
            System.out.println(client_no + ": " + client_name + " - " + client_phone);
        }
    }

    private void listClient(Connection cn) throws SQLException {
        PreparedStatement ps;
        
        String sql;
        sql = "select * from client";
        ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String client_name, client_phone;
            int client_no;
            
            client_name = rs.getString("nameclient");
            client_phone = rs.getString("notelephone");
            client_no = rs.getInt("noclient");
            
            System.out.println(client_no + ": " + client_name + " - " + client_phone);
        }
    }

    private void updateClient(Connection cn) throws SQLException {
        PreparedStatement ps;
        String sql;
        sql = "update client set nameclient=? where noclient=?";
        ps = cn.prepareStatement(sql);
        ps.setString(1, "Sai A");
        ps.setInt(2,900);
        int rs = ps.executeUpdate();
        System.out.println(rs);
    }

    private void deleteClient(Connection cn) throws SQLException {
        PreparedStatement ps;
        String sql;
        sql = "DELETE FROM client WHERE noclient =? ";
        ps = cn.prepareStatement(sql);
        ps.setInt(1,900);
        int rs = ps.executeUpdate();
        System.out.println(rs);
    }

    private void insertClient(Connection cn) throws SQLException {
        String sql;
        PreparedStatement ps;
        sql = "insert into client values(?,?,?)";
        ps = cn.prepareStatement(sql);
        ps.setInt(1,101);
        ps.setString(2,"Sukhman");
        ps.setString(3, "(498)874-5221");
        int rs = ps.executeUpdate();
        System.out.println(rs);
    }

   
    
}
