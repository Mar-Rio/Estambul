/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS.BDA;

import static DATOS.BDA.ConexionBDA.conn;
import MODELO.Actividades;
import MODELO.Packs;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian Pardo Moreno
 */
public class PacksDAO {

    private List<Packs> actividadesEnPack = new ArrayList<>();
//Devuelve 2 SQLexceptions: Fallo conexion y fallo insert
//Para cuando una actividad esté seleccionada y tenga las plazas y fechas. 
    //Se inserta en tabla detalle_pack y se guarda un objeto PacksDao en actividadesEnPack.

    public List<Packs> getActividadesEnPack() {
        return actividadesEnPack;
    }

    public void setActividadesEnPack(List<Packs> actividadesEnPack) {
        this.actividadesEnPack = actividadesEnPack;
    }

    public void guardarActividadEnPack(Actividades actividad, int plazas, LocalDate inicio,
            LocalDate fin) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO detalle_packs VALUES (?,?,?,?,?)");
        ps.setInt(1, actividad.getId());
        ps.setInt(2, plazas);
        ps.setDate(3, Date.valueOf(inicio));
        ps.setDate(4, Date.valueOf(fin));
        Packs nuevaActividad = new Packs(actividad, plazas, inicio, fin);
        actividadesEnPack.add(nuevaActividad);
    }
    
    public void borrarActividad(int indice) {
       actividadesEnPack.remove(indice);
    }
}
