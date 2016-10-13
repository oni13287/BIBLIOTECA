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
public class MAutor extends Conexion{
    private int idAutor;
    private String nombreAutor;
    private String apellidoAutor;

    public MAutor() {
       idAutor= 0;
       nombreAutor ="";
       apellidoAutor = "";
    }
    
    public MAutor(int idAutor, String nombreAutor, String apellidoAutor) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
    }

    public MAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public MAutor(String nombreAutor, String apellidoAutor) {
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
    }
    
       
   
   public ResultSet SolicitarAutores() throws SQLException{
          Connection con=conectar();
          PreparedStatement selectAutor=con.prepareStatement("SELECT * FROM mautor ");
          ResultSet res=selectAutor.executeQuery();
//          con.close();
          return res;
    }

 
    /**
     *
     * @return 
     * @throws SQLException
     */
    public int insertarAutores() throws SQLException{
          Connection con=conectar();
          PreparedStatement insAutor=con.prepareStatement("INSERT INTO `biblioteca`.`mautor`(`nombreAutor`,`apellidoAutor`) VALUES (\'"+this.getNombreAutor() + "\','"+this.getApellidoAutor()+"\')");
          int res=insAutor.executeUpdate();
//          con.close();
          return res;
    }   
     
    public int eliminarAutores() throws SQLException{
          Connection con=conectar();
           PreparedStatement eliAutor=con.prepareStatement("DELETE FROM `mautor` WHERE `idAutor`=\'"+this.getIdAutor()+"'");
          int res=eliAutor.executeUpdate();
//          con.close();
          return res;
    } 
    
    public int actualizarAutores() throws SQLException{
          Connection con=conectar();                       
          PreparedStatement actAutor =con.prepareStatement("UPDATE mautor SET `nombreAutor`='"+this.getNombreAutor()+"',`apellidoAutor`='"+this.getApellidoAutor()+"' Where `idAutor`= '"+this.getIdAutor()+"'");
          int res=actAutor.executeUpdate();
//          con.close();
          return res;
    } 
    
    public  ResultSet consultarAutores (int idAutor) throws SQLException{
            Connection  con;
            con=conectar();
            PreparedStatement consAutores=con.prepareStatement("SELECT `idAutor`,`nombreAutor`,`apellidoAutor` FROM `mautor` WHERE `idAutor`='"+idAutor+"'");//se borro la fecha de contratacion
            ResultSet res = consAutores.executeQuery();
            //con.close();
            return res;
    }

    /**
     * @return the idAutor
     */
    public int getIdAutor() {
        return idAutor;
    }

    /**
     * @param idAutor the idAutor to set
     */
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    /**
     * @return the nombreAutor
     */
    public String getNombreAutor() {
        return nombreAutor;
    }

    /**
     * @param nombreAutor the nombreAutor to set
     */
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    /**
     * @return the apellidoAutor
     */
    public String getApellidoAutor() {
        return apellidoAutor;
    }

    /**
     * @param apellidoAutor the apellidoAutor to set
     */
    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }
}
    