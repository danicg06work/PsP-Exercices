import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ping {
    public static void main(String[] args) {
        try {
        
            ProcessBuilder pb = new ProcessBuilder("ping", "-n", "4", "8.8.8.8");
            Process proceso = pb.start();

            // El padre espera a que el hijo termine
            int exitCode = proceso.waitFor();
            System.out.println("El hijo terminó con código: " + exitCode);

            // Mostrar salida del proceso
            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

