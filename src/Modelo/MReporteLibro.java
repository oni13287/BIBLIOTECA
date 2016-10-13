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
public class MReporteLibro extends Conexion{
    private int idLibro;
    private String nombreLibro;
    private int codAutor;
    private String nombreAutor;
    private String apellidoAutor;
    private int codCategoria;
    private String nombreCategoria;


     
    public MReporteLibro() {
       idLibro= 0;
       nombreLibro ="";
       codAutor = 0;
       nombreAutor = "";
       apellidoAutor= "";
       codCategoria= 0;
       nombreCategoria= "";
       
    }
    
      public MReporteLibro(int idLibro, String nombreLibro, int codAutor, String nombreAutor, String apellidoAutor, int codCategoria, String nombreCategoria) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.codAutor = codAutor;
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
        this.codCategoria = codCategoria;
        this.nombreCategoria = nombreCategoria;
     
    }

    
    
    public MReporteLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    
   public ResultSet SolicitarLibros() throws SQLException{
          Connection con=conectar();
          PreparedStatement selectLibro=con.prepareStatement("select idLibro, nombreLibro, nombreAutor, apellidoAutor, nombreCategoria\n" +
"	from mlibro\n" +
"		inner join mautor on codAutor= IdAutor\n" +
"			 inner join mCategoria on codCategoria= IdCategoria; ");
          ResultSet res=selectLibro.executeQuery();
//          con.close();
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

 
    