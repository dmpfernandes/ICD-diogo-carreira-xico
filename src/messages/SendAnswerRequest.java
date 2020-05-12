package messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class SendAnswerRequest {

	//<SendAnswerRequest refIdQ="0" refIdUser="0" SessionNumber="0"
	//<Answer>{String}</Answer>
	//</SendAnswerRequest>
	@XmlAttribute
	private int refIdQ;
	
	@XmlAttribute
	private int refIdUser;
	
	@XmlAttribute
	private int sessionNumber;
	
	private String answer;
	
	public SendAnswerRequest(int refIdQ, int refIdUser, String answer) {
		this.refIdQ = refIdQ;
		this.refIdUser = refIdUser;	
		this.answer = answer;
	}
	
}
