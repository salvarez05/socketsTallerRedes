import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Cliente {
    public static void main(String argv[]) {
            Socket misocket;
            String serverName = "127.0.0.1";
            int serverport = 1100;
            try {
                misocket = new Socket(serverName, serverport);
                DataOutputStream numeros = new DataOutputStream(misocket.getOutputStream());
                Scanner teclado = new Scanner(System.in);
                System.out.println("Ingrese numero entero a elevar al cuadrado");
                int numero = teclado.nextInt();
                numeros.writeUTF(String.valueOf(numero));
                DataInputStream in = new DataInputStream(misocket.getInputStream());
                String numeroRecivido="";
                numeroRecivido=in.readUTF();
                int numeroPotenciado=Integer.parseInt(numeroRecivido);
                System.out.println(numeroPotenciado);
                misocket.close();
                System.out.println("Desconectado");

            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }
