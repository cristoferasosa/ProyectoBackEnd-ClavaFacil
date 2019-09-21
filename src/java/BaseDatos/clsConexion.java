/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author SOSA
 */
public class clsConexion {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
                
    public clsConexion(){
        try{   
            Class.forName("com.mysql.jdbc.Driver");
            conn =DriverManager.getConnection("jdbc:mysql://localhost/dbmicrocreditos","root","");               
        
            //System.out.println("Conexion Exitosa");
    }catch (Exception ex) {
            System.out.println("Error Conection"+ex.getMessage());
    }              
    }
    public Connection getConnection(){
        return conn;
    }
}
