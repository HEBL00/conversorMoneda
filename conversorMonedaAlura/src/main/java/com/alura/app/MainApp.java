package com.alura.app;

import com.alura.app.service.ConversorTipoMoneda;
import com.alura.app.vierw.SelecicionDeMoneda;
import com.alura.app.model.*;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Scanner;


public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SelecicionDeMoneda SELECICION_DE_MONEDA = new SelecicionDeMoneda();
    private static final ConversorTipoMoneda CONVERSOR_TIPO_MONEDA = new ConversorTipoMoneda();
    private static final HistorialConversiones historialConversiones = new HistorialConversiones();


    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            ejecutarConversion();
            continuar = preguntarContinuar();
        }

        System.out.println("\n Historial de las conversiones realizadas: ");
        historialConversiones.mostrarHistorial();

        despedida();
    }

    private static void ejecutarConversion() {
        String[] divisas = {Monedas.USD, Monedas.ARS, Monedas.EUR, Monedas.BRL, Monedas.MXN,
                Monedas.CNY, Monedas.CHF, Monedas.GBP, Monedas.JPY};

        String divisaBase = seleccionarDivisa("Selecciona la moneda a convertir:", divisas);
        String divisaObjetivo = seleccionarDivisa("Selecciona al tipo de moneda que de seas convertir " + divisaBase + " seleccionados:", divisas);
        double cantidad = leerCantidad("Caunto quieres convertir " + divisaBase + " a " +
                divisaObjetivo);
        double montoConvertido = CONVERSOR_TIPO_MONEDA.convertir(divisaBase, divisaObjetivo, cantidad);
        mostrarResultado(divisaBase, divisaObjetivo, cantidad, montoConvertido);

        Conversion conversion = new Conversion(divisaBase, divisaObjetivo, cantidad, CONVERSOR_TIPO_MONEDA.getExchangeRate(divisaBase, divisaObjetivo),
                LocalDateTime.now());
        historialConversiones.agregarConversion(conversion);
    }

    private static String seleccionarDivisa(String mensaje, String[] divisas) {
        System.out.println(mensaje);
        return SELECICION_DE_MONEDA.seleccionarDivisa(divisas);
    }

    private static double leerCantidad(String mensaje) {
        System.out.println(mensaje);
        String input = scanner.nextLine();

        while (!input.matches("\\d+")) {
            System.out.println("Por favor, ingrese un valor válido sin puntos ni comas.");
            input = scanner.nextLine();
        }

        return Double.parseDouble(input);
    }

    private static void mostrarResultado(String divisaBase, String divisaObjetivo, double cantidad, double montoConvertido) {
        DecimalFormat formato = new DecimalFormat("#.##");
        String cantidadFormateada = formato.format(cantidad);
        String montoFormateado = formato.format(montoConvertido);

        System.out.println("El resultado de convertir " + cantidadFormateada + " " +
                divisaBase + " a " + divisaObjetivo + " es: " + montoFormateado);
    }

    private static boolean preguntarContinuar() {
        System.out.println("realisar otra conversion ");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("s");
    }

    private static void despedida() {
        System.out.println("\n has usado el conversor, gracais");
    }
}

