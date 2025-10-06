package Propuesto2;

import java.io.*;
import java.util.Scanner;

public class PasarCalculo {
    public static void main(String[] args) {
        try {

       
            ProcessBuilder pb1 = new ProcessBuilder("javac", "EjerciciosPMultiproceso/Propuesto2/Calcular.java");
            Process p1 = pb1.start();
            int errorCode = p1.waitFor();
            if (errorCode != 0) {
                System.out.println("Error al compilar Calcular.java");
                return;
            }

            System.out.println("Dime la operación: (operador) (numero1) (numero2)");
            Scanner entradaUsuario = new Scanner(System.in);
            String operacion = entradaUsuario.nextLine();

            if (!operacion.matches("^\\s*[+\\-*/]\\s+[0-9]+\\s+[0-9]+\\s*$")) {
                throw new Exception("Error en la cadena introducida");
            }

          
            ProcessBuilder pb2 = new ProcessBuilder("java", "EjerciciosPMultiproceso.Propuesto2.Calcular");
            Process p2 = pb2.start();

    
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));
            bfw.write(operacion);
            bfw.newLine();
            bfw.flush();
            bfw.close();
            p2.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Resultado: " + linea);
            }
            br.close();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
