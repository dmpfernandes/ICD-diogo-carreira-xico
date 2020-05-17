package service_handler;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import messages.LoginRequest;
import messages.LoginResponse;
import messages.RegistrationRequest;
import messages.RegistrationResponse;
import messages.RequestQuestionRequest;
import messages.RequestQuestionResponse;
import messages.ResultState;
import messages.SendAnswerRequest;
import messages.SendAnswerResponse;
import messages.StatsRequest;
import messages.StatsResponse;
import models.User;
import models.Users;
import models.XmlDB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.*;
import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Service extends Thread{
	
	private boolean stopSending = false;
	private Socket socket;
	private static HashMap<Integer, String> loggedUsers = new HashMap<Integer, String>();
	
	public Service(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		File xmlFile = new File("xml/xmlDB.xml");
		XmlDB xmlDatabase = unMarshallXmlDataBase(xmlFile);
		while(!stopSending) {
			String xmlString = get();
			Object requestObject = parseInputIntoDocument(xmlString);
			String requestName = requestObject.getClass().getName();
			switch(requestName) {
			case "RegistrationRequest":
				RegistrationResponse registrationResponse = registerNewUserIfPossible((RegistrationRequest)requestObject, xmlDatabase);
				String strRegistrationResponse = marshallRegistrationResponse(registrationResponse);

				post(strRegistrationResponse);
				break;
			case "LoginRequest":
				LoginResponse loginResponse = new LoginResponse();
				if(loginDataCorrect((LoginRequest) requestObject, xmlDatabase)) {
					 loginResponse = executeLogin((LoginRequest) requestObject, xmlDatabase);
				} else {
					ResultState resultState = generateResultState(404, "Wrong credentials or user is unregistered.");
					loginResponse.setResultState(resultState);
				}
				
				String strLoginResponse = marshallLoginResponse(loginResponse);
				post(strLoginResponse);
				break;
				
			}

		}
	}

	private String marshallRegistrationResponse(RegistrationResponse registrationResponse) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance( RegistrationResponse.class );
			Marshaller jaxbMarshaller;
			jaxbMarshaller = jaxbContext.createMarshaller();
			StringWriter sw = new StringWriter();
	    	jaxbMarshaller.marshal(registrationResponse, sw);
	    	return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String marshallLoginResponse(LoginResponse loginResponse) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance( LoginResponse.class );
			Marshaller jaxbMarshaller;
			jaxbMarshaller = jaxbContext.createMarshaller();
			StringWriter sw = new StringWriter();
	    	jaxbMarshaller.marshal(loginResponse, sw);
	    	return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private ResultState generateResultState(int state, String description) {
		ResultState resultState = new ResultState();
		resultState.setDescription(description);
		resultState.setState(state);
		return resultState;
	}
			
	private LoginResponse executeLogin(LoginRequest requestObject, XmlDB xmlDatabase) {
		Optional<User> optUser = getUserByUsername(requestObject.getUsername(), xmlDatabase);
		LoginResponse loginResponse = new LoginResponse();
		if(optUser.isPresent()) {
			User user = optUser.get();
			loggedUsers.put(getSessionNumberByUserID(user.getIdUser()) , user.getRole());
			
			loginResponse.setResultState(generateResultState(200, "Login Successful"));
		} else {
			loginResponse.setResultState(generateResultState(400, "Login Failed, user doesn't exist"));
		}
		
		return loginResponse;		
	}

	private Optional<User> getUserByUsername(String username, XmlDB xmlDatabase) {
		return xmlDatabase.getUsers().getUser().stream().filter(u -> u.getUsername().equals(username)).findFirst();
		
	}
	
	private Integer getSessionNumberByUserID(Byte idUser) {
		return null;
	}
	private boolean loginDataCorrect(LoginRequest requestObject, XmlDB xmlDatabase) {
		if(usernameExists(requestObject.getUsername(), xmlDatabase)) {
			if(correctPassword(requestObject, xmlDatabase)) {
				return true;
			}
		}
		return false;
	}

	private boolean correctPassword(LoginRequest requestObject, XmlDB xmlDatabase) {
		Optional<User> user = getUserByUsername(requestObject.getUsername(), xmlDatabase);
		if(user.isPresent()) {
			boolean success = (user.get().getPassword().equals(requestObject.getPassword()) ? true : false);
			return success;
		} else return false;
	}

	private boolean usernameExists(String username, XmlDB xmlDatabase) {
		long count = xmlDatabase.getUsers().getUser().stream().filter(u -> u.getUsername().equals(username)).count();
		if(count == 1L) {
			return true;
		} else return false;
	}

	private XmlDB unMarshallXmlDataBase(File xmlFile) {		
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);  
			Node node = document.getDocumentElement().cloneNode(true);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlDB.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        XmlDB request= (XmlDB) jaxbUnmarshaller.unmarshal(node);  
	        
	        return request;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private RegistrationResponse registerNewUserIfPossible(RegistrationRequest request, XmlDB xmlDatabase) {
		RegistrationResponse response = new RegistrationResponse();
		if(canRegisterUser(request, xmlDatabase)) {
			addNewUser(request, xmlDatabase);
			response.setResultState(generateResultState(200, "Registration complete!"));
		} else {
			response.setResultState(generateResultState(400, "Validation failed, please try again."));
		}
		return response;
	}
	
	private boolean canRegisterUser(RegistrationRequest request, XmlDB xmlDatabase) {
		Users users = xmlDatabase.getUsers();
		if(users.getUser().stream().filter(u -> u.getUsername().equals(request.getUsername())).count() == 0) {
			return true;
		} else return false;
	}
	
	private void addNewUser(RegistrationRequest request, XmlDB xmlDatabase) {
		Users users = xmlDatabase.getUsers();
		User newUser = new User();
		newUser.setBirthDate(request.getDateOfBirth());
		newUser.setName(request.getName());
		newUser.setEmail(request.getEmail());
		newUser.setPassword(request.getPassword());
		newUser.setIdUser();
		newUser.setUsername(request.getUsername());
		if(request.getEmail().contains("alunos")) {
			newUser.setRole("student");
		} else if(request.getEmail().contains("docentes")) {
			newUser.setRole("teacher");
		}

		users.getUser().add(newUser);
		xmlDatabase.setUsers(users);
		
	}

	

	private Object parseInputIntoDocument(String xmlString) throws Exception {
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
		Document document = documentBuilder.parse(xmlString);  
		Node node = document.getDocumentElement().cloneNode(true);
		switch(document.getDocumentElement().getNodeName()) {
		case "registration":
			return unMarshallRegistrationRequest(node);
		case "requestQuestionRequest":
			return unMarshallRequestQuestionRequest(node);
		case "requestQuestionResponse":
			return unMarshallRequestQuestionResponse(node);
		case "sendAnswerRequest":
			return unMarshallSendAnswerRequest(node);
		case "sendAnswerResponse":
			return unMarshallSendAnswerResponse(node);
		case "statsRequest":
			return unMarshallStatsRequest(node);
		case "statsResponse":
			return unMarshallStatsResponse(node);
		default:
			return null;
		}
	}

	private StatsResponse unMarshallStatsResponse(Node node) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(StatsResponse.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        StatsResponse request= (StatsResponse) jaxbUnmarshaller.unmarshal(node);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private StatsRequest unMarshallStatsRequest(Node node) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(StatsRequest.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        StatsRequest request= (StatsRequest) jaxbUnmarshaller.unmarshal(node);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private SendAnswerResponse unMarshallSendAnswerResponse(Node node) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(SendAnswerResponse.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        SendAnswerResponse request= (SendAnswerResponse) jaxbUnmarshaller.unmarshal(node);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private SendAnswerRequest unMarshallSendAnswerRequest(Node node) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(SendAnswerRequest.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        SendAnswerRequest request= (SendAnswerRequest) jaxbUnmarshaller.unmarshal(node);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private RequestQuestionResponse unMarshallRequestQuestionResponse(Node node) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(RequestQuestionResponse.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        RequestQuestionResponse request= (RequestQuestionResponse) jaxbUnmarshaller.unmarshal(node);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private RequestQuestionRequest unMarshallRequestQuestionRequest(Node node) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(RequestQuestionRequest.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        RequestQuestionRequest request= (RequestQuestionRequest) jaxbUnmarshaller.unmarshal(node);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private RegistrationRequest unMarshallRegistrationRequest(Node node) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(RegistrationRequest.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        RegistrationRequest request= (RegistrationRequest) jaxbUnmarshaller.unmarshal(node);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	public boolean isStopSending() {
		return stopSending;
	}

	public void setStopSending(boolean stopSending) {
		this.stopSending = stopSending;
	}
	
	
}
