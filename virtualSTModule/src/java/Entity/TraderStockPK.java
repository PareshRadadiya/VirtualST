/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author paresh
 */
@Embeddable
public class TraderStockPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "trader")
    private double trader;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "script")
    private String script;

    public TraderStockPK() {
    }

    public TraderStockPK(double trader, String script) {
        this.trader = trader;
        this.script = script;
    }

    public double getTrader() {
        return trader;
    }

    public void setTrader(double trader) {
        this.trader = trader;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) trader;
        hash += (script != null ? script.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraderStockPK)) {
            return false;
        }
        TraderStockPK other = (TraderStockPK) object;
        if (this.trader != other.trader) {
            return false;
        }
        if ((this.script == null && other.script != null) || (this.script != null && !this.script.equals(other.script))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TraderStockPK[ trader=" + trader + ", script=" + script + " ]";
    }
    
}
