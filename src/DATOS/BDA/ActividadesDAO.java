/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS.BDA;

import static DATOS.BDA.ConexionBDA.conn;
import MODELO.Actividades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian Pardo Moreno
 */
public class ActividadesDAO {

    private List<Actividades> actividadesDisponibles;

//Crea los objetos ActividadesDao y los almacena en List ActividadesDisponibles
    //Puede devolver dos SQLexcepciones: Fallo conexion y fallo en el select
    public boolean listarActividades() throws SQLException {
        boolean listado = false;
        actividadesDisponibles = new ArrayList<>();
        PreparedStatement ps = ConexionBDA.conn.prepareStatement("SELECT * FROM actividades",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Actividades actividad = new Actividades();
            actividad.setId(rs.getInt("id"));
            actividad.setNombre(rs.getString("nombre"));
            actividad.setDescripcion(rs.getString("descripcion"));
            actividad.setImagen(rs.getString("imagen"));
            actividad.setUrl(rs.getString("url"));
            actividad.setCalidad(rs.getString("calidad"));
            actividad.setTipo(nombreTipo(rs.getString("tipo")));
            actividad.setPrecio(rs.getInt("precio"));
            actividadesDisponibles.add(actividad);
        }
        listado = true;
        return listado;
    }

    //Devuelve las ActividadesDao por tipo
    public List<Actividades> actividadesTipo(String tipo) {
        List<Actividades> porTipo = new ArrayList<>();
        for (Actividades item : actividadesDisponibles) {
            if (item.getTipo().equalsIgnoreCase(tipo)) {
                porTipo.add(item);
            }
        }
        return porTipo;
    }

    //Almacena tipo por nombre, no por Id
    public String nombreTipo(String id) throws SQLException {
        PreparedStatement ps = ConexionBDA.conn.prepareStatement("SELECT nombre FROM tipos where codigo= ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        String nombre = "";
        while (rs.next()) {
            nombre = rs.getString("nombre");
        }
        return nombre;
    }

    public boolean borrar(int id) throws SQLException {
        boolean borrado = false;
        String sql = "DELETE FROM actividades WHERE id ='" + id + "";
        PreparedStatement ps = ConexionBDA.conn.prepareStatement(sql);
        int num_filas = ps.executeUpdate(sql);
        if (num_filas == 1) {
            borrado = true;
        }
        return borrado;
    }

    public int insertar(Actividades nuevaActividad) throws SQLException {
        int posicion = actividadesDisponibles.size() + 1;
        boolean insertado = false;
        String sql = "INSERT INTO actividades VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, posicion);
        ps.setString(2, nuevaActividad.getNombre());
        ps.setString(3, nuevaActividad.getDescripcion());
        ps.setString(4, nuevaActividad.getImagen());
        ps.setString(4, nuevaActividad.getUrl());
        ps.setString(5, nuevaActividad.getCalidad());
        ps.setString(6, nuevaActividad.getTipo());
        ps.setDouble(7, nuevaActividad.getPrecio());       
        return ps.executeUpdate();
    }
    
    public int update(Actividades actividad) throws SQLException {
        borrar(actividad.getId());
        return insertar(actividad);
        
    }

}
