package ejercicios_psp.EjerciciosPMultiproceso.Propuesto3Examen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

public class MainPingFind {
    public static void main(String[] args) {
        //Hago el proccesbilder
        ProcessBuilder pb1 = new ProcessBuilder("cmd.exe", "/C", "ping www.google.es -n 2 | find \"ping\"");
        Process p1;
        try {
            //Agora creo el fichero y redirecciono la salida
            File fl = new File("salida.txt");
            fl.createNewFile();
            pb1.redirectOutput(fl);

            p1 = pb1.start();
            //Recogo posibles fallos
            int codigoError = p1.waitFor();
            if (codigoError != 0) {
                System.out.println("Error al ejecutar el codigo" + codigoError);
            }
            
            //Y mostramos lo del fichero
            System.setIn(new FileInputStream(fl));
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}