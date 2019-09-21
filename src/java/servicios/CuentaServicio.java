/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.CuentaDao;
import Modelo.mdCuenta;
import java.util.List;

/**
 *
 * @author SOSA
 */
public class CuentaServicio {
    private CuentaDao cuentadao;
    
    public CuentaServicio(){
        cuentadao = new CuentaDao();
    }
    
    public List<mdCuenta> getAll(){
        return cuentadao.listar();
    }
    
    public mdCuenta get(int idCuenta){
        return cuentadao.ListarID(idCuenta);
    }
    
    public void create (mdCuenta cue){
        if (cue==null) {
            throw new NullPointerException("La cuenta no puede ser NULL");
        }
           cuentadao.addcuenta(cue);
    }
    
    public mdCuenta update(mdCuenta cue){
        if(cue==null){
            throw new NullPointerException("La cuenta no puede ser null");
        }
        return cuentadao.updatecuenta(cue);        
    }
    
    public mdCuenta delete(int idCuenta){
        return cuentadao.deletecuenta(idCuenta);
    }
}
