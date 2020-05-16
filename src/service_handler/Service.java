package service_handler;

import org.w3c.dom.*;

import messages.RegistrationRequest;
import messages.RegistrationResponse;
import messages.RequestQuestionRequest;
import messages.RequestQuestionResponse;
import messages.SendAnswerRequest;
import messages.SendAnswerResponse;
import messages.StatsRequest;
import messages.StatsResponse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.*;
import java.io.*;
import java.net.Socket;

public class Service extends Thread{
	
	private boolean stopSending = false;
	private Socket socket;
	
	public Service(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		while(!stopSending) {
			String xmlString = get();
			Object requestObject = parseInputIntoDocument(xmlString);
			
			if(requestObject.getClass().getn instanceof RegistrationRequest) {
				registerNewUserIfPossible((RegistrationRequest)requestObject);
			} else if() {
				
			}
		}
	}
			
	private void registerNewUserIfPossible(RegistrationRequest request) {
		if(canRegisterUser(request)) {
			addNewUser(request);
		}
	}

	private void addNewUser(RegistrationRequest request) {
		
	}

	private boolean canRegisterUser(RegistrationRequest request) {
		
		return false;
	}

	private Object parseInputIntoDocument(String xmlString) throws Exception {
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
		Document document = documentBuilder.parse(xmlString);  
		File file = new File(xmlString);
		switch(document.getDocumentElement().getNodeName()) {
		case "registration":
			return unMarshallRegistrationRequest(file);
		case "requestQuestionRequest":
			return unMarshallRequestQuestionRequest(file);
		case "requestQuestionResponse":
			return unMarshallRequestQuestionResponse(file);
		case "sendAnswerRequest":
			return unMarshallSendAnswerRequest(file);
		case "sendAnswerResponse":
			return unMarshallSendAnswerResponse(file);
		case "statsRequest":
			return unMarshallStatsRequest(file);
		case "statsResponse":
			return unMarshallStatsResponse(file);
		case "xmlDB":
			
		default:
			return null;
		}
	}

	private StatsResponse unMarshallStatsResponse(File file) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(StatsResponse.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        StatsResponse request= (StatsResponse) jaxbUnmarshaller.unmarshal(file);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private StatsRequest unMarshallStatsRequest(File file) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(StatsRequest.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        StatsRequest request= (StatsRequest) jaxbUnmarshaller.unmarshal(file);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private SendAnswerResponse unMarshallSendAnswerResponse(File file) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(SendAnswerResponse.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        SendAnswerResponse request= (SendAnswerResponse) jaxbUnmarshaller.unmarshal(file);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private SendAnswerRequest unMarshallSendAnswerRequest(File file) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(SendAnswerRequest.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        SendAnswerRequest request= (SendAnswerRequest) jaxbUnmarshaller.unmarshal(file);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private RequestQuestionResponse unMarshallRequestQuestionResponse(File file) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(RequestQuestionResponse.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        RequestQuestionResponse request= (RequestQuestionResponse) jaxbUnmarshaller.unmarshal(file);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private RequestQuestionRequest unMarshallRequestQuestionRequest(File file) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(RequestQuestionRequest.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        RequestQuestionRequest request= (RequestQuestionRequest) jaxbUnmarshaller.unmarshal(file);  
	        return request;
		} catch(JAXBException e) {
	        e.printStackTrace();
		}
		return null;
	}

	private RegistrationRequest unMarshallRegistrationRequest(File file) {
		try {  
	        JAXBContext jaxbContext = JAXBContext.newInstance(RegistrationRequest.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        RegistrationRequest request= (RegistrationRequest) jaxbUnmarshaller.unmarshal(file);  
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
