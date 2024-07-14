package com.alura.app.model;

public class Monedas {
    public static final String USD = "USD";
    public static final String MXN = "MXN";
    public static final String ARS = "ARS";
    public static final String GBP = "GBP";
    public static final String EUR = "EUR";
    public static final String CNY = "CNY";
    public static final String CHF = "CHF";
    public static final String JPY = "JPY";
    public static final String BRL = "BRL";


    // Métodos para obtener el nombre de la divisa
    public static String getNombre(String codigo) {
        return switch (codigo) {
            case USD -> "USD - Dolar Estadounidense";
            case ARS -> "ARS - Peso Argentino";
            case EUR -> "EUR - Euro, Union Europea";
            case BRL -> "BRL - Real Brasileño";
            case MXN -> "MXN - Peso Mexicano";
            case CNY -> "CNY - Yuan Chino";
            case CHF -> "CHF - Franco Suizo";
            case GBP -> "GBP - Libra Esterlina";
            case JPY -> "JPY - Yen Japones";
            default -> "Desconocido";
        };
    }
}

