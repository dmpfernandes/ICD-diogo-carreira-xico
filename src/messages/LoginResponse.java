//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.17 at 07:14:47 PM WEST 
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
 *         &lt;element ref="{}role"/>
 *         &lt;element ref="{}sessionNumber"/>
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
    "role",
    "sessionNumber"
})
@XmlRootElement(name = "loginResponse")
public class LoginResponse {

    @XmlElement(required = true)
    protected ResultState resultState;
    @XmlElement(required = true)
    protected String role;
    protected int sessionNumber;

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
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Gets the value of the sessionNumber property.
     * 
     */
    public int getSessionNumber() {
        return sessionNumber;
    }

    /**
     * Sets the value of the sessionNumber property.
     * 
     */
    public void setSessionNumber(int value) {
        this.sessionNumber = value;
    }

}
