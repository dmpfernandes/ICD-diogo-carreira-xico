//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.17 at 09:41:51 PM WEST 
//


package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}qAsked"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "qAsked"
})
@XmlRootElement(name = "questionsAsked")
public class QuestionsAsked {

    @XmlElement(required = true)
    protected QAsked qAsked;

    /**
     * Gets the value of the qAsked property.
     * 
     * @return
     *     possible object is
     *     {@link QAsked }
     *     
     */
    public QAsked getQAsked() {
        return qAsked;
    }

    /**
     * Sets the value of the qAsked property.
     * 
     * @param value
     *     allowed object is
     *     {@link QAsked }
     *     
     */
    public void setQAsked(QAsked value) {
        this.qAsked = value;
    }

}
