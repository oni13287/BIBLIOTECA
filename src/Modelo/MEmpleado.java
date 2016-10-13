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
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class MEmpleado extends Conexion{
    private int idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String fechaContratacion;
    private int generoEmpleado;
    private String emailEmpleado;
    private String direccionEmpleado;

    public MEmpleado() {
       idEmpleado = 0;
       nombreEmpleado ="";
       apellidoEmpleado	="";
       fechaContratacion =  "";
       generoEmpleado = 0;
       emailEmpleado ="";
       direccionEmpleado = "";
    }
    
    public MEmpleado(String nombreEmpleado, String apellidoEmpleado, String fechaContratacion, int generoEmpleado, String emailEmpleado, String direccionEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.generoEmpleado = generoEmpleado;
        this.emailEmpleado = emailEmpleado;
        this.direccionEmpleado = direccionEmpleado;
    }
    
       
    public MEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
     public MEmpleado(int idEmpleado, String nombreEmpleado, String apellidoEmpleado, String fechaContratacion, int generoEmpleado, String emailEmpleado, String direccionEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.generoEmpleado = generoEmpleado;
        this.emailEmpleado = emailEmpleado;
        this.direccionEmpleado = direccionEmpleado;
    }

    
    
      
   
      public ResultSet SolicitarEmpleados() throws SQLException{
          Connection con=conectar();
          PreparedStatement selectEmpleado=con.prepareStatement("SELECT * FROM mempleado ");
          ResultSet res=selectEmpleado.executeQuery();
//          con.close();
          return res;
    }

 
    /**
     *
     * @return 
     * @throws SQLException
     */
    public int insertarEmpleados() throws SQLException{
          Connection con=conectar();
          PreparedStatement insEmpleado=con.prepareStatement("INSERT INTO `biblioteca`.`mempleado`(`nombreEmpleado`,`apellidoEmpleado`,`fechaContratacion`,`generoEmpleado`,`emailEmpleado`,`direccionEmpleado`) VALUES (\'"+this.nombreEmpleado + "\',\'"+this.apellidoEmpleado + "\',\'"+this.fechaContratacion + "\',\'"+this.generoEmpleado + "\',\'"+this.emailEmpleado + "\',\'"+this.direccionEmpleado+"\')");// se borro la fecha de contratacion
          int res=insEmpleado.executeUpdate();
//          con.close();
          return res;
    }   
     
    public int eliminarEmpleados() throws SQLException{
          Connection con=conectar();
           PreparedStatement eliEmpleado=con.prepareStatement("DELETE FROM `mempleado` WHERE `idEmpleado`=\'"+this.idEmpleado+"'");
          int res=eliEmpleado.executeUpdate();
//          con.close();
          return res;
    } 
    
    public int actualizarEmpleados() throws SQLException{
          Connection con=conectar();                        //UPDATE `Empleado` SET `centX` =2 WHERE `idEmpleado` =5
          PreparedStatement actEmpleado =con.prepareStatement("UPDATE mempleado SET `nombreEmpleado`='"+this.nombreEmpleado+"',`apellidoEmpleado`='"+this.apellidoEmpleado+"',`fechaContratacion`='"+this.fechaContratacion+"',`generoEmpleado`='"+this.generoEmpleado+"',`emailEmpleado`='"+this.emailEmpleado+"',`direccionEmpleado`='"+this.direccionEmpleado+"' Where `idEmpleado`= '"+this.idEmpleado+"'");
          int res=actEmpleado.executeUpdate();
//          con.close();
          return res;
    } 
    
    public  ResultSet consultarEmpleados (int idEmpleado) throws SQLException{
            Connection  con;
            con=conectar();
            PreparedStatement consEmpleados=con.prepareStatement("SELECT `idEmpleado`,`nombreEmpleado`,`apellidoEmpleado`,`fechaContratacion`,`generoEmpleado`,`emailEmpleado`,`direccionEmpleado` FROM `mempleado` WHERE `idEmpleado`='"+idEmpleado+"'");//se borro la fecha de contratacion
            ResultSet res = consEmpleados.executeQuery();
            //con.close();
            return res;
    }

    /**
     * @return the idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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
     * @return the fechaContratacion
    */
    public String getFechaContratacion() {
        return fechaContratacion;
    }
     
    
    /**
     * @param fechaContratacion the fechaContratacion to set
     */
    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
    
    
    /**
     * @return the generoEmpleado
     */
    public int getGeneroEmpleado() {
        return generoEmpleado;
    }

    /**
     * @param generoEmpleado the generoEmpleado to set
     */
    public void setGeneroEmpleado(int generoEmpleado) {
        this.generoEmpleado = generoEmpleado;
    }

    /**
     * @return the emailEmpleado
     */
    public String getEmailEmpleado() {
        return emailEmpleado;
    }

    /**
     * @param emailEmpleado the emailEmpleado to set
     */
    public void setEmailEmpleado(String emailEmpleado) {
        this.emailEmpleado = emailEmpleado;
    }

    /**
     * @return the direccionEmpleado
     */
    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    /**
     * @param direccionEmpleado the direccionEmpleado to set
     */
    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    
}


