package sockets_tcp.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import service_handler.Service;

//import java.util.Scanner;


public class ServidorTCPConcorrente {

    public final static int DEFAULT_PORT = 5025; 
    
    
    public static void main(String[] args) 
    {
        int port = DEFAULT_PORT; 

        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e) {
                System.err.println("Erro no porto indicado");
            }
        }
        
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);

            Socket newSock    = null;

            for( ; ; ) {
                System.out.println("Servidor TCP concorrente aguarda ligacao no porto " + port + "..." );

                
                // Espera connect do cliente
                // asda
                newSock = serverSocket.accept(); 
                Thread th = new Service(newSock);
                th.start();
            } 
        } 
        catch (IOException e) {
            System.err.println("Excep��o no servidor: " + e);
        }
    } // end main

} // end ServidorTCP

