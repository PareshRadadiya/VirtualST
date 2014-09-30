
package Service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for brokerMaster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="brokerMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="brokerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="brokerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clearingNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="corporateEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="correspondOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deposit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fund" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="phoneNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sebiNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tradeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "brokerMaster", propOrder = {
    "brokerId",
    "brokerName",
    "city",
    "clearingNo",
    "corporateEmail",
    "correspondOffice",
    "deposit",
    "fund",
    "phoneNo",
    "sebiNo",
    "stat",
    "tradeName",
    "userId"
})
public class BrokerMaster {

    protected Long brokerId;
    protected String brokerName;
    protected String city;
    protected String clearingNo;
    protected String corporateEmail;
    protected String correspondOffice;
    protected double deposit;
    protected double fund;
    protected String phoneNo;
    protected String sebiNo;
    protected String stat;
    protected String tradeName;
    protected UserMaster userId;

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
     * Gets the value of the sebiNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSebiNo() {
        return sebiNo;
    }

    /**
     * Sets the value of the sebiNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSebiNo(String value) {
        this.sebiNo = value;
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
