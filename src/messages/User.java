package messages;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	private String name;
	private String username;
	private String email;
	private String birthDate;
	private String password;
	
	public User(String name, String username, String email, String birthDate, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.birthDate = birthDate;
		this.password = password;
	}
}
