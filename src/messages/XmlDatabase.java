package messages;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="xmlDB")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlDatabase {

	@XmlElement(name="Questions")
	public List<Question> questions;
	
	@XmlElement(name="Users")
	public List<User> users;
	
	@XmlElement(name="Stats")
	public List<Session> stats;
	
}
