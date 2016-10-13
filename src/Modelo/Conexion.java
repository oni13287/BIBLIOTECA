/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
        
/**
 *
 * @author Usuario
 */
public class Conexion {
    private final String url="jdbc:mysql://localhost:3306/biblioteca?zeroDateTimeBehavior=convertToNull";
    private final String usr="root";
    private final String clave="";
     
    public Connection conectar() throws SQLException{
        return DriverManager.getConnection(url, usr, clave);
    }
    
}
