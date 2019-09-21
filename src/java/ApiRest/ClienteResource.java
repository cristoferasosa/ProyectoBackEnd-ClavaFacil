/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiRest;

import DAO.CreditoDao;
import Modelo.mdCliente;
import Modelo.mdCreditos;
import Modelo.mdCuenta;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import servicios.ConsumirServicio;
import servicios.CreditoServicio;
import servicios.CuentaServicio;

/**
 * REST Web Service
 *
 * @author SOSA
 */
@Path("Cliente")
public class ClienteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClienteResource
     */
    public ClienteResource() {
    }

    /**
     * Retrieves representation of an instance of ApiRest.ClienteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("listarclientes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes() {
        //TODO return proper representation object
        try{
            List<mdCliente> cli = new ConsumirServicio().getAll();
            String json = new Gson().toJson(cli);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }catch (Exception ex) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
     //Lista la info del cliente por ID   
    @GET
    @Path("listarcliente/{idCliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("idCliente")int idCliente){        
        try{
           mdCliente clien = new ConsumirServicio().get(idCliente);
           String json = new Gson().toJson(clien);
           return Response.ok(json, MediaType.APPLICATION_JSON).build();
           
       }catch(Exception e){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
       } 
    }
    
    @POST
    @Path("addcliente")    
    @Consumes(MediaType.APPLICATION_JSON)
    public String addCliente(String json){
      try{
            Gson gson = new Gson();           
            mdCliente cli =gson.fromJson(json, mdCliente.class);
             
            ConsumirServicio service = new ConsumirServicio();
            service.create(cli);
            String respuesta=String.valueOf(cli.getNombres()+" "+cli.getApellidos()+" "+cli.getEdad()+" "+cli.getDpi()+" "+cli.getDireccion()+" "+cli.getTelefono()+" "+cli.getCorreo());
        return respuesta;
        }catch(Exception e){
            
        }
        return null;
   }

    /**
     * PUT method for updating or creating an instance of ClienteResource
     * @param content representation for the resource
     */
    @PUT
    @Path("updatecliente")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCliente(String json){
         try{
             Gson gson=new Gson();
             mdCliente cli =gson.fromJson(json,mdCliente.class);
             
             ConsumirServicio service =new ConsumirServicio();
             
             service.update(cli);
             
            return cli.getIdCliente()+" "+cli.getNombres()+" "+cli.getApellidos()+" "+cli.getEdad()+" "+cli.getDpi()+" "+cli.getDireccion()+" "+cli.getTelefono()+" "+cli.getCorreo();
            }catch(Exception e){
            }
        return " ";
    }       
                       
    @DELETE
    @Path("deletecliente/{idCliente}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteCliente(@PathParam("idCliente")int idCliente){
        try{
            mdCliente cli = new mdCliente();
           
            ConsumirServicio services = new ConsumirServicio();
            services.delete(idCliente);
            String json="(\"id\":\""+cli.getIdCliente()+"\"}";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){
               return Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
        }
    }
    
    ////////////////////////Metodos de Creditos
    /**
     * Retrieves representation of an instance of ApiRest.ClienteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("listarcreditos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCreditos() {
        //TODO return proper representation object
        try{
            List<mdCreditos> cre = new CreditoServicio().getAll();
            String json = new Gson().toJson(cre);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }catch (Exception ex) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
     //Lista la info del credito por ID   
    @GET
    @Path("listarcredito/{idCredito}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getcredito(@PathParam("idCredito")int idCredito){        
        try{
           mdCreditos cre = new CreditoServicio().get(idCredito);
           
           String json = new Gson().toJson(cre);
           return Response.ok(json, MediaType.APPLICATION_JSON).build();
           
       }catch(Exception e){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
       } 
    }
    
    @POST
    @Path("addcredito")    
    @Consumes(MediaType.APPLICATION_JSON)
    public String addCredito(String json){
      try{
            Gson gson = new Gson();           
            mdCreditos cre =gson.fromJson(json, mdCreditos.class);
            mdCliente cli =gson.fromJson(json, mdCliente.class);
             
            CreditoServicio servicio = new CreditoServicio();            
            servicio.create(cre);
            
            String respuesta=String.valueOf(cre.getCreditoInicial()+" "+cre.getCreditoTotal()+" "+cre.getFechaInicioCredito()+" "+cre.getFechaFinalCredito()+" "+cre.getInteresMensual()+" "+cre.getGananciaInteres()+" "+cre.getEstadoCredito()+" "+cli.getIdCliente());
        return respuesta;
        }catch(Exception e){
            
        }
        return null;
   }

    /**
     * PUT method for updating or creating an instance of ClienteResource
     * @param json
     * @param content representation for the resource
     * @return 
     */
    @PUT
    @Path("updatecredito")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCredito(String json){
         try{
             Gson gson=new Gson();
             mdCreditos cre =gson.fromJson(json,mdCreditos.class);
             
             CreditoServicio servicio =new CreditoServicio();
             
             servicio.update(cre);
             
            return cre.getIdCredito()+" "+cre.getCreditoInicial()+" "+cre.getCreditoTotal()+" "+cre.getFechaInicioCredito()+" "+cre.getFechaFinalCredito()+" "+cre.getInteresMensual()+" "+cre.getGananciaInteres()+" "+cre.getEstadoCredito();
            }catch(Exception e){
            }
        return " ";
    }       
                       
    @DELETE
    @Path("deletecredito/{idCredito}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteCredito(@PathParam("idCredito")int idCredito){
        try{
            mdCreditos cre = new mdCreditos();
           
            CreditoServicio servicio = new CreditoServicio();
            
            servicio.delete(idCredito);
            
            String json="(\"id\":\""+cre.getIdCredito()+"\"}";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){
               return Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
        }
    }
    
    
    ///////////////////////Metodos de la tabla cuenta/////////////////////////////    
    /**
     * Retrieves representation of an instance of ApiRest.ClienteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("listarcuentas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCuentas() {
        //TODO return proper representation object
        try{
            List<mdCuenta> cue = new CuentaServicio().getAll();
            String json = new Gson().toJson(cue);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }catch (Exception ex) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
     //Lista la info del credito por ID   
    @GET
    @Path("listarcuenta/{idCuenta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getcuenta(@PathParam("idCuenta")int idCuenta){        
        try{
           mdCuenta cue = new CuentaServicio().get(idCuenta);
           
           String json = new Gson().toJson(cue);
           return Response.ok(json, MediaType.APPLICATION_JSON).build();
           
       }catch(Exception e){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
       } 
    }
    
    @POST
    @Path("addcuenta")    
    @Consumes(MediaType.APPLICATION_JSON)
    public String addCuenta(String json){
      try{
            Gson gson = new Gson();           
            mdCuenta cue =gson.fromJson(json, mdCuenta.class);
            
            CuentaServicio servicio = new CuentaServicio();            
            servicio.create(cue);
            
            String respuesta=String.valueOf(cue.getNombre()+" "+cue.getCantidad());
        return respuesta;
        }catch(Exception e){
            
        }
        return null;
   }

    /**
     * PUT method for updating or creating an instance of ClienteResource
     * @param json
     * @return 
     */
    @PUT
    @Path("updatecuenta")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCuenta(String json){
         try{
             Gson gson=new Gson();
             mdCuenta cue =gson.fromJson(json,mdCuenta.class);
             
             CuentaServicio servicio =new CuentaServicio();
             
             servicio.update(cue);
             
            return cue.getIdCuenta()+" "+cue.getNombre()+" "+cue.getCantidad();
            }catch(Exception e){
            }
        return " ";
    }       
                       
    @DELETE
    @Path("deletecuenta/{idCuenta}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteCuenta(@PathParam("idCuenta")int idCuenta){
        try{
            mdCuenta cue = new mdCuenta();
           
            CuentaServicio servicio = new CuentaServicio();
            
            servicio.delete(idCuenta);
            
            String json="(\"id\":\""+cue.getIdCuenta()+"\"}";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){
               return Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
        }
    }
}
