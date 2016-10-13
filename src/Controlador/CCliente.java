/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tClilate file, choose Tools | TClilates
 * and open the tClilate in the editor.
 */

package Controlador;


import Modelo.MCliente;
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
public class CCliente {
  
    private  ArrayList<MCliente> listarClientes() throws SQLException{
        MCliente Cli=new MCliente();
        ResultSet datosClientes=Cli.SolicitarClientes();
        ArrayList<MCliente> listaClientes=new ArrayList<>();    
        while(datosClientes.next()){
            MCliente d=new MCliente();
            d.setIdCliente(datosClientes.getInt("idCliente"));
            d.setNombreCliente(datosClientes.getString("nombreCliente"));
            d.setApellidoCliente(datosClientes.getString("apellidoCliente"));
            d.setGeneroCliente(datosClientes.getInt("generoCliente"));
            d.setEmailCliente(datosClientes.getString("emailCliente"));
            d.setDireccionCliente(datosClientes.getString("direccionCliente"));
            listaClientes.add(d);
        }                
        return listaClientes;
    }
 
    public DefaultTableModel tabularClientes() throws SQLException {
        ArrayList<MCliente> listCliente=listarClientes();
        DefaultTableModel tabClientes=new DefaultTableModel();
        tabClientes.addColumn("ID CLIENTE");
        tabClientes.addColumn("NOMBRE");
        tabClientes.addColumn("APELLIDO");
        tabClientes.addColumn("GENERO");
        tabClientes.addColumn("EMAIL");
        tabClientes.addColumn("DIRECCION");
        
        Object[] regCliente=new Object[6];
        
        for(MCliente d:listCliente){
           regCliente[0]=d.getIdCliente();  
           regCliente[1]=d.getNombreCliente(); 
           regCliente[2]=d.getApellidoCliente();
           if(d.getGeneroCliente()==0){
               regCliente[3]="masculino";
           }
           else
           {    regCliente[3]="femenino";    
           }
           regCliente[4]=d.getEmailCliente();
           regCliente[5]=d.getDireccionCliente();
           tabClientes.addRow(regCliente);
        }
        
        return tabClientes;
    }
    
    
    
    public Object[] pedirCliente(String idCliente) throws SQLException{
        MCliente Cli=new MCliente();
        Object[] regCli=new Object[5];
        ResultSet rCli=Cli.consultarClientes(Integer.parseInt(idCliente));
        if(rCli.next()){
            regCli [0]= rCli.getString("nombreCliente");
            regCli [1]= rCli.getString("apellidoCliente");
            regCli [2]= rCli.getInt("generoCliente");
            regCli [3]= rCli.getString("emailCliente");
            regCli [4]= rCli.getString("direccionCliente"); 
                
        }
        return regCli;
    }
    

    

    public boolean agregarCliente (JTextField nombreCliente, JTextField apellidoCliente, JComboBox generoCliente , JTextField emailCliente, JTextField direccionCliente) throws SQLException, ParseException{
        try {        
            String nom=nombreCliente.getText();
            String ape=apellidoCliente.getText();

         
            int gen = generoCliente.getSelectedIndex();    
            
            String ema=emailCliente.getText();
            String dir=direccionCliente.getText();
            
            MCliente Cli =new MCliente(nom,ape,gen,ema,dir);
        if(Cli.insertarClientes()>0)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
          }
        return false; 
    }
    
    
    
     public boolean eliminarCliente(JTextField id){
        try {        
        String cadena= id.getText();
        int idCli = Integer.parseInt(cadena);
       MCliente Cli=new MCliente(idCli);
        if(Cli.eliminarClientes()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }

     
     
  public boolean editarCliente(JTextField id ,JTextField nombreCliente, JTextField apellidoCliente, JComboBox generoCliente , JTextField emailCliente, JTextField direccionCliente) throws ParseException{
        try {        
            String cadenaid= id.getText();
            int idCli = Integer.parseInt(cadenaid);
            String nom=nombreCliente.getText();
            String ape=apellidoCliente.getText();

            int gen = generoCliente.getSelectedIndex();    
            String ema=emailCliente.getText();
            String dir=direccionCliente.getText();
            
            MCliente Cli =new MCliente(idCli, nom,ape,gen,ema,dir);
            if(Cli.actualizarClientes()==1)
             return true;
        else
            return false;
     } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
     }

     
}

     
 
   

