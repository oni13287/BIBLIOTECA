/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.MAutor;
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
  public class CAutor {
  
    private  ArrayList<MAutor> listarAutores() throws SQLException{
        MAutor Aut=new MAutor();
        ResultSet datosAutores=Aut.SolicitarAutores();
        ArrayList<MAutor> listaAutores=new ArrayList<>();    
        while(datosAutores.next()){
            MAutor d=new MAutor();
            d.setIdAutor(datosAutores.getInt("idAutor"));
            d.setNombreAutor(datosAutores.getString("nombreAutor"));
            d.setApellidoAutor(datosAutores.getString("apellidoAutor"));
            listaAutores.add(d);
        }                
        return listaAutores;
    }
 
    public DefaultTableModel tabularAutores() throws SQLException {
        ArrayList<MAutor> listAutor=listarAutores();
        DefaultTableModel tabAutores=new DefaultTableModel();
        tabAutores.addColumn("ID AUTOR");
        tabAutores.addColumn("NOMBRE");
        tabAutores.addColumn("APELLIDO");
        
        Object[] regAutor=new Object[3];
        
        for(MAutor d:listAutor){
           regAutor[0]=d.getIdAutor();  
           regAutor[1]=d.getNombreAutor();
           regAutor[2]=d.getApellidoAutor();
           tabAutores.addRow(regAutor);
        }
        
        return tabAutores;
    }
    
    
    
    public Object[] pedirAutor(String idAutor) throws SQLException{
        MAutor aut=new MAutor();
        Object[] regAut=new Object[2];
        ResultSet rAut=aut.consultarAutores(Integer.parseInt(idAutor));
        if(rAut.next()){
            regAut [0]= rAut.getString("nombreAutor");
            regAut [1]= rAut.getString("apellidoAutor");   
        }
        return regAut;
    }
    

    

    public boolean agregarAutor (JTextField nombreAutor, JTextField apellidoAutor) throws SQLException, ParseException{
        try {        
            String nom=nombreAutor.getText();
            String ape=apellidoAutor.getText();
            MAutor emp =new MAutor(nom,ape);
        if(emp.insertarAutores()>0)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CAutor.class.getName()).log(Level.SEVERE, null, ex);
          }
        return false; 
    }
    
    
    
     public boolean eliminarAutor(JTextField id){
        try {        
        String cadena= id.getText();
        int idAut = Integer.parseInt(cadena);
       MAutor emp=new MAutor(idAut);
        if(emp.eliminarAutores()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CAutor.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }

     
     
  public boolean editarAutor(JTextField id, JTextField nombreAutor, JTextField apellidoAutor) throws SQLException, ParseException{
          try {        
            String cadenaid= id.getText();
            int idAut= Integer.parseInt(cadenaid);
            
            String nom=nombreAutor.getText();
            String ape=apellidoAutor.getText();
            
                        
            MAutor emp =new MAutor(idAut, nom,ape);
            if(emp.actualizarAutores()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CAutor.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }

     
}

     
 
   

