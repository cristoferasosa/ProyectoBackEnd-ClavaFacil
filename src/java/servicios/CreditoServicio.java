/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.CreditoDao;
import Modelo.mdCreditos;
import java.util.List;

/**
 *
 * @author SOSA
 */
public class CreditoServicio {
    private CreditoDao creditodao;
    
    public CreditoServicio(){
        creditodao = new CreditoDao();
    }
    
    public List<mdCreditos> getAll(){
        return creditodao.listar();
    }
    
    public mdCreditos get(int idCredito){
        return creditodao.ListarID(idCredito);
    }
    
    public void create (mdCreditos cre){
        if (cre==null) {
            throw new NullPointerException("El credito no puede ser null");
        }
           creditodao.addcredito(cre);
    }
    
    public mdCreditos update(mdCreditos cre){
        if(cre==null){
            throw new NullPointerException("El credito no puede ser null");
        }
        return creditodao.updatecredito(cre);        
    }
    
    public mdCreditos delete(int idCliente){
        return creditodao.deletecredito(idCliente);
    }

    mdCreditos get(String nombres) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
}
