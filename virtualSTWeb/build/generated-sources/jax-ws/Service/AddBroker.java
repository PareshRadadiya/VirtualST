
package Service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addBroker complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addBroker">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="broker_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="correspond_office" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clearingNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trade_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="corporate_email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phone_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEBIno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deposit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addBroker", propOrder = {
    "brokerName",
    "userId",
    "correspondOffice",
    "state",
    "city",
    "clearingNo",
    "tradeName",
    "corporateEmail",
    "phoneNo",
    "sebIno",
    "deposit"
})
public class AddBroker {

    @XmlElement(name = "broker_name")
    protected String brokerName;
    @XmlElement(name = "user_id")
    protected String userId;
    @XmlElement(name = "correspond_office")
    protected String correspondOffice;
    protected String state;
    protected String city;
    protected String clearingNo;
    @XmlElement(name = "trade_name")
    protected String tradeName;
    @XmlElement(name = "corporate_email")
    protected String corporateEmail;
    @XmlElement(name = "phone_no")
    protected String phoneNo;
    @XmlElement(name = "SEBIno")
    protected String sebIno;
    protected Double deposit;

    /**
     * Gets the value of the brokerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrokerName() {
        return brokerName;
    }

    /**
     * Sets the value of the brokerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrokerName(String value) {
        this.brokerName = value;
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
     * Gets the value of the correspondOffice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrespondOffice() {
        return correspondOffice;
    }

    /**
     * Sets the value of the correspondOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrespondOffice(String value) {
        this.correspondOffice = value;
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
     * Gets the value of the clearingNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClearingNo() {
        return clearingNo;
    }

    /**
     * Sets the value of the clearingNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClearingNo(String value) {
        this.clearingNo = value;
    }

    /**
     * Gets the value of the tradeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeName() {
        return tradeName;
    }

    /**
     * Sets the value of the tradeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeName(String value) {
        this.tradeName = value;
    }

    /**
     * Gets the value of the corporateEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorporateEmail() {
        return corporateEmail;
    }

    /**
     * Sets the value of the corporateEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorporateEmail(String value) {
        this.corporateEmail = value;
    }

    /**
     * Gets the value of the phoneNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the value of the phoneNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNo(String value) {
        this.phoneNo = value;
    }

    /**
     * Gets the value of the sebIno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEBIno() {
        return sebIno;
    }

    /**
     * Sets the value of the sebIno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEBIno(String value) {
        this.sebIno = value;
    }

    /**
     * Gets the value of the deposit property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDeposit() {
        return deposit;
    }

    /**
     * Sets the value of the deposit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDeposit(Double value) {
        this.deposit = value;
    }

}
