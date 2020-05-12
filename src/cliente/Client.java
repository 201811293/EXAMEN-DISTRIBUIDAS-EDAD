/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.util.Scanner;
import java.net.*;
import java.io.*;
import cliente.DatosUsuario;
import java.text.ParseException;


public class Client {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese Apellido: ");
        String apellido = sc.nextLine();
        System.out.println("ingrese año de nacimiento madd/MM/yyyy: ");
        String fecha = sc.nextLine();
        
        
        DatosUsuario persona1 = new DatosUsuario(nombre, apellido, fecha);
        
        System.out.println( "revise el servidor   :"+persona1.MensajeCliente());
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Socket socket;
        
        byte[] mensaje_bytes = new byte[256];
        
        try {
            socket = new Socket("127.0.0.1",3000);
            
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            out.writeUTF(persona1.MensajeParaElServidor());
            

            out.close();
            socket.close();
         }catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
         }
        
    }
}
