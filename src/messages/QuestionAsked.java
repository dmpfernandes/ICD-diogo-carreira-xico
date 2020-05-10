package messages;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionAsked {
	
	@XmlAttribute
	private int idQAsked;
	
	@XmlAttribute
	private int refIdQ;
	
	private List<String> correctAnswer;
	
	private List<String> wrongAnswer;
	
	private int numOfCorrectAnswers;
	
	private int numOfWrongAnswers;
	
	public QuestionAsked(int idQAsked, int refIdQ, List<String> correctAnswer, List<String> wrongAnswer) {
		this.correctAnswer = correctAnswer;
		this.idQAsked = idQAsked;
		this.refIdQ = refIdQ;
		this.wrongAnswer = wrongAnswer;
	}
	
	public void incrementNumberOfCorrectAnswers() {
		numOfCorrectAnswers++;
	}
	
	public void incrementNumberOfWrongAnswers() {
		numOfWrongAnswers++;
	}

	public int getNumOfCorrectAnswers() {
		return numOfCorrectAnswers;
	}

	public int getNumOfWrongAnswers() {
		return numOfWrongAnswers;
	}
}
