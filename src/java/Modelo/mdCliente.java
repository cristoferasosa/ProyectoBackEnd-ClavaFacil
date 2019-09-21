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
public class mdCliente {
    private int idCliente;
    private String Nombres;
    private String Apellidos;
    private String Edad;
    private String Dpi;
    private String Direccion;
    private String Telefono;
    private String Correo;
    
    public mdCliente(){
        
    }
    
    public mdCliente(int idCliente, String Nombres, String Apellidos, String Edad, String Dpi, String Direccion, String Telefono,  String Correo){
        this.idCliente=idCliente;
        this.Nombres=Nombres;
        this.Apellidos=Apellidos;       
        this.Edad=Edad;
        this.Dpi=Dpi;
        this.Direccion=Direccion;        
        this.Telefono=Telefono;        
        this.Correo=Correo;
    }
    

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the Nombres
     */
    public String getNombres() {
        return Nombres;
    }

    /**
     * @param Nombres the Nombres to set
     */
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    /**
     * @return the Apellidos
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * @return the Edad
     */
    public String getEdad() {
        return Edad;
    }

    /**
     * @param Edad the Edad to set
     */
    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    /**
     * @return the Dpi
     */
    public String getDpi() {
        return Dpi;
    }

    /**
     * @param Dpi the Dpi to set
     */
    public void setDpi(String Dpi) {
        this.Dpi = Dpi;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
}
