/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class MReportePrestamo extends Conexion{
    private int idPrestamo;
    private String nombreLibro;
    private String nombreCliente;
    private String apellidoCliente;
    private String nombreEmpleado;
    private String apellidoEmpleado;

       
    public MReportePrestamo() {
       idPrestamo = 0;
       nombreLibro ="";
       nombreCliente ="";
       apellidoCliente ="";
       nombreEmpleado ="";
       apellidoEmpleado="";
    }
    
     public MReportePrestamo(int idPrestamo, String nombreLibro, String nombreCliente, String apellidoCliente, String nombreEmpleado, String apellidoEmpleado) {
        this.idPrestamo = idPrestamo;
        this.nombreLibro = nombreLibro;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
    }
   
    

   public ResultSet SolicitarPrestamos() throws SQLException{
          Connection con=conectar();
          PreparedStatement selectPrestamo=con.prepareStatement("SELECT idPrestamo, nombreLibro, nombreCliente, apellidoCliente, nombreEmpleado, apellidoEmpleado, fechaPedido, fechaEntrega\n" +
"		from mprestamo\n" +
"			inner join mlibro on codLibro = idLibro\n" +
"				inner join mcliente on codCliente = idCliente\n" +
"					inner join mempleado on codEmpleado = idEmpleado;");
          ResultSet res=selectPrestamo.executeQuery();
//          con.close();
          return res;
    }

    /**
     * @return the nombreLibro
     */
    public String getNombreLibro() {
        return nombreLibro;
    }

    /**
     * @param nombreLibro the nombreLibro to set
     */
    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the apellidoCliente
     */
    public String getApellidoCliente() {
        return apellidoCliente;
    }

    /**
     * @param apellidoCliente the apellidoCliente to set
     */
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    /**
     * @return the nombreEmpleado
     */
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    /**
     * @param nombreEmpleado the nombreEmpleado to set
     */
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    /**
     * @return the apellidoEmpleado
     */
    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    /**
     * @param apellidoEmpleado the apellidoEmpleado to set
     */
    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    /**
     * @return the idPrestamo
     */
    public int getIdPrestamo() {
        return idPrestamo;
    }

    /**
     * @param idPrestamo the idPrestamo to set
     */
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

   

}

 
    