/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BaseDatos.clsConexion;
import Modelo.mdCliente;
import Modelo.mdCreditos;
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
public class CreditoDao {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    Statement state=null;
    
    clsConexion conx = new clsConexion();
    mdCliente cli = new mdCliente();
    public List <mdCreditos> listar(){
        List <mdCreditos> datos = new ArrayList<>();        
        
        try{            
            conn = conx.getConnection();
            String query = "SELECT * FROM dbmicrocreditos.tb_creditos";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            
            while(rs.next()){
                mdCreditos cre = new mdCreditos();
                cre.setIdCredito(rs.getInt("idCredito"));
                cre.setCreditoInicial(rs.getFloat("CreditoInicial"));
                cre.setCreditoTotal(rs.getFloat("CreditoTotal"));
                cre.setFechaInicioCredito(rs.getDate("FechaInicioCredito"));
                cre.setFechaFinalCredito(rs.getDate("FechaFinalCredito"));
                cre.setInteresMensual(rs.getFloat("InteresMensual"));
                cre.setGananciaInteres(rs.getFloat("GananciaInteres"));
                cre.setEstadoCredito(rs.getString("EstadoCredito"));  
                cre.setIdCliente(rs.getInt("idCliente"));
                datos.add(cre);
            }
            
        }catch(Exception ex) {
              System.out.println("Error Conection"+ex.getMessage());
        }
        return datos;
    }   
    
    public mdCreditos ListarID(int idCredito) {        
        mdCreditos cre = new mdCreditos();
        
        try{
            conn = conx.getConnection();
            String sql ="select * from tb_Creditos where idCredito='"+idCredito+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){                
                cre.setIdCredito(rs.getInt("idCredito"));
                cre.setCreditoInicial(rs.getFloat("CreditoInicial"));
                cre.setCreditoTotal(rs.getFloat("CreditoTotal"));
                cre.setFechaInicioCredito(rs.getDate("FechaInicioCredito"));
                cre.setFechaFinalCredito(rs.getDate("FechaFinalCredito"));
                cre.setInteresMensual(rs.getFloat("InteresMensual"));
                cre.setGananciaInteres(rs.getFloat("GananciaInteres"));
                cre.setEstadoCredito(rs.getString("EstadoCredito"));
                cre.setIdCliente(rs.getInt("idCliente"));
            }
        }catch(Exception ex) {
              System.out.println("Error Modificacion Registro"+ex.getMessage());
        }
        return cre;       
    }

    public void addcredito(mdCreditos valores) {        
                
        try{
            conn = conx.getConnection();
            String query ="INSERT INTO `dbmicrocreditos`.`tb_creditos` (`CreditoInicial`,`CreditoTotal`,`FechaInicioCredito`,`FechaFinalCredito`,`InteresMensual`,`GananciaInteres`,`EstadoCredito`,`idCliente`) VALUES ('"+valores.getCreditoInicial()+"','"+valores.getCreditoTotal()+"','"+valores.getFechaInicioCredito()+"','"+valores.getFechaFinalCredito()+"','"+valores.getInteresMensual()+"','"+valores.getGananciaInteres()+"','"+valores.getEstadoCredito()+"','"+valores.getIdCliente()+"');";                                                                   
            state=conn.createStatement();
            state.execute(query);
        }catch (Exception ex) {
        }      

}
    public mdCreditos deletecredito(int idCredito){
        mdCreditos cre = new mdCreditos();
        try{
            conn = conx.getConnection();
            String query ="delete from tb_creditos where idCredito="+idCredito;
            pst=conn.prepareStatement(query);
            pst.execute(query);
            
        }catch (Exception ex) {
            
        }
        return cre;
    }
    public mdCreditos updatecredito(mdCreditos cre){ 
   
        try{           
            conn = conx.getConnection();
            String query="update tb_creditos set CreditoInicial='"+cre.getCreditoInicial()+"',CreditoTotal='"+cre.getCreditoTotal()+"',FechaInicioCredito='"+cre.getFechaInicioCredito()+"',FechaFinalCredito='"+cre.getFechaFinalCredito()+"',InteresMensual='"+cre.getInteresMensual()+"',GananciaInteres='"+cre.getGananciaInteres()+"',EstadoCredito='"+cre.getEstadoCredito()+"',idCliente='"+cre.getIdCliente()+"' where idCredito="+cre.getIdCredito()+";";
            pst=conn.prepareStatement(query);
            pst.execute(query);
        }
                
        catch(Exception ex){

        }
        return cre;
    }    
    
}
