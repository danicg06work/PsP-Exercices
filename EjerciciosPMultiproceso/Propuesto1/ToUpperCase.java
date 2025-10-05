package Propuesto1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToUpperCase {
    public static void main(String[] args) {
         try (BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in))) {
            String linea;
            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
