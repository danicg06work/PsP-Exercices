

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowDir {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Me tienes que pasar la ruta absoluta del directorio");
        }

        String comando = "cmd.exe /c dir " + args[0];
        Runtime runtime = Runtime.getRuntime();

        try {
            Process p1 = runtime.exec(comando);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(p1.getInputStream()));

            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            
           int exitCode = p1.waitFor();

            

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}