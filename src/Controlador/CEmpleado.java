/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;


import Modelo.MEmpleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Usuario
 */
public class CEmpleado {
  
    private  ArrayList<MEmpleado> listarEmpleados() throws SQLException{
        MEmpleado emp=new MEmpleado();
        ResultSet datosEmpleados=emp.SolicitarEmpleados();
        ArrayList<MEmpleado> listaEmpleados=new ArrayList<>();    
        while(datosEmpleados.next()){
            MEmpleado d=new MEmpleado();
            d.setIdEmpleado(datosEmpleados.getInt("idEmpleado"));
            d.setNombreEmpleado(datosEmpleados.getString("nombreEmpleado"));
            d.setApellidoEmpleado(datosEmpleados.getString("apellidoEmpleado"));
            d.setFechaContratacion(datosEmpleados.getString("fechaContratacion"));
            d.setGeneroEmpleado(datosEmpleados.getInt("generoEmpleado"));
            d.setEmailEmpleado(datosEmpleados.getString("emailEmpleado"));
            d.setDireccionEmpleado(datosEmpleados.getString("direccionEmpleado"));
            listaEmpleados.add(d);
        }                
        return listaEmpleados;
    }
 
    public DefaultTableModel tabularEmpleados() throws SQLException {
        ArrayList<MEmpleado> listEmpleado=listarEmpleados();
        DefaultTableModel tabEmpleados=new DefaultTableModel();
        tabEmpleados.addColumn("ID EMPLEADO");
        tabEmpleados.addColumn("NOMBRE");
        tabEmpleados.addColumn("APELLIDO");
        tabEmpleados.addColumn("FECHA DE CONTRATO");
        tabEmpleados.addColumn("GENERO");
        tabEmpleados.addColumn("EMAIL");
        tabEmpleados.addColumn("DIRECCION");
        
        Object[] regEmpleado=new Object[7];
        
        for(MEmpleado d:listEmpleado){
           regEmpleado[0]=d.getIdEmpleado();  
           regEmpleado[1]=d.getNombreEmpleado(); 
           regEmpleado[2]=d.getApellidoEmpleado();
           regEmpleado[3]=d.getFechaContratacion();
           if(d.getGeneroEmpleado()==0){
               regEmpleado[4]="masculino";
           }
           else
           {    regEmpleado[4]="femenino";    
           }
           regEmpleado[5]=d.getEmailEmpleado();
           regEmpleado[6]=d.getDireccionEmpleado();
           tabEmpleados.addRow(regEmpleado);
        }
        
        return tabEmpleados;
    }
    
    
    
    public Object[] pedirEmpleado(String idEmpleado) throws SQLException{
        MEmpleado emp=new MEmpleado();
        Object[] regEmp=new Object[6];
        ResultSet rEmp=emp.consultarEmpleados(Integer.parseInt(idEmpleado));
        if(rEmp.next()){
            regEmp [0]= rEmp.getString("nombreEmpleado");
            regEmp [1]= rEmp.getString("apellidoEmpleado");
            regEmp [2]= rEmp.getString("fechaContratacion");
            regEmp [3]= rEmp.getInt("generoEmpleado");
            regEmp [4]= rEmp.getString("emailEmpleado");
            regEmp [5]= rEmp.getString("direccionEmpleado"); 
                
        }
        return regEmp;
    }
    

    

    public boolean agregarEmpleado (JTextField nombreEmpleado, JTextField apellidoEmpleado, JTextField fechaContratacion, JComboBox generoEmpleado , JTextField emailEmpleado, JTextField direccionEmpleado) throws SQLException, ParseException{
        try {        
            String nom=nombreEmpleado.getText();
            String ape=apellidoEmpleado.getText();

            String fec =fechaContratacion.getText();
          
            int gen = generoEmpleado.getSelectedIndex();    
            
            String ema=emailEmpleado.getText();
            String dir=direccionEmpleado.getText();
            
            MEmpleado emp =new MEmpleado(nom,ape,fec,gen,ema,dir);
        if(emp.insertarEmpleados()>0)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
          }
        return false; 
    }
    
    
    
     public boolean eliminarEmpleado(JTextField id){
        try {        
        String cadena= id.getText();
        int idEmp = Integer.parseInt(cadena);
       MEmpleado emp=new MEmpleado(idEmp);
        if(emp.eliminarEmpleados()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }

     
     
  public boolean editarEmpleado(JTextField id ,JTextField nombreEmpleado, JTextField apellidoEmpleado, JTextField fechaContratacion, JComboBox generoEmpleado , JTextField emailEmpleado, JTextField direccionEmpleado) throws ParseException{
        try {        
            String cadenaid= id.getText();
            int idEmp = Integer.parseInt(cadenaid);
            String nom=nombreEmpleado.getText();
            String ape=apellidoEmpleado.getText();
            String fec=fechaContratacion.getText();
            int gen = generoEmpleado.getSelectedIndex();    
            String ema=emailEmpleado.getText();
            String dir=direccionEmpleado.getText();
            
            MEmpleado emp =new MEmpleado(idEmp, nom,ape,fec,gen,ema,dir);
            if(emp.actualizarEmpleados()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }

     
}

     
 
   

