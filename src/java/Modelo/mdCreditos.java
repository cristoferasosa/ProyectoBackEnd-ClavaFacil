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
public class mdCreditos {
        
    private int idCredito;
    private float CreditoInicial;
    private float CreditoTotal;
    private java.sql.Date FechaInicioCredito;
    private java.sql.Date FechaFinalCredito;
    private float InteresMensual;
    private float GananciaInteres;
    private String EstadoCredito;
    private int idCliente;
    
    public mdCreditos(){
        
    }
    
    public mdCreditos(int idCredito, float CreditoIncial, float CreditoTotal, java.sql.Date FechaInicioCredito, java.sql.Date FechaFinalCredito, float InteresMensual, float GananciaInteres,String EstadoCredito, int idCliente){
        this.idCredito =idCredito;
        this.CreditoInicial = CreditoInicial;
        this.CreditoTotal = CreditoTotal;       
        this.FechaInicioCredito=FechaInicioCredito;
        this.FechaFinalCredito=FechaFinalCredito;
        this.InteresMensual=InteresMensual;   
        this.GananciaInteres=GananciaInteres;                     
        this.EstadoCredito=EstadoCredito;
        this.idCliente=idCliente;
    }
    
    /**
     * @return the idCredito
     */
    public int getIdCredito() {
        return idCredito;
    }

    /**
     * @param idCredito the idCredito to set
     */
    public void setIdCredito(int idCredito) {
        this.idCredito = idCredito;
    }

    /**
     * @return the CreditoInicial
     */
    public float getCreditoInicial() {
        return CreditoInicial;
    }

    /**
     * @param CreditoInicial the CreditoInicial to set
     */
    public void setCreditoInicial(float CreditoInicial) {
        this.CreditoInicial = CreditoInicial;
    }

    /**
     * @return the CreditoTotal
     */
    public float getCreditoTotal() {
        return CreditoTotal;
    }

    /**
     * @param CreditoTotal the CreditoTotal to set
     */
    public void setCreditoTotal(float CreditoTotal) {
        this.CreditoTotal = CreditoTotal;
    }
    
    /**
     * @return the FechaInicioCredito
     */
    public java.sql.Date getFechaInicioCredito() {
        return FechaInicioCredito;
    }

    /**
     * @param FechaInicioCredito the FechaInicioCredito to set
     */
    public void setFechaInicioCredito(java.sql.Date FechaInicioCredito) {
        this.FechaInicioCredito = FechaInicioCredito;
    }

    /**
     * @return the FechaFinalCredito
     */
    public java.sql.Date getFechaFinalCredito() {
        return FechaFinalCredito;
    }

    /**
     * @param FechaFinalCredito the FechaFinalCredito to set
     */
    public void setFechaFinalCredito(java.sql.Date FechaFinalCredito) {
        this.FechaFinalCredito = FechaFinalCredito;
    }
    /**
     * @return the InteresMensual
     */
    public float getInteresMensual() {
        return InteresMensual;
    }

    /**
     * @param InteresMensual the InteresMensual to set
     */
    public void setInteresMensual(float InteresMensual) {
        this.InteresMensual = InteresMensual;
    }

    /**
     * @return the GananciaInteres
     */
    public float getGananciaInteres() {
        return GananciaInteres;
    }

    /**
     * @param GananciaInteres the GananciaInteres to set
     */
    public void setGananciaInteres(float GananciaInteres) {
        this.GananciaInteres = GananciaInteres;
    }

    /**
     * @return the EstadoCredito
     */
    public String getEstadoCredito() {
        return EstadoCredito;
    }

    /**
     * @param EstadoCredito the EstadoCredito to set
     */
    public void setEstadoCredito(String EstadoCredito) {
        this.EstadoCredito = EstadoCredito;
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
     
}
