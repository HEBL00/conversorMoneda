package com.alura.app.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ConversorTipoMoneda {

    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        return ConsumoAPI.getExchangeRate(baseCurrency, targetCurrency);
    }

    public double convertir(String divisaBase, String divisaObjetivo, double cantidad) {
        double monedaConversion = getExchangeRate(divisaBase, divisaObjetivo);
        return cantidad * monedaConversion;
    }

    public String formatearCantidad(double cantidad) {
        NumberFormat formato = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat formatoDecimal = (DecimalFormat) formato;
        formatoDecimal.applyPattern("#,##0.00");
        return formatoDecimal.format(cantidad);
    }
}

