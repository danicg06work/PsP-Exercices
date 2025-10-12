package PsPAPI.EjercicioMioInventado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Creo primero el fichero

        File resultados = new File("resultados.txt");
        try {
            resultados.createNewFile();
        } catch (IOException e) {
            System.out.println("Error al crear los ficheros");
            e.printStackTrace();
        }

        // Compilar procesos y ejecutarlos

        ProcessBuilder pb1 = new ProcessBuilder("javac", "EjercicioMioInventado\\CalcularMedia.java");
        ProcessBuilder pb3 = new ProcessBuilder("javac", "EjercicioMioInventado\\CalcularMediaGeneral.java");
        try {
            Process p1 = pb1.start();
            int codigoError = p1.waitFor();
            Process p3 = pb3.start();
            if (codigoError != 0) {
                System.out.println(" Error al compilar las clases java");
            }
            int codigoError2 = p3.waitFor();
            if (codigoError2 != 0) {
                System.out.println(" Error al compilar las clases java");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        int i = 1;
        while (i == 1 | i == 2) {
            System.out.println("Escribe 1 para meter numeros y sacar la media");
            System.out.println("Escribe 2 para  sacar la media general");
            System.out.println("Escribe cualquier otra numero para salir");
            Scanner scMenu = new Scanner(System.in);
            i = scMenu.nextInt();

            switch (i) {
                case 1:
                    // Ejecutar procesos en bucle y con switch

                    // Creo el procces builder y redirecciono su salida a resultados antes de
                    // emepzar(IMPORTANTE)
                    ProcessBuilder pb2 = new ProcessBuilder("java", "EjercicioMioInventado\\CalcularMedia.java");
                    try {
                        // Iincio el proceso y controlo errores
                        Process p2 = pb2.start();
                        // Pido los datos los numeros al usuario y compruebo que este bien, y los envio:
                        System.out.println("Dime las notas, me las tiene que hacer con estre formato: 7,8,3,6,9 . . .");
                        Scanner sc = new Scanner(System.in);
                        String numeros = sc.nextLine();
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));
                        writer.write(numeros);
                        writer.newLine();
                        writer.flush();
                        // Lo muestro la salida del cacular media en mi pantalla
                        int codigoError = p2.waitFor();
                        if (codigoError != 0) {
                            System.out.println(" Error al ejecutar las clases java " + codigoError);
                        }
                        BufferedReader bf = new BufferedReader(new InputStreamReader(p2.getInputStream()));
                        String salida = bf.readLine();
                        System.out.println("Resultado: "+salida);
                        FileWriter fl = new FileWriter(resultados, true);
                        fl.write(salida);
                        fl.write(",");
                        fl.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    ProcessBuilder pb4 = new ProcessBuilder("java", "EjercicioMioInventado\\CalcularMediaGeneral.java");
                    pb4.redirectInput(resultados);
                    try {
                        Process p4 = pb4.start();
                        BufferedReader bf = new BufferedReader(new InputStreamReader(p4.getInputStream()));
                        p4.waitFor();
                        System.out.println("Media general: " +bf.readLine());
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    break;
                default:
                    break;
            }
        }

    }

}