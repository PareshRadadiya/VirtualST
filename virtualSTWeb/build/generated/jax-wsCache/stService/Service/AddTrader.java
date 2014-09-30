
package Service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addTrader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addTrader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trader_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="broker_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deposite" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PANno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addTrader", propOrder = {
    "traderName",
    "brokerId",
    "userId",
    "deposite",
    "address",
    "state",
    "city",
    "paNno",
    "phoneno",
    "emailId"
})
public class AddTrader {

    @XmlElement(name = "trader_name")
    protected String traderName;
    @XmlElement(name = "broker_id")
    protected Long brokerId;
    @XmlElement(name = "user_id")
    protected String userId;
    protected Double deposite;
    protected String address;
    protected String state;
    protected String city;
    @XmlElement(name = "PANno")
    protected String paNno;
    protected String phoneno;
    @XmlElement(name = "email_id")
    protected String emailId;

    /**
     * Gets the value of the traderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTraderName() {
        return traderName;
    }

    /**
     * Sets the value of the traderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTraderName(String value) {
        this.traderName = value;
    }

    /**
     * Gets the value of the brokerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBrokerId() {
        return brokerId;
    }

    /**
     * Sets the value of the brokerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBrokerId(Long value) {
        this.brokerId = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the deposite property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDeposite() {
        return deposite;
    }

    /**
     * Sets the value of the deposite property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDeposite(Double value) {
        this.deposite = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the paNno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPANno() {
        return paNno;
    }

    /**
     * Sets the value of the paNno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPANno(String value) {
        this.paNno = value;
    }

    /**
     * Gets the value of the phoneno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneno() {
        return phoneno;
    }

    /**
     * Sets the value of the phoneno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneno(String value) {
        this.phoneno = value;
    }

    /**
     * Gets the value of the emailId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the value of the emailId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailId(String value) {
        this.emailId = value;
    }

}
