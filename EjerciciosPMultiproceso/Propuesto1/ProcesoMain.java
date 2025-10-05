package Propuesto1;

import java.io.*;
import java.util.Scanner;

public class ProcesoMain {
    public static void main(String[] args) {
        try {
            // Compilo la otra calse
            ProcessBuilder p1b = new ProcessBuilder("javac", "multiprocesoConJava/ToUpperCase.java");
            Process p1 = p1b.start();
            int exitCode = p1.waitFor();
            if (exitCode != 0) {
                System.err.println("error al compialr");
                return;
            }

            
            ProcessBuilder p2b = new ProcessBuilder("java", "multiprocesoConJava.ToUpperCase");
            p2b.redirectErrorStream(true); 
            Process p2 = p2b.start();

            // comunicación
            PrintWriter pw = new PrintWriter(p2.getOutputStream(), true);
            BufferedReader entradaFormateada =
                    new BufferedReader(new InputStreamReader(p2.getInputStream()));

            // Pedir línea al usuario
            System.out.println("Dame una linea:");
            Scanner sc = new Scanner(System.in);
            String linea = sc.nextLine();

            // Mandar al hijo
            pw.println(linea);

            //  Leer respuesta
            String respuesta = entradaFormateada.readLine();
            System.out.println("Me has dado: " + linea);
            System.out.println("Aquí lo tienes en mayúsculas: " + respuesta);

            // Cerrar 
            pw.close();
            entradaFormateada.close();
            p2.destroy();
            sc.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
