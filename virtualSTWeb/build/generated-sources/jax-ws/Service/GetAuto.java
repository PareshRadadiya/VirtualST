
package Service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAuto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAuto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Stock_Symbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAuto", propOrder = {
    "stockSymbol"
})
public class GetAuto {

    @XmlElement(name = "Stock_Symbol")
    protected String stockSymbol;

    /**
     * Gets the value of the stockSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockSymbol() {
        return stockSymbol;
    }

    /**
     * Sets the value of the stockSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockSymbol(String value) {
        this.stockSymbol = value;
    }

}
