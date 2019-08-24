

package Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.*;

public class Main {

    

         public static void main(String[] args) throws SQLException {
       
         //initialize database connection
        Connection con = null;
        PreparedStatement stm = null;
        
        
        try {
            
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "sales", "anypw");
            
            Client client = new Client(con,stm);
                                       
        } 
        
        catch (SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        finally    {

                 if(stm!=null)
                        {
                            stm.close();
                        }

                        if(con!=null)
                        {
                               con.close();
                        }
                }
        
    
    
    }

}
