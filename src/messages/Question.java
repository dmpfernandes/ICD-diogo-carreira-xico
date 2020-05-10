package messages;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Question {
	
	/**
	 * <answer bool="{boolean}">
                    <answerBody>{String}</answerBody>
                </answer>
	 */
	@XmlAttribute(name = "id")
	private int questionId;
	private String questionBody;
	private List<Answer> answers;
	
	public Question(int id, String questionBody, List<Answer> answers) {
		this.questionBody = questionBody;
		this.answers = answers;
		this.questionId = id;
	}

	public String getQuestionBody() {
		return questionBody;
	}

	public List<Answer> getAnswers() {
		return answers;
	}
	
	
}
