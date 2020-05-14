package sockets_tcp.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
                newSock = serverSocket.accept(); 

                Thread th = new HandleConnectionThread(newSock);
                th.start();
            }
        } 
        catch (IOException e) {
            System.err.println("Excep��o no servidor: " + e);
        }
    } // end main

} // end ServidorTCP



class HandleConnectionThread extends Thread {

    private Socket connection;
    private BufferedReader is = null;
    private PrintWriter os    = null;

    public HandleConnectionThread(Socket connection) {
        this.connection = connection;
    }


    public void run() {

        

        try {
            // circuito virtual estabelecido: socket cliente na variavel newSock
            System.out.println("Thread " + this.getId() + ": " + connection.getRemoteSocketAddress());

            is = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            os = new PrintWriter(connection.getOutputStream(), true);

            String inputLine = is.readLine(); 
            Service s = new Service();
            Thread t = new Thread(s);
     
        }
        catch (IOException e) {
            System.err.println("erro na liga�ao " + connection + ": " + e.getMessage());
        }
        finally {
            // garantir que o socket � fechado
            try {
                if (is != null) is.close();  
                if (os != null) os.close();

                if (connection != null) connection.close();                    
            } catch (IOException e) { } 
        }
    } // end run
    
    public void post(String out) {
		// Escreve no socket
        os.println(out);
	}
	
	public void clear() {
		os.flush();
	}
	
	public String get() {
		String in = "";
		try { in = (String) is.readLine(); }
		catch (IOException e) {}
		return in;
	}
	
	public void closeChannel() {
		try {
			os.close(); 
			is.close();
			connection.close();
		}
		catch (IOException e) { 
			 e.printStackTrace(); 
		}
	}

} // end HandleConnectionThread
