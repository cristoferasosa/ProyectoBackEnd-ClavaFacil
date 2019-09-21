/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BaseDatos.clsConexion;
import Modelo.mdCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SOSA-*
 */
public class ClienteDAO {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    Statement state=null;
    
    clsConexion conx = new clsConexion();
       
    public List <mdCliente> listar(){
        List <mdCliente> datos = new ArrayList<>();        
        
        try{            
            conn = conx.getConnection();
            String query = "SELECT * FROM dbmicrocreditos.tb_clientes";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            
            while(rs.next()){
                mdCliente cli = new mdCliente();
                cli.setIdCliente(rs.getInt("idCliente"));
                cli.setNombres(rs.getString("Nombres"));
                cli.setApellidos(rs.getString("Apellidos"));
                cli.setEdad(rs.getString("Edad"));
                cli.setDpi(rs.getString("Dpi"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setTelefono(rs.getString("Telefono"));               
                cli.setCorreo(rs.getString("Correo"));
                datos.add(cli);
            }
            
        }catch(Exception ex) {
              System.out.println("Error Conection"+ex.getMessage());
        }
        return datos;
    }   
    
    public mdCliente ListarID(int idCliente) {        
        mdCliente cli = new mdCliente();
        
        try{
            conn = conx.getConnection();
            String sql ="select * from tb_clientes where idCliente='"+idCliente+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){                
                cli.setIdCliente(rs.getInt("idCliente"));
                cli.setNombres(rs.getString("Nombres"));
                cli.setApellidos(rs.getString("Apellidos"));
                cli.setEdad(rs.getString("Edad"));
                cli.setDpi(rs.getString("Dpi"));
                cli.setDireccion(rs.getString("Direccion"));                
                cli.setTelefono(rs.getString("Telefono"));                
                cli.setCorreo(rs.getString("Correo"));   
            }
        }catch(Exception ex) {
              System.out.println("Error Modificacion Registro"+ex.getMessage());
        }
        return cli;       
    }

    public void addcliente(mdCliente valores) {        
                
        try{
            conn = conx.getConnection();
            String query ="INSERT INTO `dbmicrocreditos`.`tb_clientes` (`Nombres`,`Apellidos`,`Edad`,`Dpi`,`Direccion`,`Telefono`,`Correo`) VALUES ('"+valores.getNombres()+"','"+valores.getApellidos()+"','"+valores.getEdad()+"','"+valores.getDpi()+"','"+valores.getDireccion()+"','"+valores.getTelefono()+"','"+valores.getCorreo()+"');";                                                                   
            state=conn.createStatement();
            state.execute(query);
        }catch (Exception ex) {
        }      

}
    public mdCliente deleteclient(int idCliente){
        mdCliente cli = new mdCliente();
        try{
            conn = conx.getConnection();
            String query ="delete from tb_clientes where idCliente="+idCliente;
            pst=conn.prepareStatement(query);
            pst.execute(query);
            
        }catch (Exception ex) {
            
        }
        return cli;
    }
    public mdCliente updatecliente(mdCliente cli){ 
   
        try{           
            conn = conx.getConnection();
            String query="update tb_clientes set Nombres='"+cli.getNombres()+"',Apellidos='"+cli.getApellidos()+"',Edad='"+cli.getEdad()+"',Dpi='"+cli.getDpi()+"',Direccion='"+cli.getDireccion()+"',Telefono='"+cli.getTelefono()+ "',Correo='"+cli.getCorreo()+"' where idCliente="+cli.getIdCliente()+";";
            pst=conn.prepareStatement(query);
            pst.execute(query);
        }
                
        catch(Exception ex){

        }
        return cli;
    }    

}
