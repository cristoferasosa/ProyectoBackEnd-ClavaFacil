/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BaseDatos.clsConexion;
import Modelo.mdCliente;
import Modelo.mdCreditos;
import Modelo.mdCuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SOSA
 */
public class CuentaDao {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    Statement state=null;
    
    clsConexion conx = new clsConexion();
    
    public List <mdCuenta> listar(){
        List <mdCuenta> datos = new ArrayList<>();        
        
        try{            
            conn = conx.getConnection();
            String query = "SELECT * FROM dbmicrocreditos.tb_cuentacorriente";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            
            while(rs.next()){
                mdCuenta cue = new mdCuenta();
                cue.setIdCuenta(rs.getInt("idCuenta"));
                cue.setNombre(rs.getString("Nombre"));
                cue.setCantidad(rs.getFloat("Cantidad"));                
                datos.add(cue);
            }
            
        }catch(Exception ex) {
              System.out.println("Error Conection"+ex.getMessage());
        }
        return datos;
    }   
    
    public mdCuenta ListarID(int idCuenta) {        
        mdCuenta cue = new mdCuenta();
        
        try{
            conn = conx.getConnection();
            String sql ="SELECT * FROM dbmicrocreditos.tb_cuentacorriente where idCuenta='"+idCuenta+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){                
                cue.setIdCuenta(rs.getInt("idCuenta"));
                cue.setNombre(rs.getString("Nombre"));
                cue.setCantidad(rs.getFloat("Cantidad"));  
            }
        }catch(Exception ex) {
              System.out.println("Error Modificacion Registro"+ex.getMessage());
        }
        return cue;       
    }

    public void addcuenta(mdCuenta valores) {        
                
        try{
            conn = conx.getConnection();
            String query ="INSERT INTO `dbmicrocreditos`.`tb_cuentacorriente` (`Nombre`,`Cantidad`) VALUES ('"+valores.getNombre()+"','"+valores.getCantidad()+"');";                                                                   
            state=conn.createStatement();
            state.execute(query);
        }catch (Exception ex) {
        }      

}
    public mdCuenta deletecuenta(int idCuenta){
        mdCuenta cue = new mdCuenta();
        try{
            conn = conx.getConnection();
            String query ="delete from tb_cuentacorriente where idCuenta="+idCuenta;
            pst=conn.prepareStatement(query);
            pst.execute(query);
            
        }catch (Exception ex) {
            
        }
        return cue;
    }
    public mdCuenta updatecuenta(mdCuenta cue){ 
   
        try{           
            conn = conx.getConnection();
            String query="update tb_cuentacorriente set Nombre='"+cue.getNombre()+"',Cantidad='"+cue.getCantidad()+"' where idCuenta="+cue.getIdCuenta()+";";
            pst=conn.prepareStatement(query);
            pst.execute(query);
        }
                
        catch(Exception ex){

        }
        return cue;
    }    
    
}
