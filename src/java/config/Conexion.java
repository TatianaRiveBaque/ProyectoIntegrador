/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;




    public class   Conexion {
        Connection con;
        String login ="SYSTEM";
        String clave ="0401";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";  
    
        public Connection Conexion(){
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url,login,clave);
        } catch (Exception e) {
        }
            return con ;
        }
}
    

