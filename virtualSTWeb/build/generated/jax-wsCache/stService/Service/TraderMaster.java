
package Service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for traderMaster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="traderMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="brokerId" type="{http://Service/}brokerMaster" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deposit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="emailId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fund" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="panNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="traderId" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="traderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://Service/}userMaster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "traderMaster", propOrder = {
    "address",
    "brokerId",
    "city",
    "deposit",
    "emailId",
    "fund",
    "panNo",
    "phoneNo",
    "stat",
    "traderId",
    "traderName",
    "userId"
})
public class TraderMaster {

    protected String address;
    protected BrokerMaster brokerId;
    protected String city;
    protected double deposit;
    protected String emailId;
    protected double fund;
    protected String panNo;
    protected String phoneNo;
    protected String stat;
    protected Double traderId;
    protected String traderName;
    protected UserMaster userId;

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
     * Gets the value of the brokerId property.
     * 
     * @return
     *     possible object is
     *     {@link BrokerMaster }
     *     
     */
    public BrokerMaster getBrokerId() {
        return brokerId;
    }

    /**
     * Sets the value of the brokerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BrokerMaster }
     *     
     */
    public void setBrokerId(BrokerMaster value) {
        this.brokerId = value;
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
     * Gets the value of the deposit property.
     * 
     */
    public double getDeposit() {
        return deposit;
    }

    /**
     * Sets the value of the deposit property.
     * 
     */
    public void setDeposit(double value) {
        this.deposit = value;
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

    /**
     * Gets the value of the fund property.
     * 
     */
    public double getFund() {
        return fund;
    }

    /**
     * Sets the value of the fund property.
     * 
     */
    public void setFund(double value) {
        this.fund = value;
    }

    /**
     * Gets the value of the panNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanNo() {
        return panNo;
    }

    /**
     * Sets the value of the panNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanNo(String value) {
        this.panNo = value;
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
     * Gets the value of the stat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStat() {
        return stat;
    }

    /**
     * Sets the value of the stat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStat(String value) {
        this.stat = value;
    }

    /**
     * Gets the value of the traderId property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTraderId() {
        return traderId;
    }

    /**
     * Sets the value of the traderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTraderId(Double value) {
        this.traderId = value;
    }

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
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link UserMaster }
     *     
     */
    public UserMaster getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserMaster }
     *     
     */
    public void setUserId(UserMaster value) {
        this.userId = value;
    }

}
