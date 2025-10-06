package Propuesto2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calcular {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String operacion = bfr.readLine().trim();

            // Validar entrada con espacios
            if(!operacion.matches("^\\s*[+\\-*/]\\s+[0-9]+\\s+[0-9]+\\s*$")){
                throw new Exception("Error en la cadena recibida");
            }

            // Separar operador y números
            String[] coleccionOperacion = operacion.split("\\s+");
            String operador = coleccionOperacion[0];
            double n1 = Double.parseDouble(coleccionOperacion[1]);
            double n2 = Double.parseDouble(coleccionOperacion[2]);

            // Realizar cálculo
            switch (operador) {
                case "+":
                    System.out.println(n1 + n2);
                    break;
                case "-":
                    System.out.println(n1 - n2);
                    break;
                case "*":
                    System.out.println(n1 * n2);
                    break;
                case "/":
                    if (n2 != 0) {
                        System.out.println(n1 / n2);
                    } else {
                        System.out.println("Error: división por cero");
                    }
                    break;
                default:
                    System.out.println("Operador no válido: " + operador);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
