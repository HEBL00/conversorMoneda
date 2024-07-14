package com.alura.app.vierw;

import com.alura.app.model.Monedas;

import java.util.Scanner;

public class SelecicionDeMoneda {
    private final Scanner scanner;

    public SelecicionDeMoneda() {
        this.scanner = new Scanner(System.in);
    }

    public String seleccionarDivisa(String[] divisas) {
        String mensajeError = "\n--- Opción no válida. ---\n\nPor favor, seleccione un número de la lista.\n";

        if (divisas != null) {
            while (true) {
                for (int i = 0; i < divisas.length; i++) {
                    System.out.println((i + 1) + ". " + Monedas.getNombre(divisas[i]));
                }
                System.out.print("\nElija el número de la opción deseada: ");
                String entrada = scanner.nextLine();

                try {
                    int opcion = Integer.parseInt(entrada);
                    if (opcion >= 1 && opcion <= divisas.length) {
                        return divisas[opcion - 1];
                    } else {
                        System.out.println(mensajeError);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(mensajeError);
                }
            }
        } else {
            // Manejar el caso sin argumentos
            System.out.println("No se proporcionaron divisas para seleccionar.");
            return null;
        }
    }
}
