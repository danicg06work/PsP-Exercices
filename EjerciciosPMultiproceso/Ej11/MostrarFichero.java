package Ej11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MostrarFichero {
    public static void main(String[] args) {
        if(args.length == 0){
            throw new IllegalArgumentException("Me tiene que pasar una ruta relativa o absoluta correcta del archivo que queires escanear");
        }
        String rutaFichero = args[0];
        try {
            ProcessBuilder p1 = new ProcessBuilder("cmd.exe", "/c", "type", rutaFichero);
            Process p = p1.start();
            int error = p.waitFor();
            if(error!=0){
                System.out.println("Error al ejecutar el proceso con numero: "+ error +"\n posiblemente sea la ruta que le has pasado");
            }
            BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while ((linea = bfr.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (InterruptedException |IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
    }    
}
    
