//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.17 at 06:39:51 PM WEST 
//


package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}questionBody"/>
 *         &lt;element ref="{}answers"/>
 *       &lt;/sequence>
 *       &lt;attribute name="idQ" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="refIdUser" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "questionBody",
    "answers"
})
@XmlRootElement(name = "question")
public class Question {

    @XmlElement(required = true)
    protected String questionBody;
    @XmlElement(required = true)
    protected Answers answers;
    @XmlAttribute(name = "idQ")
    protected Byte idQ;
    @XmlAttribute(name = "refIdUser")
    protected Byte refIdUser;

    /**
     * Gets the value of the questionBody property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestionBody() {
        return questionBody;
    }

    /**
     * Sets the value of the questionBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestionBody(String value) {
        this.questionBody = value;
    }

    /**
     * Gets the value of the answers property.
     * 
     * @return
     *     possible object is
     *     {@link Answers }
     *     
     */
    public Answers getAnswers() {
        return answers;
    }

    /**
     * Sets the value of the answers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Answers }
     *     
     */
    public void setAnswers(Answers value) {
        this.answers = value;
    }

    /**
     * Gets the value of the idQ property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getIdQ() {
        return idQ;
    }

    /**
     * Sets the value of the idQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setIdQ(Byte value) {
        this.idQ = value;
    }

    /**
     * Gets the value of the refIdUser property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getRefIdUser() {
        return refIdUser;
    }

    /**
     * Sets the value of the refIdUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setRefIdUser(Byte value) {
        this.refIdUser = value;
    }

}