package messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class StatsResponse {

	/**
	 * 
	 * <statsResponse xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="file://VBOXSVR/shared/statsResponse.xsd">
	<value>0</value>
</statsResponse>
	 */
	private int value;
	
	public StatsResponse(int value) {
		this.value = value;
	}
}
