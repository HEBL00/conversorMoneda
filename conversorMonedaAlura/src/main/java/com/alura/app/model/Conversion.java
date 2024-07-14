package com.alura.app.model;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Conversion {
    private String moneda;
    private String monedaEleccion;
    private double cantidad;
    private double tipoCambio;
    private LocalDateTime fecha;

    public Conversion(String moneda, String monedaEleccion, double cantidad,
                      double tipoCambio, LocalDateTime fecha) {
        this.moneda = moneda;
        this.monedaEleccion = monedaEleccion;
        this.cantidad = cantidad;
        this.tipoCambio = tipoCambio;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        // Formatear la fecha en una representación legible para el usuario
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaFormateada = fecha.format(formatter);

        // Construir la representación de cadena de la conversión
        return String.format("Conversion: De %s a %s, Cantidad: %.2f, Tasa de cambio: %.2f, Fecha: %s",
                moneda, monedaEleccion, cantidad, tipoCambio, fechaFormateada);
    }


    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMonedaEleccion() {
        return monedaEleccion;
    }

    public void setMonedaEleccion(String monedaEleccion) {
        this.monedaEleccion = monedaEleccion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
