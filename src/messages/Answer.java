package messages;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Answer {
	
	private String answerBody;
	
	@XmlAttribute
	private Boolean bool;
	
	public Answer(Boolean bool, String answerBody) {
		this.bool = bool;
		this.answerBody = answerBody;
	}

	public String getAnswerBody() {
		return answerBody;
	}
}
