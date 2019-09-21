/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SOSA
 */
public class mdCuenta {
    private int idCuenta;
    private String Nombre;
    private float Cantidad;
    
    public mdCuenta(){
    
    }    
    
    public mdCuenta(int idCuenta, String Nombre, float Cantidad){
        this.idCuenta = idCuenta;
        this.Nombre = Nombre;
        this.Cantidad = Cantidad;
    }
    /**
     * @return the idCuenta
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * @param idCuenta the idCuenta to set
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Cantidad
     */
    public float getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(float Cantidad) {
        this.Cantidad = Cantidad;
    }
}
