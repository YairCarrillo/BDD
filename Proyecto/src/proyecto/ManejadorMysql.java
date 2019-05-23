/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yirz
 */
public class ManejadorMysql {
    Connection connection;
    String driver="com.mysql.jdbc.Driver";
    String user;
    String pw;
    String url;
    public ManejadorMysql(String url,String pw,String user){
       this.user=user;
       this.pw=pw;
       this.url=url;
       this.Connection();
    }
    public void Connection(){
         connection=null;
        try{
            Class.forName(driver);
            connection=DriverManager.getConnection(url, user, pw);
            if(connection!=null){
                System.out.println("Coneccion establecida");
            }
        }
        catch(ClassNotFoundException | SQLException e){
            //e.printStackTrace();
            System.out.println("error al conectar:"+e);
        }
    }
    public Connection getConnection(){
        return connection;
    }
    public void CloseConnection() throws SQLException{
        connection.close();
    }
    public ResultSet QueryRead(String query) throws SQLException{
        Statement s= connection.createStatement();
        ResultSet rs=s.executeQuery(query);
        return rs;
    }
}
