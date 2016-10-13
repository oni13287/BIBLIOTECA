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
 * @Cathor Usuario
 */
public class MCategoria extends Conexion{
    private int idCategoria;
    private String nombreCategoria;
   

    public MCategoria() {
       idCategoria= 0;
       nombreCategoria ="";
    }
    
    public MCategoria(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public MCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public MCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
       
   
   public ResultSet SolicitarCategorias() throws SQLException{
          Connection con=conectar();
          PreparedStatement selectCategoria=con.prepareStatement("SELECT * FROM mcategoria ");
          ResultSet res=selectCategoria.executeQuery();
//          con.close();
          return res;
    }

 
    /**
     *
     * @return 
     * @throws SQLException
     */
    public int insertarCategorias() throws SQLException{
          Connection con=conectar();
          PreparedStatement insCategoria=con.prepareStatement("INSERT INTO `biblioteca`.`mcategoria`(`nombreCategoria`) VALUES (\'"+this.getNombreCategoria()+"\')");
          int res=insCategoria.executeUpdate();
//          con.close();
          return res;
    }   
     
    public int eliminarCategorias() throws SQLException{
          Connection con=conectar();
           PreparedStatement eliCategoria=con.prepareStatement("DELETE FROM `mCategoria` WHERE `idCategoria`=\'"+this.getIdCategoria()+"'");
          int res=eliCategoria.executeUpdate();
//          con.close();
          return res;
    } 
    
    public int actualizarCategorias() throws SQLException{
          Connection con=conectar();                       
          PreparedStatement actCategoria =con.prepareStatement("UPDATE mcategoria SET `nombreCategoria`='"+this.getNombreCategoria()+"' Where `idCategoria`= '"+this.getIdCategoria()+"'");
          int res=actCategoria.executeUpdate();
//          con.close();
          return res;
    } 
    
    public  ResultSet consultarCategorias (int idCategoria) throws SQLException{
            Connection  con;
            con=conectar();
            PreparedStatement consCategoriaes=con.prepareStatement("SELECT `idCategoria`,`nombreCategoria` FROM `mcategoria` WHERE `idCategoria`='"+idCategoria+"'");//se borro la fecha de contratacion
            ResultSet res = consCategoriaes.executeQuery();
            //con.close();
            return res;
    }

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the nombreCategoria
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    /**
     * @param nombreCategoria the nombreCategoria to set
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

   
}
    
