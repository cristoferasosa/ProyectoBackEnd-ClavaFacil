/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author SOSA
 */
public class compruebausuario {
    private String Correo;
    private String clave;
    private String Nombrecompleto;
    
    clsConexion conx = new clsConexion();
  
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    Statement state=null;
    
    public String validarusuario(){
    try{
    conn = conx.getConnection();
     String query = "SELECT * FROM tb_usuarios where correoe='"+Correo+"' and clave = MD5('"+clave+"')";
     pst=conn.prepareStatement(query);
     rs=pst.executeQuery();
    
     while(rs.next()){
         
     }
    }catch (Exception ex){
        System.out.println("Error Conection"+ex.getMessage());
    }    
        return null;
    }                             
}
