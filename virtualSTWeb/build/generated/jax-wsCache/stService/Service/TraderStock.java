
package Service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for traderStock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="traderStock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://Service/}stockDetails" minOccurs="0"/>
 *         &lt;element ref="{http://Service/}traderMaster" minOccurs="0"/>
 *         &lt;element name="traderStockPK" type="{http://Service/}traderStockPK" minOccurs="0"/>
 *         &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "traderStock", propOrder = {
    "stockDetails",
    "traderMaster",
    "traderStockPK",
    "volume"
})
public class TraderStock {

    @XmlElement(namespace = "http://Service/")
    protected StockDetails stockDetails;
    @XmlElement(namespace = "http://Service/")
    protected TraderMaster traderMaster;
    protected TraderStockPK traderStockPK;
    protected long volume;

    /**
     * Gets the value of the stockDetails property.
     * 
     * @return
     *     possible object is
     *     {@link StockDetails }
     *     
     */
    public StockDetails getStockDetails() {
        return stockDetails;
    }

    /**
     * Sets the value of the stockDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link StockDetails }
     *     
     */
    public void setStockDetails(StockDetails value) {
        this.stockDetails = value;
    }

    /**
     * Gets the value of the traderMaster property.
     * 
     * @return
     *     possible object is
     *     {@link TraderMaster }
     *     
     */
    public TraderMaster getTraderMaster() {
        return traderMaster;
    }

    /**
     * Sets the value of the traderMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link TraderMaster }
     *     
     */
    public void setTraderMaster(TraderMaster value) {
        this.traderMaster = value;
    }

    /**
     * Gets the value of the traderStockPK property.
     * 
     * @return
     *     possible object is
     *     {@link TraderStockPK }
     *     
     */
    public TraderStockPK getTraderStockPK() {
        return traderStockPK;
    }

    /**
     * Sets the value of the traderStockPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link TraderStockPK }
     *     
     */
    public void setTraderStockPK(TraderStockPK value) {
        this.traderStockPK = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     */
    public long getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     */
    public void setVolume(long value) {
        this.volume = value;
    }

}
