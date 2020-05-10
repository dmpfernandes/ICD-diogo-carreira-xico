package messages;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Session {

	/**
	 * <stats>
        <session idS="{integer}" refIdUser="{integer}" >
            <numOfQuestions>{Integer}</numOfQuestions>
            <questionsAsked>
                <qAsked idQAsked="{string}" refIdQ="{integer}">
                    <correctAnswer numOfCorrectAnswers="{integer}">{List(string)}</correctAnswer>
                    <wrongAnswer numOfWrongAnswers="{integer}">{List(string)}</wrongAnswer>
                </qAsked>
            </questionsAsked>
        </session>
    </stats>
	 */
	@XmlAttribute(name = "idS")
	private int idSession;
	
	@XmlAttribute
	private int refIdUser;
	
	private int numOfQuestions;
	private List<QuestionAsked> questionsAsked;
	
	public Session(int idSession, int refIdUser) {
		this.idSession = idSession;
		this.refIdUser = refIdUser;
		numOfQuestions = 0;
		questionsAsked = Collections.emptyList();
	}
	
	public void addQuestionAsked(QuestionAsked question) {
		questionsAsked.add(question);
		numOfQuestions++;
	}

	public int getIdSession() {
		return idSession;
	}

	public int getRefIdUser() {
		return refIdUser;
	}

	public List<QuestionAsked> getQuestionsAsked() {
		return questionsAsked;
	}

	public int getNumOfQuestions() {
		return numOfQuestions;
	}
	
	
}
