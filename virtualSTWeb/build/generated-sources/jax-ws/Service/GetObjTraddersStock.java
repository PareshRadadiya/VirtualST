
package Service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getObjTraddersStock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getObjTraddersStock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trader_id" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="script_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getObjTraddersStock", propOrder = {
    "traderId",
    "scriptId"
})
public class GetObjTraddersStock {

    @XmlElement(name = "trader_id")
    protected Double traderId;
    @XmlElement(name = "script_id")
    protected String scriptId;

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

}
