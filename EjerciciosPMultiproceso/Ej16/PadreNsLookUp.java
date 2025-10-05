package Ej16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class PadreNsLookUp {
    public static void main(String[] args) {
        ProcessBuilder pb1 = new ProcessBuilder("nslookup");
        try {
            // Inicio proceso
            Process p1 = pb1.start();

            // Abro comunciaciones entre los procesos
            PrintWriter pw = new PrintWriter(p1.getOutputStream(), true);
            BufferedReader bfr = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            Scanner sc2 = new Scanner(System.in);

            // Ahora envio recibo al mismo momento
            System.out.println("Dime la direccion web o Ip, escriba exit para salir");
            String entrada;
            do {
                entrada = sc2.nextLine();
                pw.println(entrada);
                String salida;
                while (bfr.ready() && (salida = bfr.readLine()) != null) {
                    System.out.println(salida);
                }
            } while (entrada.equals("exit"));
            pw.close();
            bfr.close();
            sc2.close();
            p1.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
