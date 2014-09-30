
package Service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for transactionDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transactionDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="brokrage" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="orderId" type="{http://Service/}orderMaster" minOccurs="0"/>
 *         &lt;element name="transDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="transId" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transactionDetails", propOrder = {
    "brokrage",
    "orderId",
    "transDate",
    "transId"
})
public class TransactionDetails {

    protected double brokrage;
    protected OrderMaster orderId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transDate;
    protected Double transId;

    /**
     * Gets the value of the brokrage property.
     * 
     */
    public double getBrokrage() {
        return brokrage;
    }

    /**
     * Sets the value of the brokrage property.
     * 
     */
    public void setBrokrage(double value) {
        this.brokrage = value;
    }

    /**
     * Gets the value of the orderId property.
     * 
     * @return
     *     possible object is
     *     {@link OrderMaster }
     *     
     */
    public OrderMaster getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderMaster }
     *     
     */
    public void setOrderId(OrderMaster value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the transDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransDate() {
        return transDate;
    }

    /**
     * Sets the value of the transDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransDate(XMLGregorianCalendar value) {
        this.transDate = value;
    }

    /**
     * Gets the value of the transId property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTransId() {
        return transId;
    }

    /**
     * Sets the value of the transId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTransId(Double value) {
        this.transId = value;
    }

}
