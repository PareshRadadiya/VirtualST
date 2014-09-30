/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paresh
 */
@Entity
@Table(name = "trader_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TraderStock.findAll", query = "SELECT t FROM TraderStock t"),
    @NamedQuery(name = "TraderStock.findByTrader", query = "SELECT t FROM TraderStock t WHERE t.traderStockPK.trader = :trader"),
    @NamedQuery(name = "TraderStock.findByScript", query = "SELECT t FROM TraderStock t WHERE t.traderStockPK.script = :script"),
    @NamedQuery(name = "TraderStock.findByVolume", query = "SELECT t FROM TraderStock t WHERE t.volume = :volume")})
public class TraderStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TraderStockPK traderStockPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volume")
    private long volume;
    @JoinColumn(name = "script", referencedColumnName = "script_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private StockDetails stockDetails;
    @JoinColumn(name = "trader", referencedColumnName = "trader_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TraderMaster traderMaster;

    public TraderStock() {
    }

    public TraderStock(TraderStockPK traderStockPK) {
        this.traderStockPK = traderStockPK;
    }

    public TraderStock(TraderStockPK traderStockPK, long volume) {
        this.traderStockPK = traderStockPK;
        this.volume = volume;
    }

    public TraderStock(double trader, String script) {
        this.traderStockPK = new TraderStockPK(trader, script);
    }

    public TraderStockPK getTraderStockPK() {
        return traderStockPK;
    }

    public void setTraderStockPK(TraderStockPK traderStockPK) {
        this.traderStockPK = traderStockPK;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public StockDetails getStockDetails() {
        return stockDetails;
    }

    public void setStockDetails(StockDetails stockDetails) {
        this.stockDetails = stockDetails;
    }

    public TraderMaster getTraderMaster() {
        return traderMaster;
    }

    public void setTraderMaster(TraderMaster traderMaster) {
        this.traderMaster = traderMaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traderStockPK != null ? traderStockPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraderStock)) {
            return false;
        }
        TraderStock other = (TraderStock) object;
        if ((this.traderStockPK == null && other.traderStockPK != null) || (this.traderStockPK != null && !this.traderStockPK.equals(other.traderStockPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TraderStock[ traderStockPK=" + traderStockPK + " ]";
    }
    
}
