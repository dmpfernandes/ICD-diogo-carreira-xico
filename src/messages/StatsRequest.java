package messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class StatsRequest {

	/**
	 * <?questionsAsked questionAnswered correctQuestions wrongQuestions ?>
<statsRequest>
	<whichStat>questionsAsked</whichStat>
</statsRequest>
	 */
	private String whichStat;
	
	public StatsRequest(String whichStat) {
		this.whichStat = whichStat;
	}

	public String getWhichStat() {
		return whichStat;
	}
}
