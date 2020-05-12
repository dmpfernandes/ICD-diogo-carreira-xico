package service_handler;

import org.w3c.dom.*;

import messages.RegistrationRequest;

import javax.xml.parsers.*;
import java.io.*;

public class Service {
	
	private int sessionId;
		
	public Service(int sessionId) {
		this.sessionId = sessionId;
	}

	public int getSessionId() {
		return sessionId;
	}
	
	public Object parseInputIntoDocument(File file) throws Exception {
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
		Document document = documentBuilder.parse(file);  
		switch(document.getDocumentElement().getNodeName()) {
		case "Registration":
			return unMarshallFile(file, RegistrationRequest.class);
		default:
			return null;
		}
	}

	private Object unMarshallFile(File file, Class objClass) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
