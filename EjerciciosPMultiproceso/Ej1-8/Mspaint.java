

import java.io.IOException;

public class Mspaint {
    //Esta clase ejecuta el paint 
   public static void main(String[] args) {
    String comando = "mspaint";
    Runtime runtime = Runtime.getRuntime();
    try {
        Process p1 = runtime.exec(comando);
    } catch (IOException e) {
        e.printStackTrace();
        }
    }
    
}
