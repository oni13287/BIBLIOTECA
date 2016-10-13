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
public class MCliente extends Conexion{
    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private int generoCliente;
    private String emailCliente;
    private String direccionCliente;


    public MCliente() {
       idCliente = 0;
       nombreCliente ="";
       apellidoCliente	="";
       generoCliente = 0;
       emailCliente ="";
       direccionCliente = "";
    }
    
    public MCliente(String nombreCliente, String apellidoCliente, int generoCliente, String emailCliente, String direccionCliente) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.generoCliente = generoCliente;
        this.emailCliente = emailCliente;
        this.direccionCliente = direccionCliente;
    }
    
       
    public MCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
     public MCliente(int idCliente, String nombreCliente, String apellidoCliente, int generoCliente, String emailCliente, String direccionCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.generoCliente = generoCliente;
        this.emailCliente = emailCliente;
        this.direccionCliente = direccionCliente;
    }

    
    
      
   
      public ResultSet SolicitarClientes() throws SQLException{
          Connection con=conectar();
          PreparedStatement selectCliente=con.prepareStatement("SELECT * FROM mcliente ");
          ResultSet res=selectCliente.executeQuery();
//          con.close();
          return res;
    }

 
    /**
     *
     * @return 
     * @throws SQLException
     */
    public int insertarClientes() throws SQLException{
          Connection con=conectar();
          PreparedStatement insCliente=con.prepareStatement("INSERT INTO `biblioteca`.`mcliente`(`nombreCliente`,`apellidoCliente`,`generoCliente`,`emailCliente`,`direccionCliente`) VALUES (\'"+this.nombreCliente + "\',\'"+this.apellidoCliente + "\',\'"+this.generoCliente + "\',\'"+this.emailCliente + "\',\'"+this.direccionCliente+"\')");// se borro la fecha de contratacion
          int res=insCliente.executeUpdate();
//          con.close();
          return res;
    }   
     
    public int eliminarClientes() throws SQLException{
          Connection con=conectar();
           PreparedStatement eliCliente=con.prepareStatement("DELETE FROM `mcliente` WHERE `idCliente`=\'"+this.idCliente+"'");
          int res=eliCliente.executeUpdate();
//          con.close();
          return res;
    } 
    
    public int actualizarClientes() throws SQLException{
          Connection con=conectar();                        //UPDATE `Cliente` SET `centX` =2 WHERE `idCliente` =5
          PreparedStatement actCliente =con.prepareStatement("UPDATE mcliente SET `nombreCliente`='"+this.nombreCliente+"',`apellidoCliente`='"+this.apellidoCliente+"',`generoCliente`='"+this.generoCliente+"',`emailCliente`='"+this.emailCliente+"',`direccionCliente`='"+this.direccionCliente+"' Where `idCliente`= '"+this.idCliente+"'");
          int res=actCliente.executeUpdate();
//          con.close();
          return res;
    } 
    
    public  ResultSet consultarClientes (int idCliente) throws SQLException{
            Connection  con;
            con=conectar();
            PreparedStatement consClientes=con.prepareStatement("SELECT `idCliente`,`nombreCliente`,`apellidoCliente`,`generoCliente`,`emailCliente`,`direccionCliente` FROM `mcliente` WHERE `idCliente`='"+idCliente+"'");//se borro la fecha de contratacion
            ResultSet res = consClientes.executeQuery();
            //con.close();
            return res;
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
     * @return the generoCliente
     */
    public int getGeneroCliente() {
        return generoCliente;
    }

    /**
     * @param generoCliente the generoCliente to set
     */
    public void setGeneroCliente(int generoCliente) {
        this.generoCliente = generoCliente;
    }

    /**
     * @return the emailCliente
     */
    public String getEmailCliente() {
        return emailCliente;
    }

    /**
     * @param emailCliente the emailCliente to set
     */
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    /**
     * @return the direccionCliente
     */
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     * @param direccionCliente the direccionCliente to set
     */
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    
}


