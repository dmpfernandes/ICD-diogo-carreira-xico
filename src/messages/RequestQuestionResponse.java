package messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class RequestQuestionResponse {

	//<RequestQuestionRequest refIdQ="0" allStudents="true" refIdUser="0" SessionNumber="0"
	@XmlAttribute
	private int refIdQ;
	
	@XmlAttribute
	private boolean allStudents;
	
	@XmlAttribute
	private int refIdUser;
	
	@XmlAttribute
	private int sessionNumber;
	
	public RequestQuestionResponse(int refIdQ, boolean allStudents, int refIdUser, int sessionNumber) {
		this.allStudents = allStudents;
		this.refIdQ = refIdQ;
		this.refIdUser = refIdUser;
		this.sessionNumber = sessionNumber;
	}
	
	public int getRefIdQ() {
		return refIdQ;
	}

	public int getRefIdUser() {
		return refIdUser;
	}

	public int getSessionNumber() {
		return sessionNumber;
	}
}
