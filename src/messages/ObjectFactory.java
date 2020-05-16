//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.17 at 12:11:13 AM WEST 
//


package messages;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the messages package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NumOfQuestionsAnswered_QNAME = new QName("", "numOfQuestionsAnswered");
    private final static QName _Password_QNAME = new QName("", "password");
    private final static QName _AnswerBody_QNAME = new QName("", "answerBody");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _QuestionBody_QNAME = new QName("", "questionBody");
    private final static QName _BirthDate_QNAME = new QName("", "birthDate");
    private final static QName _NumOfQuestionsAsked_QNAME = new QName("", "numOfQuestionsAsked");
    private final static QName _Email_QNAME = new QName("", "email");
    private final static QName _Username_QNAME = new QName("", "username");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: messages
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QuestionsAsked }
     * 
     */
    public QuestionsAsked createQuestionsAsked() {
        return new QuestionsAsked();
    }

    /**
     * Create an instance of {@link QAsked }
     * 
     */
    public QAsked createQAsked() {
        return new QAsked();
    }

    /**
     * Create an instance of {@link CorrectAnswer }
     * 
     */
    public CorrectAnswer createCorrectAnswer() {
        return new CorrectAnswer();
    }

    /**
     * Create an instance of {@link WrongAnswer }
     * 
     */
    public WrongAnswer createWrongAnswer() {
        return new WrongAnswer();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link Answers }
     * 
     */
    public Answers createAnswers() {
        return new Answers();
    }

    /**
     * Create an instance of {@link Answer }
     * 
     */
    public Answer createAnswer() {
        return new Answer();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link Questions }
     * 
     */
    public Questions createQuestions() {
        return new Questions();
    }

    /**
     * Create an instance of {@link Users }
     * 
     */
    public Users createUsers() {
        return new Users();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Stats }
     * 
     */
    public Stats createStats() {
        return new Stats();
    }

    /**
     * Create an instance of {@link XmlDB }
     * 
     */
    public XmlDB createXmlDB() {
        return new XmlDB();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "numOfQuestionsAnswered")
    public JAXBElement<Integer> createNumOfQuestionsAnswered(Integer value) {
        return new JAXBElement<Integer>(_NumOfQuestionsAnswered_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "password")
    public JAXBElement<String> createPassword(String value) {
        return new JAXBElement<String>(_Password_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "answerBody")
    public JAXBElement<String> createAnswerBody(String value) {
        return new JAXBElement<String>(_AnswerBody_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "questionBody")
    public JAXBElement<String> createQuestionBody(String value) {
        return new JAXBElement<String>(_QuestionBody_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "birthDate")
    public JAXBElement<String> createBirthDate(String value) {
        return new JAXBElement<String>(_BirthDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "numOfQuestionsAsked")
    public JAXBElement<Integer> createNumOfQuestionsAsked(Integer value) {
        return new JAXBElement<Integer>(_NumOfQuestionsAsked_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "email")
    public JAXBElement<String> createEmail(String value) {
        return new JAXBElement<String>(_Email_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "username")
    public JAXBElement<String> createUsername(String value) {
        return new JAXBElement<String>(_Username_QNAME, String.class, null, value);
    }

}
