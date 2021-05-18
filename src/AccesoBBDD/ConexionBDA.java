/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS.BDA;

import MODELO.Actividades;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian Pardo Moreno
 */
public class ConexionBDA {

    static private Connection conn;
    private List<ActividadesDAO> actividadesDisponibles;
    private List<PacksDAO> actividadesEnPack  = new ArrayList<>();

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
//Crea los objetos ActividadesDao y los almacena en List ActividadesDisponibles
    //Puede devolver dos SQLexcepciones: Fallo conexion y fallo en el select

    public boolean listarActividades() throws SQLException {
        boolean listado = false;
        actividadesDisponibles = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM actividades",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ActividadesDAO actividad = new ActividadesDAO();
            actividad.setId(rs.getInt("id"));
            actividad.setNombre(rs.getString("nombre"));
            actividad.setDescripcion(rs.getString("descripcion"));
            actividad.setImagen(rs.getString("imagen"));
            actividad.setCalidad(rs.getString("calidad"));
            actividad.setTipo(nombreTipo(rs.getString("tipo")));
            actividad.setPrecio(rs.getInt("precio"));
            actividadesDisponibles.add(actividad);
        }
        listado = true;
        return listado;
    }

    //Devuelve las ActividadesDao por tipo
    public List<ActividadesDAO> actividadesTipo(String tipo) {
        List<ActividadesDAO> porTipo = new ArrayList<>();
        for (ActividadesDAO item : actividadesDisponibles) {
            if (item.getTipo().equalsIgnoreCase(tipo)) {
                porTipo.add(item);
            }
        }
        return porTipo;
    }

    //Almacena tipo por nombre, no por Id
    public String nombreTipo(String id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT nombre FROM tipos where codigo= ?",
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
//Devuelve 2 SQLexceptions: Fallo conexion y fallo insert
//Para cuando una actividad esté seleccionada y tenga las plazas y fechas. 
    //Se inserta en tabla detalle_pack y se guarda un objeto PacksDao en actividadesEnPack.
    public void guardarActividadEnPack(int idActividad, int plazas, LocalDate inicio,
            LocalDate fin) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO detalle_packs VALUES (?,?,?,?,?)");
        ps.setInt(1, idActividad);
        ps.setInt(2, plazas);
        ps.setDate(3, Date.valueOf(inicio));
        ps.setDate(4, Date.valueOf(fin));
        PacksDAO nuevaActividad = new PacksDAO();
        nuevaActividad.setIdActividad(idActividad);
        nuevaActividad.setNumPlazas(plazas);
        nuevaActividad.setFechaInicio(inicio);
        nuevaActividad.setFechaFin(fin);
        actividadesEnPack.add(nuevaActividad);
    }
}
