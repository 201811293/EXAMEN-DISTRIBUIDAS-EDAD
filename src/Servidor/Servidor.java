    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;


import java.net.*; 
import java.io.*;
/**
 *
 * @author Daniel-PC
 */
public class Servidor {
    public static void main(String argv[]) {
        
     ServerSocket socket;
     
     boolean fin = false;
     try {
         
        socket = new ServerSocket(3000);
        
        Socket socket_cli = socket.accept();

        DataInputStream in =new DataInputStream(socket_cli.getInputStream());

        String mensaje ="";
            
        mensaje = in.readUTF();

        System.out.println("Recibiendo mensaje: "+mensaje);

        socket.close();
     }

     catch (Exception e) {
        System.err.println(e.getMessage());
        System.exit(1);
     }
  }
}
