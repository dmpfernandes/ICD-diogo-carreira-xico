package messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class RegistrationRequest {
	
	private String name;
	private String username;
	private String email;
	private String birthDate;
	private String password;

	public RegistrationRequest(String name, String username, String email, String birthDate, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.birthDate = birthDate;
		this.password = password;
	}
}
