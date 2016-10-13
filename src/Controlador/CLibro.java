/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.MLibro;
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
  public class CLibro {
  
    private  ArrayList<MLibro> listarLibros() throws SQLException{
        MLibro lib=new MLibro();
        ResultSet datosLibros=lib.SolicitarLibros();
        ArrayList<MLibro> listaLibros=new ArrayList<>();    
        while(datosLibros.next()){
            MLibro d=new MLibro();
            d.setIdLibro(datosLibros.getInt("idLibro"));
            d.setNombreLibro(datosLibros.getString("nombreLibro"));
            d.setCodAutor(datosLibros.getInt("codAutor"));
            d.setCodCategoria(datosLibros.getInt("codCategoria"));
            d.setCodPrestamo(datosLibros.getInt("codPrestamo"));
            listaLibros.add(d);
        }                
        return listaLibros;
    }
 
    public DefaultTableModel tabularLibros() throws SQLException {
        ArrayList<MLibro> listLibro=listarLibros();
        DefaultTableModel tabLibros=new DefaultTableModel();
        tabLibros.addColumn("ID LIBRO");
        tabLibros.addColumn("NOMBRE");
        tabLibros.addColumn("ID AUTOR");
        tabLibros.addColumn("ID CATEGORIA");
        tabLibros.addColumn("ID PRESTAMO");
        
        Object[] regLibro=new Object[5];
        
        for(MLibro d:listLibro){
           regLibro[0]=d.getIdLibro();  
           regLibro[1]=d.getNombreLibro(); 
           regLibro[2]=d.getCodAutor();
           regLibro[3]=d.getCodCategoria();
           regLibro[4]=d.getCodPrestamo();
           tabLibros.addRow(regLibro);
        }
        
        return tabLibros;
    }
    
    
    
    public Object[] pedirLibro(String idLibro) throws SQLException{
        MLibro lib=new MLibro();
        Object[] regLib=new Object[4];
        ResultSet rLib=lib.consultarLibros(Integer.parseInt(idLibro));
        if(rLib.next()){
            regLib [0]= rLib.getString("nombreLibro");
            regLib [1]= rLib.getInt("codAutor");
            regLib [2]= rLib.getInt("codCategoria");
            regLib [3]= rLib.getInt("codPrestamo");
                
        }
        return regLib;
    }
    

    

    public boolean agregarLibro (JTextField nombreLibro, JTextField codAutor, JTextField codCategoria , JTextField codPrestamo) throws SQLException, ParseException{
        try {        
            String nom=nombreLibro.getText();
             
            String cadena= codAutor.getText();
             int idAut = Integer.parseInt(cadena);
            
            String cadena2= codCategoria.getText();
            int idCat = Integer.parseInt(cadena2);
            
            String cadena3= codPrestamo.getText();
            int idPres = Integer.parseInt(cadena3);
        
            MLibro emp =new MLibro(nom,idAut,idCat,idPres);
        if(emp.insertarLibros()>0)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CLibro.class.getName()).log(Level.SEVERE, null, ex);
          }
        return false; 
    }
    
    
    
     public boolean eliminarLibro(JTextField id){
        try {        
        String cadena= id.getText();
        int idLib = Integer.parseInt(cadena);
       MLibro emp=new MLibro(idLib);
        if(emp.eliminarLibros()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }

     
     
  public boolean editarLibro(JTextField id, JTextField nombreLibro, JTextField codAutor, JTextField codCategoria , JTextField codPrestamo) throws SQLException, ParseException{
          try {        
            String cadenaid= id.getText();
            int idLib= Integer.parseInt(cadenaid);
            
             String nom=nombreLibro.getText();
             
            String cadena= codAutor.getText();
             int idAut = Integer.parseInt(cadena);
            
            String cadena2= codCategoria.getText();
            int idCat = Integer.parseInt(cadena2);
            
            String cadena3= codPrestamo.getText();
            int idPres = Integer.parseInt(cadena3);
            
            
            MLibro emp =new MLibro(idLib, nom,idAut,idCat,idPres);
            if(emp.actualizarLibros()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }

     
}


     
 
   

