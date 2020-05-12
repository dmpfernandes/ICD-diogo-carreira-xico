package messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SendAnswerResponse {

	private ResultState resultState;
	
	public SendAnswerResponse(ResultState resultState) {
		this.resultState = resultState;
	}
}
