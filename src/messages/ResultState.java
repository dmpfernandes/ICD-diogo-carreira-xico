package messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ResultState {

	/**
	 * 
	 * <ResultState>
		<State>100</State>
		<Description>Description</Description>
	</ResultState>
	 */
	
	private int state;
	
	private String description;
	
	public ResultState(int state, String description) {
		this.description = description;
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public String getDescription() {
		return description;
	}
}
