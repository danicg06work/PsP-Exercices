

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteOutput {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Me tienes que pasar la ruta absoluta del directorio");
        }

        String comando = "cmd.exe /c type " + args[0];
        Runtime runtime = Runtime.getRuntime();

        try {
            Process p1 = runtime.exec(comando);
            String direccionFichero = "fichero2.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(direccionFichero));
            BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));

            System.out.println(reader);
            String linea;
             while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
                //  Aqui uso ahora el file writer
                writer.write(linea);
                writer.newLine(); 
            }
            
           int exitCode = p1.waitFor();
            //Ahora me acuredo que dijistes qeu habia que era recomendable cerrarlos>
            reader.close();
            writer.close();


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}