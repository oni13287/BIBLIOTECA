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
public class MPrestamo extends Conexion{
    private int idPrestamo;
    private int codLibro;
    private int codCliente;
    private int codEmpleado;
    private String fechaPedido;
    private String fechaEntrega;

     public MPrestamo() {
       idPrestamo= 0;
       codLibro= 0;
       codCliente = 0;
       codEmpleado= 0;
       fechaPedido= "";
       fechaEntrega="";
    }

     public MPrestamo(int idPrestamo, int codLibro, int codCliente, int codEmpleado, String fechaPedido, String fechaEntrega) {
        this.idPrestamo = idPrestamo;
        this.codLibro = codLibro;
        this.codCliente = codCliente;
        this.codEmpleado = codEmpleado;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
    }

    public MPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public MPrestamo(int codLibro, int codCliente, int codEmpleado, String fechaPedido, String fechaEntrega) {
        this.codLibro = codLibro;
        this.codCliente = codCliente;
        this.codEmpleado = codEmpleado;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
    }
   
    public ResultSet SolicitarPrestamos() throws SQLException{
          Connection con=conectar();
          PreparedStatement selectPrestamo=con.prepareStatement("SELECT * FROM mprestamo ");
          ResultSet res=selectPrestamo.executeQuery();
//          con.close();
          return res;
    }

 
    /**
     *
     * @return 
     * @throws SQLException
     */
    public int insertarPrestamos() throws SQLException{
          Connection con=conectar();
          PreparedStatement insPrestamo=con.prepareStatement("INSERT INTO `biblioteca`.`mprestamo`(`idPrestamo`,`codLibro`,`codCliente`,`codEmpleado`,`fechaPedido`,`fechaEntrega`) VALUES (\'"+this.getIdPrestamo() + "\','"+this.getCodLibro() + "\','"+this.codCliente+"\','"+this.codEmpleado+"\','"+this.fechaPedido+"\','"+this.fechaEntrega+"\')");
          int res=insPrestamo.executeUpdate();
//          con.close();
          return res;
    }   
     
    public int eliminarPrestamos() throws SQLException{
          Connection con=conectar();
           PreparedStatement eliPrestamo=con.prepareStatement("DELETE FROM `mprestamo` WHERE `idPrestamo`=\'"+this.idPrestamo+"'");
          int res=eliPrestamo.executeUpdate();
//          con.close();
          return res;
    } 
    
    public int actualizarPrestamos() throws SQLException{
          Connection con=conectar();                       
          PreparedStatement actPrestamo =con.prepareStatement("UPDATE mprestamo SET `idPrestamo`='"+this.idPrestamo+"' ,`codLibro`='"+this.codLibro+"',`codCliente`='"+this.codCliente+"',`codEmpleado`='"+this.codEmpleado+"',`fechaEntrega`='"+this.fechaEntrega+"',`fechaPedido`='"+this.fechaPedido+"' Where `idPrestamo`= '"+this.idPrestamo+"'");
          int res=actPrestamo.executeUpdate();
//          con.close();
          return res;
    } 
    
    public  ResultSet consultarPrestamos (int idPrestamo) throws SQLException{
            Connection  con;
            con=conectar();
            PreparedStatement consPrestamos=con.prepareStatement("SELECT `idPrestamo`,`codLibro`,`codCliente`,`codEmpleado`,`fechaPedido`,`fechaEntrega` FROM `mprestamo` WHERE `idPrestamo`='"+idPrestamo+"'");//se borro la fecha de contratacion
            ResultSet res = consPrestamos.executeQuery();
            //con.close();
            return res;
    }


    /**
     * @return the idPrestamo
     */
    public int getIdPrestamo() {
        return idPrestamo;
    }

    /**
     * @param idPrestamo the idPrestamo to set
     */
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    /**
     * @return the codCliente
     */
    public int getCodCliente() {
        return codCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    /**
     * @return the codEmpleado
     */
    public int getCodEmpleado() {
        return codEmpleado;
    }

    /**
     * @param codEmpleado the codEmpleado to set
     */
    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    /**
     * @return the codLibro
     */
    public int getCodLibro() {
        return codLibro;
    }

    /**
     * @param codLibro the codLibro to set
     */
    public void setCodLibro(int codLibro) {
        this.codLibro = codLibro;
    }

    /**
     * @return the fechaPedido
     */
    public String getFechaPedido() {
        return fechaPedido;
    }

    /**
     * @param fechaPedido the fechaPedido to set
     */
    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    /**
     * @return the fechaEntrega
     */
    public String getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * @param fechaEntrega the fechaEntrega to set
     */
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}