//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.17 at 07:22:04 PM WEST 
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
 *         &lt;element ref="{}numOfQuestionsAsked"/>
 *         &lt;element ref="{}numOfQuestionsAnswered"/>
 *         &lt;element ref="{}questionsAsked"/>
 *       &lt;/sequence>
 *       &lt;attribute name="idS" type="{http://www.w3.org/2001/XMLSchema}byte" />
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
    "numOfQuestionsAsked",
    "numOfQuestionsAnswered",
    "questionsAsked"
})
@XmlRootElement(name = "session")
public class Session {

    protected byte numOfQuestionsAsked;
    protected byte numOfQuestionsAnswered;
    @XmlElement(required = true)
    protected QuestionsAsked questionsAsked;
    @XmlAttribute(name = "idS")
    protected Byte idS;
    @XmlAttribute(name = "refIdUser")
    protected Byte refIdUser;

    /**
     * Gets the value of the numOfQuestionsAsked property.
     * 
     */
    public byte getNumOfQuestionsAsked() {
        return numOfQuestionsAsked;
    }

    /**
     * Sets the value of the numOfQuestionsAsked property.
     * 
     */
    public void setNumOfQuestionsAsked(byte value) {
        this.numOfQuestionsAsked = value;
    }

    /**
     * Gets the value of the numOfQuestionsAnswered property.
     * 
     */
    public byte getNumOfQuestionsAnswered() {
        return numOfQuestionsAnswered;
    }

    /**
     * Sets the value of the numOfQuestionsAnswered property.
     * 
     */
    public void setNumOfQuestionsAnswered(byte value) {
        this.numOfQuestionsAnswered = value;
    }

    /**
     * Gets the value of the questionsAsked property.
     * 
     * @return
     *     possible object is
     *     {@link QuestionsAsked }
     *     
     */
    public QuestionsAsked getQuestionsAsked() {
        return questionsAsked;
    }

    /**
     * Sets the value of the questionsAsked property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuestionsAsked }
     *     
     */
    public void setQuestionsAsked(QuestionsAsked value) {
        this.questionsAsked = value;
    }

    /**
     * Gets the value of the idS property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getIdS() {
        return idS;
    }

    /**
     * Sets the value of the idS property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setIdS(Byte value) {
        this.idS = value;
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
