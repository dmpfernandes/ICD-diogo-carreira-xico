package sockets_tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import messages.RegistrationRequest;
import messages.RegistrationResponse;



public class ClienteSimplesTCP {

    public final static String DEFAULT_HOSTNAME = "localhost";
    
    public final static int DEFAULT_PORT = 5025; 
    private static Socket socket = null;
    private static BufferedReader is = null;
    private static PrintWriter os = null;
    
    public static void main(String[] args) {

        String host = DEFAULT_HOSTNAME;  // M�quina onde reside a aplica��o servidora
        int    port = DEFAULT_PORT;      // Porto da aplica��o servidora

        
        if (args.length > 0) {
            host = args[0];
        }
        
        if (args.length > 1) {
            try {
                port = Integer.parseInt(args[1]);
                if (port < 1 || port > 65535) port = DEFAULT_PORT;
            }
            catch (NumberFormatException e) {
                System.err.println("Erro no porto indicado");
            }
        }
        
        
        System.out.println("-> " + host + ":" + port );
        

        
        try {
            socket = new Socket(host, port);

            // Mostrar os parametros da liga��o
            System.out.println("Ligação: " + socket);

            // Stream para escrita no socket
            os = new PrintWriter(socket.getOutputStream(), true); 

            // Stream para leitura do socket
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            printMenu();

            
            
        } 
        catch (IOException e) {
            System.err.println("Erro na liga��o " + e.getMessage());   
        }
        finally {
            // No fim de tudo, fechar os streams e o socket
            try {
                if (os != null) os.close();
                if (is != null) is.close();
                if (socket != null ) socket.close();
            }
            catch (IOException e) { 
                // if an I/O error occurs when closing this socket
            }
        } // end finally


    } // end main
    
    
    private static void printMenu() {
    	Scanner sc = new Scanner(System.in);
    	initialMenu();
    	int state = sc.nextInt();
    	switch (state) {
		case 1:
			registrationMenu(sc);
			break;
		case 2:
			
			break;
		default:
			break;
		}
    	
    }
    
    private static void initialMenu() {
    	System.out.println("**********************");
    	System.out.println("*         Menu       *");
    	System.out.println("* 1 - Registration   *");
    	System.out.println("* 2 - Login          *");
    	System.out.println("**********************");
    }
    
    private static void registrationMenu(Scanner sc) {
    	
    	System.out.println("**********************");
    	System.out.println("*    Registration    *");
    	System.out.println("*  Name              *");
    	String name = sc.next();
    	System.out.println("*  Username          *");
    	String username = sc.next();
    	System.out.println("*  Email             *");
    	String email = sc.next();
    	System.out.println("*  Date of Birth     *");
    	String dob = sc.next();
    	System.out.println("*  Password          *");
    	String pass = sc.next();
    	System.out.println("**********************");
    	
    	JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance( RegistrationRequest.class );
			Marshaller jaxbMarshaller   = jaxbContext.createMarshaller();
			RegistrationRequest request = new RegistrationRequest();
			request.setName(name);
			request.setUsername(username);
			request.setEmail(email);
			request.setDateOfBirth(dob);
			request.setPassword(pass);
	    	StringWriter sw = new StringWriter();
	    	jaxbMarshaller.marshal(request, sw);
	    	String xmlString = sw.toString();
	    	post(xmlString);
	    	String response = get();
	    	jaxbContext = JAXBContext.newInstance( RegistrationResponse.class );
	    	Unmarshaller jaxbUnmarshaller   = jaxbContext.createUnmarshaller();
	    	
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public static void post(String out) {
		// Escreve no socket
        os.println(out);
	}
	
	public static void clear() {
		os.flush();
	}
	
	public static String get() {
		String in = "";
		try { in = (String) is.readLine(); }
		catch (IOException e) {}
		return in;
	}
	
	public static void closeChannel() {
		try {
			os.close(); 
			is.close();
			socket.close();
		}
		catch (IOException e) { 
			 e.printStackTrace(); 
		}
	}
    
    

} // end ClienteSimplesTCP



