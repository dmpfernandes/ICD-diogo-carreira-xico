//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.17 at 09:15:03 PM WEST 
//


package messages;

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
 *         &lt;element ref="{}resultState"/>
 *         &lt;element ref="{}questionID"/>
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
    "resultState",
    "questionID"
})
@XmlRootElement(name = "addQuestionResponse")
public class AddQuestionResponse {

    @XmlElement(required = true)
    protected ResultState resultState;
    protected short questionID;

    /**
     * Gets the value of the resultState property.
     * 
     * @return
     *     possible object is
     *     {@link ResultState }
     *     
     */
    public ResultState getResultState() {
        return resultState;
    }

    /**
     * Sets the value of the resultState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultState }
     *     
     */
    public void setResultState(ResultState value) {
        this.resultState = value;
    }

    /**
     * Gets the value of the questionID property.
     * 
     */
    public short getQuestionID() {
        return questionID;
    }

    /**
     * Sets the value of the questionID property.
     * 
     */
    public void setQuestionID(short value) {
        this.questionID = value;
    }

}