/*
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
 
package br.ufs.dcomp.ExemploTcpJava;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            
            String msg = "Olá, DCOMP!!!";
            
            byte[] bufOut = msg.getBytes(); // Obtendo a representação em bytes da mensagem

            System.out.print("[ Enviando mensagem    ..............................  ");
            os.write(bufOut);
            System.out.println("[OK] ]");
            
            byte[] bufIn = new byte[20];
            
            System.out.print("[ Aguardando resposta     ..............................  ");
            is.read(bufIn);
            System.out.println("[OK] ]");
            
            String response = new String(bufIn);
            System.out.println("  Resposta recebida: " + response);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
        System.out.println("[ FIM ]");
    }
}