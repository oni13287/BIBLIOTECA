/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Controlador;

import Modelo.MCategoria;
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
 * @Cathor Usuario
 */
  public class CCategoria {
  
    private  ArrayList<MCategoria> listarCategorias() throws SQLException{
        MCategoria Cat=new MCategoria();
        ResultSet datosCategorias=Cat.SolicitarCategorias();
        ArrayList<MCategoria> listaCategorias=new ArrayList<>();    
        while(datosCategorias.next()){
            MCategoria d=new MCategoria();
            d.setIdCategoria(datosCategorias.getInt("idCategoria"));
            d.setNombreCategoria(datosCategorias.getString("nombreCategoria"));
            listaCategorias.add(d);
        }                
        return listaCategorias;
    }
 
    public DefaultTableModel tabularCategorias() throws SQLException {
        ArrayList<MCategoria> listCategoria=listarCategorias();
        DefaultTableModel tabCategorias=new DefaultTableModel();
        tabCategorias.addColumn("ID CATEGORIA");
        tabCategorias.addColumn("NOMBRE");
               
        Object[] regCategoria=new Object[2];
        
        for(MCategoria d:listCategoria){
           regCategoria[0]=d.getIdCategoria();  
           regCategoria[1]=d.getNombreCategoria();
           tabCategorias.addRow(regCategoria);
        }
        
        return tabCategorias;
    }
    
    
    
    public Object[] pedirCategoria(String idCategoria) throws SQLException{
        MCategoria Cat=new MCategoria();
        Object[] regCat=new Object[1];
        ResultSet rCat=Cat.consultarCategorias(Integer.parseInt(idCategoria));
        if(rCat.next()){
            regCat [0]= rCat.getString("nombreCategoria");
            }
        return regCat;
    }
    

    

    public boolean agregarCategoria (JTextField nombreCategoria) throws SQLException, ParseException{
        try {        
            String nom=nombreCategoria.getText();
            
            MCategoria emp =new MCategoria(nom);
        if(emp.insertarCategorias()>0)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CCategoria.class.getName()).log(Level.SEVERE, null, ex);
          }
        return false; 
    }
    
    
    
     public boolean eliminarCategoria(JTextField id){
        try {        
        String cadena= id.getText();
        int idCat = Integer.parseInt(cadena);
       MCategoria emp=new MCategoria(idCat);
        if(emp.eliminarCategorias()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }

     
     
  public boolean editarCategoria(JTextField id, JTextField nombreCategoria) throws SQLException, ParseException{
          try {        
            String cadenaid= id.getText();
            int idCat= Integer.parseInt(cadenaid);
            String nom=nombreCategoria.getText();
            MCategoria emp =new MCategoria(idCat, nom);
            if(emp.actualizarCategorias()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }	

     
}

     
 
   
  

     
 
   
  
