

package Ej13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedireccionLs {
    public static void main(String[] args) {
        if(args.length == 0){
            throw new IllegalArgumentException("Me tiene que pasar una ruta relativa o absoluta correcta del archivo que queires escanear");
        }
        String rutaFichero = args[0];
        ProcessBuilder p1 = new ProcessBuilder("cmd.exe", "/C", "dir", rutaFichero);
        try {
            Process p = p1.start();
            int error = p.waitFor();
            if (error != 0) {
                System.out.println("Error en proceso con codigo: " + error);
            }

            //Lo meto dentro del parentesis para ahcer autoflush y autoclose
            try (BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedWriter bfw = new BufferedWriter(new FileWriter("salida.txt"));) {
                String linea;
                while ((linea = bfr.readLine()) != null) {
                    bfw.write(linea);
                    bfw.newLine();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
