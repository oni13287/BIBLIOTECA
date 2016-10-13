/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.MPrestamo;
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
  public class CPrestamo {
  
    private  ArrayList<MPrestamo> listarPrestamos() throws SQLException{
        MPrestamo Pre=new MPrestamo();
        ResultSet datosPrestamos=Pre.SolicitarPrestamos();
        ArrayList<MPrestamo> listaPrestamos=new ArrayList<>();    
        while(datosPrestamos.next()){
            MPrestamo d=new MPrestamo();
            d.setIdPrestamo(datosPrestamos.getInt("idPrestamo"));
            d.setCodLibro(datosPrestamos.getInt("codLibro"));
            d.setCodCliente(datosPrestamos.getInt("codCliente"));
            d.setCodEmpleado(datosPrestamos.getInt("codEmpleado"));
            d.setFechaPedido(datosPrestamos.getString("fechaPedido"));
            d.setFechaEntrega(datosPrestamos.getString("fechaEntrega"));
            listaPrestamos.add(d);
        }                
        return listaPrestamos;
    }
 
    public DefaultTableModel tabularPrestamos() throws SQLException {
        ArrayList<MPrestamo> listPrestamo=listarPrestamos();
        DefaultTableModel tabPrestamos=new DefaultTableModel();
        tabPrestamos.addColumn("ID PRESTAMO");
        tabPrestamos.addColumn("COD LIBRO");
        tabPrestamos.addColumn("COD CLIENTE");
        tabPrestamos.addColumn("COD EMPLEADO");
        tabPrestamos.addColumn("FECHA PEDIDO");
        tabPrestamos.addColumn("FECHA ENTREGA");
        Object[] regPrestamo=new Object[6];
        
        for(MPrestamo d:listPrestamo){
           regPrestamo[0]=d.getIdPrestamo(); 
           regPrestamo[1]=d.getCodLibro();
           regPrestamo[2]=d.getCodCliente();  
           regPrestamo[3]=d.getCodEmpleado();  
           regPrestamo[4]=d.getFechaPedido();  
           regPrestamo[5]=d.getFechaEntrega();
           tabPrestamos.addRow(regPrestamo);
        }
        
        return tabPrestamos;
    }
    
    
    
    public Object[] pedirPrestamo(String idPrestamo) throws SQLException{
        MPrestamo Pre=new MPrestamo();
        Object[] regPre=new Object[6];
        ResultSet rPre=Pre.consultarPrestamos(Integer.parseInt(idPrestamo));
        if(rPre.next()){
            regPre [0]= rPre.getInt("idPrestamo");
            regPre [1]= rPre.getInt("codLibro");
            regPre [2]= rPre.getInt("codCliente");
            regPre [3]= rPre.getInt("codEmpleado");
            regPre [4]= rPre.getString("fechaPedido");
            regPre [5]= rPre.getString("fechaEntrega");
                
        }
        return regPre;
    }
    

    

    public boolean agregarPrestamo (JTextField idPrestamo, JTextField codLibro ,JTextField codCliente, JTextField codEmpleado, JTextField fechaPedido, JTextField fechaEntrega) throws SQLException, ParseException{
        try {        
            
            String cadena5= idPrestamo.getText();
             int idPres = Integer.parseInt(cadena5);
                        
            String cadena= codLibro.getText();
             int idLib = Integer.parseInt(cadena);
                        
            String cadena1= codCliente.getText();
             int idCli = Integer.parseInt(cadena1);
            
            String cadena2= codEmpleado.getText();
            int idEmp = Integer.parseInt(cadena2);
            
            String fpe = fechaPedido.getText();
            String fga = fechaEntrega.getText();
            
            
            MPrestamo emp =new MPrestamo(idPres,idLib,idCli,idEmp,fpe,fga);
        if(emp.insertarPrestamos()>0)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CPrestamo.class.getName()).log(Level.SEVERE, null, ex);
          }
        return false; 
    }
    
    
    
    public boolean eliminarPrestamo(JTextField id){
        try {        
        String cadena= id.getText();
        int idPre = Integer.parseInt(cadena);
       MPrestamo emp=new MPrestamo(idPre);
        if(emp.eliminarPrestamos()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CPrestamo.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }

     
     
  public boolean editarPrestamo(JTextField id, JTextField codLibro, JTextField codCliente, JTextField codEmpleado, JTextField fechaPedido, JTextField fechaEntrega) throws SQLException, ParseException{
          try {     
              
              
            String cadenaid= id.getText();
            int idPre= Integer.parseInt(cadenaid);
            
            String cadena= codLibro.getText();
            int idLib = Integer.parseInt(cadena);
            
            String cadena1= codCliente.getText();
             int idCli = Integer.parseInt(cadena1);
            
            String cadena2= codEmpleado.getText();
            int idEmp = Integer.parseInt(cadena2);
            
            String fpe = fechaPedido.getText();
            String fga = fechaEntrega.getText();
            
            
            MPrestamo emp =new MPrestamo(idPre, idLib, idCli, idEmp, fpe, fga);
            if(emp.actualizarPrestamos()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CPrestamo.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }

     
}


     
 
   

