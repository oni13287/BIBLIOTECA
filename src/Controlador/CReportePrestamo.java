/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.MReportePrestamo;
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
  public class CReportePrestamo {
  
    private  ArrayList<MReportePrestamo> listarReportePrestamo() throws SQLException{
        MReportePrestamo lib=new MReportePrestamo();
        ResultSet datosPrestamos=lib.SolicitarPrestamos();
        ArrayList<MReportePrestamo> listaPrestamos=new ArrayList<>();    
        while(datosPrestamos.next()){
            MReportePrestamo d=new MReportePrestamo();
            d.setIdPrestamo(datosPrestamos.getInt("idPrestamo"));
            d.setNombreLibro(datosPrestamos.getString("nombreLibro"));
            d.setNombreCliente(datosPrestamos.getString("nombreCliente"));
            d.setApellidoCliente(datosPrestamos.getString("apellidoCliente"));
            d.setNombreEmpleado(datosPrestamos.getString("nombreEmpleado"));
            d.setApellidoEmpleado(datosPrestamos.getString("apellidoEmpleado"));
            listaPrestamos.add(d);
        }                
        return listaPrestamos;
    }
 
    public DefaultTableModel tabularPrestamos() throws SQLException {
        ArrayList<MReportePrestamo> listPrestamo=listarReportePrestamo();
        DefaultTableModel tabPrestamos=new DefaultTableModel();
        tabPrestamos.addColumn("Id Prestamo");
        tabPrestamos.addColumn("Nombre Libro");
        tabPrestamos.addColumn("Nombre Cliente");
        tabPrestamos.addColumn("Apellido Cliente");
        tabPrestamos.addColumn("Nombre Empleado");
        tabPrestamos.addColumn("Apellido Empleado");
        
        Object[] regPrestamo=new Object[6];
        
        for(MReportePrestamo d:listPrestamo){
           regPrestamo[0]=d.getIdPrestamo();  
           regPrestamo[1]=d.getNombreLibro(); 
           regPrestamo[2]=d.getNombreCliente(); 
           regPrestamo[3]=d.getApellidoCliente();
           regPrestamo[4]=d.getNombreEmpleado();
           regPrestamo[5]=d.getApellidoEmpleado();
           tabPrestamos.addRow(regPrestamo);
        }
        
        return tabPrestamos;
    }
     
}


     
 
   

