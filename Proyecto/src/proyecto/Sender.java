/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Yirz
 */
public class Sender {
    Connection conection1;
    Connection connection2;
    public Sender(){
    }
    public void setConnection1(Connection connection){
        this.conection1=connection;
    }
    public void setConnection2(Connection connection){
        this.connection2=connection;
    }
    public Connection getConnection1(){
        return this.conection1;
    }
    public Connection getConnection2(){
        return this.connection2;
    }
    public void SendQueryHorizontal(String table,ResultSet resultset, Connection from, Connection to) throws SQLException{
        ResultSetMetaData meta = resultset.getMetaData();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= meta.getColumnCount(); i++)
            columns.add(meta.getColumnName(i));
        PreparedStatement s2 = to.prepareStatement(
                "INSERT IGNORE INTO " + table + " ("
              + columns.stream().collect(Collectors.joining(", "))
              + ") VALUES ("
              + columns.stream().map(c -> "?").collect(Collectors.joining(", "))
              + ")");
        while (resultset.next()) {
            for (int i = 1; i <= meta.getColumnCount(); i++)
                s2.setObject(i, resultset.getObject(i));
            s2.addBatch();
        }
       s2.executeBatch();
    }
    public void SendQueryVertical(String table,ResultSet resultset, Connection from, Connection to) throws SQLException{
        ResultSetMetaData meta = resultset.getMetaData();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= meta.getColumnCount(); i++)
            columns.add(meta.getColumnName(i));
        
            
        
        PreparedStatement s1 = to.prepareStatement(
                "INSERT IGNORE INTO " + table + " ("
              + columns.stream().collect(Collectors.joining(", "))
              + ") VALUES ("
              + columns.stream().map(c -> "?").collect(Collectors.joining(", "))
              + ")");
        PreparedStatement s2 = to.prepareStatement(
                "UPDATE IGNORE " + table + " SET "
              + columns.stream().map(c->c+"=?").collect(Collectors.joining(", "))
              + " WHERE "
              + columns.get(0)+"=?"
              );
        while (resultset.next()) {
            for (int i = 1; i <= meta.getColumnCount(); i++){
                s2.setObject(i, resultset.getObject(i));
                s1.setObject(i, resultset.getObject(i));
            }   
            s2.setObject(meta.getColumnCount()+1,resultset.getObject(1));
            s2.addBatch();
            s1.addBatch();
              
        }
       s1.executeBatch();
       s2.executeBatch();
    }
    /*
        ejemplo de como mandar a sitios remotos
    */
    public static void main(String args[]){
        try {
            ManejadorMysql local=new ManejadorMysql("jdbc:mysql://127.0.0.1:3306/galardon_galardonados","root","root");
            ManejadorMysql remote=new ManejadorMysql("jdbc:mysql://192.168.1.70:3306/galardon_fragmento","","yirz");
            Sender sender=new Sender();
            sender.SendQueryVertical("galardon",local.QueryRead("Select id from galardon"),local.getConnection(),remote.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
