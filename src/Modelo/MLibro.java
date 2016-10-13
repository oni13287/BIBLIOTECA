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
public class MLibro extends Conexion{
    private int idLibro;
    private String nombreLibro;
    private int codAutor;
    private int codCategoria;
    private int codPrestamo;

    
    
    public MLibro() {
       idLibro= 0;
       nombreLibro ="";
       codAutor = 0;
       codCategoria= 0;
       codPrestamo= 0;
    }
    
    public MLibro(String nombreLibro, int codAutor, int codCategoria, int codPrestamo) {
        this.nombreLibro = nombreLibro;
        this.codAutor = codAutor;
        this.codCategoria = codCategoria;
        this.codPrestamo = codPrestamo;
    }

    public MLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    
    
    public MLibro(int idLibro, String nombreLibro, int codAutor, int codCategoria, int codPrestamo) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.codAutor = codAutor;
        this.codCategoria = codCategoria;
        this.codPrestamo = codPrestamo;
    }
      
   
   public ResultSet SolicitarLibros() throws SQLException{
          Connection con=conectar();
          PreparedStatement selectLibro=con.prepareStatement("SELECT * FROM mLibro ");
          ResultSet res=selectLibro.executeQuery();
//          con.close();
          return res;
    }

 
    /**
     *
     * @return 
     * @throws SQLException
     */
    public int insertarLibros() throws SQLException{
          Connection con=conectar();
          PreparedStatement insLibro=con.prepareStatement("INSERT INTO `biblioteca`.`mlibro`(`nombreLibro`,`codAutor`,`codCategoria`,`codPrestamo`) VALUES (\'"+this.nombreLibro + "\',\'"+this.codAutor + "\',\'"+this.codCategoria + "\','"+this.codPrestamo+"\')");
          int res=insLibro.executeUpdate();
//          con.close();
          return res;
    }   
     
    public int eliminarLibros() throws SQLException{
          Connection con=conectar();
           PreparedStatement eliLibro=con.prepareStatement("DELETE FROM `mlibro` WHERE `idLibro`=\'"+this.idLibro+"'");
          int res=eliLibro.executeUpdate();
//          con.close();
          return res;
    } 
    
    public int actualizarLibros() throws SQLException{
          Connection con=conectar();                       
          PreparedStatement actLibro =con.prepareStatement("UPDATE mlibro SET `nombreLibro`='"+this.nombreLibro+"',`codAutor`='"+this.codAutor+"',`codCategoria`='"+this.codCategoria+"',`codPrestamo`='"+this.codPrestamo+"' Where `idLibro`= '"+this.idLibro+"'");
          int res=actLibro.executeUpdate();
//          con.close();
          return res;
    } 
    
    public  ResultSet consultarLibros (int idLibro) throws SQLException{
            Connection  con;
            con=conectar();
            PreparedStatement consLibros=con.prepareStatement("SELECT `idLibro`,`nombreLibro`,`codAutor`,`codCategoria`,`codPrestamo` FROM `mlibro` WHERE `idLibro`='"+idLibro+"'");//se borro la fecha de contratacion
            ResultSet res = consLibros.executeQuery();
            //con.close();
            return res;
    }

    /**
     * @return the idLibro
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * @param idLibro the idLibro to set
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
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
     * @return the codAutor
     */
    public int getCodAutor() {
        return codAutor;
    }

    /**
     * @param codAutor the codAutor to set
     */
    public void setCodAutor(int codAutor) {
        this.codAutor = codAutor;
    }

    /**
     * @return the codCategoria
     */
    public int getCodCategoria() {
        return codCategoria;
    }

    /**
     * @param codCategoria the codCategoria to set
     */
    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    /**
     * @return the codPrestamo
     */
    public int getCodPrestamo() {
        return codPrestamo;
    }

    /**
     * @param codPrestamo the codPrestamo to set
     */
    public void setCodPrestamo(int codPrestamo) {
        this.codPrestamo = codPrestamo;
    }
}

  