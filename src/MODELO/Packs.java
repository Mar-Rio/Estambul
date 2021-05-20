/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.time.LocalDate;

/**
 *
 * @author Adrian Pardo Moreno
 */
public class Packs {

    private int idPack,
            numLinea,
            idActividad,
            numPlazas;
    private String nombreActividad;
    private double precioUnitario,
            precioTotal;
    private static int contador = 1;
    private LocalDate fechaInicio,
            fechaFin;

    public Packs(Actividades actividad, int numPlazas, LocalDate fechaInicio, LocalDate fechaFin) {
        numLinea = contador++;
        this.numPlazas = numPlazas;
        precioUnitario = actividad.getPrecio();
        precioTotal = precioUnitario * numPlazas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        nombreActividad = actividad.getNombre();
        idActividad = actividad.getId();
    }
    @Override
    public String toString() {
        return numLinea + "." + nombreActividad + " de " + precioTotal + " euros.";
    }
    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(Actividades actividad) {
        nombreActividad = actividad.getNombre();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Actividades actividad) {
        this.precioUnitario = actividad.getPrecio();
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Actividades actividad) {
        this.precioTotal = precioUnitario * numPlazas;
    }

    public int getIdPack() {
        return idPack;
    }

    public void setIdPack(int idPack) {
        this.idPack = idPack;
    }

    public int getNumLinea() {
        return numLinea;
    }

    public void setNumLinea(int numLinea) {
        this.numLinea = numLinea;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

}
