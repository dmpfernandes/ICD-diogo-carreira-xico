package sockets_tcp.client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import messages.LoginRequest;
import messages.LoginResponse;
import messages.RegistrationRequest;
import messages.RegistrationResponse;
import messages.ResultState;



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
//        finally {
//            // No fim de tudo, fechar os streams e o socket
//            try {
//                if (os != null) os.close();
//                if (is != null) is.close();
//                if (socket != null ) socket.close();
//            }
//            catch (IOException e) { 
//                // if an I/O error occurs when closing this socket
//            }
//        } // end finally


    } // end main
    
    
    private static void printMenu() {
    	Scanner sc = new Scanner(System.in);
    	initialMenu();
    	int state = sc.nextInt();
    	boolean run = true;
    	while(run) {
	    	switch (state) {
			case 1:
				registrationMenu(sc,state);
				break;
			case 2:
				loginMenu(sc,state);
				break;
			case 3:
				teacherMenu(sc,state);
				break;
			case 4:
//				studentMenu(sc,state);
				break;
			case 5:
				addQuestionMenu(sc,state);
				break;
			case 6:
//				sendQuestionMenu(sc,state);
				break;
			case 7:
//				statsMenu(sc,state);
				break;
			default:
				break;
			}
    	}
    	
    }
    
    private static void initialMenu() {
    	System.out.println("**********************");
    	System.out.println("*         Menu       *");
    	System.out.println("* 1 - Registration   *");
    	System.out.println("* 2 - Login          *");
    	System.out.println("**********************");
    }
    
    private static void registrationMenu(Scanner sc, int state) {
    	
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
	    	Element node;
			try {
				node = DocumentBuilderFactory
					    .newInstance()
					    .newDocumentBuilder()
					    .parse(new ByteArrayInputStream(response.getBytes()))
					    .getDocumentElement();
				
				RegistrationResponse objResponse = (RegistrationResponse) jaxbUnmarshaller.unmarshal(node);
				resultMenu(objResponse.getResultState());
				if(objResponse.getResultState().getState()== 200) {
					state = 2;
				}
				
			} catch (SAXException | IOException | ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    private static void loginMenu(Scanner sc, int state) {
    	System.out.println("**********************");
    	System.out.println("*        Login       *");
    	System.out.println("*  Username          *");
    	String username = sc.next();
    	System.out.println("*  Password          *");
    	String pass = sc.next();
    	System.out.println("**********************");
    	JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance( LoginRequest.class );
			Marshaller jaxbMarshaller   = jaxbContext.createMarshaller();
			LoginRequest request = new LoginRequest();
			request.setUsername(username);
			request.setPassword(pass);
	    	StringWriter sw = new StringWriter();
	    	jaxbMarshaller.marshal(request, sw);
	    	String xmlString = sw.toString();
	    	post(xmlString);
	    	String response = get();
	    	jaxbContext = JAXBContext.newInstance( LoginResponse.class );
	    	Unmarshaller jaxbUnmarshaller   = jaxbContext.createUnmarshaller();
	    	Element node;
			try {
				node = DocumentBuilderFactory
					    .newInstance()
					    .newDocumentBuilder()
					    .parse(new ByteArrayInputStream(response.getBytes()))
					    .getDocumentElement();
				
				LoginResponse objResponse = (LoginResponse) jaxbUnmarshaller.unmarshal(node);
				resultMenu(objResponse.getResultState());
				if(objResponse.getResultState().getState() == 200) {
					if(objResponse.getRole().equals("teacher")) {
						state = 3;
					}else {
						state = 4;
					}
				}
			} catch (SAXException | IOException | ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private static void teacherMenu(Scanner sc, int state) {
    	System.out.println("**********************");
    	System.out.println("*        Menu        *");
    	System.out.println("* 1- + Pergunta      *");
    	System.out.println("* 2- Envia Pergunta  *");
    	System.out.println("* 3- Estatisticas    *");
    	System.out.println("**********************");
    	
    	int choice = sc.nextInt();
    	switch (choice) {
		case 1:
			state = 5;
			break;
		case 2:
			state = 6;
			break;
		case 3:
			state = 7;
			break;
		default:
			break;
		}
    	
    	
    }
    
    private static void addQuestionMenu(Scanner sc, int state) {
    	
    	System.out.println("**********************");
    	System.out.println("* Adicionar Pergunta *");
    	System.out.println("*1-Corpo da pergunta *");
    	String question = sc.next();
    	System.out.println("*2-Nº de Respostas   *");
    	int numOfAnswers = sc.nextInt();
    	List<String> answers = new ArrayList<String>();
    	for (int i = 0; i < numOfAnswers; i++) {
    		System.out.println("*"+i+1+"- Resposta     *");
    		answers.add(sc.next());
    		System.out.println("* - Validade     *");
    		answers.add(sc.next());
		}
    	System.out.println("**********************");
    	
    	
    	
    }
    
    private static void resultMenu(ResultState obj) {
    	System.out.println("**********************");
    	System.out.println("*       Result       *");
    	System.out.println("*    	"+obj.getState()+"      *");
    	System.out.println("*       "+obj.getDescription()+"      *");
    	System.out.println("**********************");
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



