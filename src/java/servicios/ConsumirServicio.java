/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.ClienteDAO;
import Modelo.mdCliente;
import java.util.List;

/**
 *
 * @author SOSA
 */
public class ConsumirServicio {
    private ClienteDAO clientedao;
    
    public ConsumirServicio(){
        clientedao = new ClienteDAO();
    }
    
    public List<mdCliente> getAll(){
        return clientedao.listar();
    }
    
    public mdCliente get(int idCliente){
        return clientedao.ListarID(idCliente);
    }
    
    public void create (mdCliente cli){
        if (cli==null) {
            throw new NullPointerException("El Usuario no Puede ser NUll");
        }
           clientedao.addcliente(cli);
    }
    
    public mdCliente update(mdCliente cli){
        if(cli==null){
            throw new NullPointerException("El Usuario no Puede ser NUll");
        }
        return clientedao.updatecliente(cli);        
    }
    
    public mdCliente delete(int idCliente){
        return clientedao.deleteclient(idCliente);
    }

    mdCliente get(String nombres) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
