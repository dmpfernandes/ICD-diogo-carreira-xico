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
 *         &lt;element ref="{}answerBody"/>
 *       &lt;/sequence>
 *       &lt;attribute name="bool" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "answerBody"
})
@XmlRootElement(name = "answer")
public class Answer {

    @XmlElement(required = true)
    protected String answerBody;
    @XmlAttribute(name = "bool")
    protected String bool;

    /**
     * Gets the value of the answerBody property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnswerBody() {
        return answerBody;
    }

    /**
     * Sets the value of the answerBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnswerBody(String value) {
        this.answerBody = value;
    }

    /**
     * Gets the value of the bool property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBool() {
        return bool;
    }

    /**
     * Sets the value of the bool property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBool(String value) {
        this.bool = value;
    }

}
