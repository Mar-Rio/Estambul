/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS.BDA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian Pardo Moreno
 */
public class ConexionBDA {

    public static Connection conn; 
  
    public static boolean conectarBDA() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/packsturisticos?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "1234");
        return conn != null;
    }

    public boolean desconectar() throws SQLException {
        boolean cerrada = false;
        conn.close();
        return conn == null;
    }
}
