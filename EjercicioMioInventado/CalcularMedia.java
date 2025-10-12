package PsPAPI.EjercicioMioInventado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class CalcularMedia {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // Recogo la cadena
            String bruto = br.readLine();

            // La divido y sumo sus numeros
            String[] numeros = bruto.split(",");
            double suma = 0;
            for (String numero : numeros) {
                suma = suma + Double.parseDouble(numero);
            }
            
            // Calculo la media y la imprimo
            double media = suma / numeros.length;
            System.out.println(media);
        } catch (Exception e) {
            System.out.println("error en calularmedia.java");
        }
    }

}