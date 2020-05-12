package messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class RequestQuestionRequest {

/**
 * <RequestQuestionResponse refIdQ="0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="file://VBOXSVR/shared/requestQuestionResponse.xsd">
	<ResultState>
		<State>100</State>
		<Description>Descriptio</Description>
	</ResultState>
</RequestQuestionResponse>
 */
	
	@XmlAttribute
	private int refIdQ;
	
	private ResultState resultState;
	
	public RequestQuestionRequest(int refIdQ, ResultState resultState) {
		this.refIdQ = refIdQ;
		this.resultState = resultState;
	}
	
	public int getRefIdQ() {
		return refIdQ;
	}

	public ResultState getResultState() {
		return resultState;
	}

}
