/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.MReporteLibro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Usuario
 */
  public class CReporteLibro {
  
    private  ArrayList<MReporteLibro> listarReporteLibro() throws SQLException{
        MReporteLibro lib=new MReporteLibro();
        ResultSet datosLibros=lib.SolicitarLibros();
        ArrayList<MReporteLibro> listaLibros=new ArrayList<>();    
        while(datosLibros.next()){
            MReporteLibro d=new MReporteLibro();
            d.setIdLibro(datosLibros.getInt("idLibro"));
            d.setNombreLibro(datosLibros.getString("nombreLibro"));
            d.setNombreAutor(datosLibros.getString("nombreAutor"));
            d.setApellidoAutor(datosLibros.getString("apellidoAutor"));
            d.setNombreCategoria(datosLibros.getString("nombreCategoria"));
            listaLibros.add(d);
        }                
        return listaLibros;
    }
 
    public DefaultTableModel tabularLibros() throws SQLException {
        ArrayList<MReporteLibro> listLibro=listarReporteLibro();
        DefaultTableModel tabLibros=new DefaultTableModel();
        tabLibros.addColumn("Id Libro");
        tabLibros.addColumn("Libro");
        tabLibros.addColumn("Nombre Autor");
        tabLibros.addColumn("Apellido Autor");
        tabLibros.addColumn("Categoria");
        
        Object[] regLibro=new Object[5];
        
        for(MReporteLibro d:listLibro){
           regLibro[0]=d.getIdLibro();  
           regLibro[1]=d.getNombreLibro(); 
           regLibro[2]=d.getNombreAutor();
           regLibro[3]=d.getApellidoAutor();
           regLibro[4]=d.getNombreCategoria();
           tabLibros.addRow(regLibro);
        }
        
        return tabLibros;
    }
     
}


     
 
   

