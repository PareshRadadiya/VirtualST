
package Service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getPendingOrder_1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getPendingOrder_1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trader_id" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="order_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="script_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="order_date_from" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="order_date_to" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPendingOrder_1", propOrder = {
    "traderId",
    "orderType",
    "scriptId",
    "orderDateFrom",
    "orderDateTo"
})
public class GetPendingOrder1 {

    @XmlElement(name = "trader_id")
    protected Double traderId;
    @XmlElement(name = "order_type")
    protected String orderType;
    @XmlElement(name = "script_id")
    protected String scriptId;
    @XmlElement(name = "order_date_from")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderDateFrom;
    @XmlElement(name = "order_date_to")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderDateTo;

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
     * Gets the value of the orderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Sets the value of the orderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderType(String value) {
        this.orderType = value;
    }

    /**
     * Gets the value of the scriptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScriptId() {
        return scriptId;
    }

    /**
     * Sets the value of the scriptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScriptId(String value) {
        this.scriptId = value;
    }

    /**
     * Gets the value of the orderDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderDateFrom() {
        return orderDateFrom;
    }

    /**
     * Sets the value of the orderDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderDateFrom(XMLGregorianCalendar value) {
        this.orderDateFrom = value;
    }

    /**
     * Gets the value of the orderDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderDateTo() {
        return orderDateTo;
    }

    /**
     * Sets the value of the orderDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderDateTo(XMLGregorianCalendar value) {
        this.orderDateTo = value;
    }

}
