import java.io.*;

public class CopiaFichero {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Uso: java CopiaFichero <nombreFichero>");
            return;
        }

        String nombreFichero = args[0];
        File archivoEntrada = new File(nombreFichero);

        if (!archivoEntrada.exists()) {
            System.out.println("El fichero no existe: " + nombreFichero);
            return;
        }
        String nombreSalida;
        if (nombreFichero.contains(".")) {
            int punto = nombreFichero.lastIndexOf(".");
            nombreSalida = nombreFichero.substring(0, punto) + "_1" + nombreFichero.substring(punto);
        } else {
            nombreSalida = nombreFichero + "_1";
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nombreSalida))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

            System.out.println("Copia creada: " + nombreSalida);

        } catch (IOException e) {
            System.out.println("Error al procesar el fichero: " + e.getMessage());
        }
    }
}