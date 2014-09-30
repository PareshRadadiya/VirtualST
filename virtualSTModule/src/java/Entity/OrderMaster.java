/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author paresh
 */
@Entity
@Table(name = "order_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderMaster.findAll", query = "SELECT o FROM OrderMaster o"),
    @NamedQuery(name = "OrderMaster.findByOrderId", query = "SELECT o FROM OrderMaster o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "OrderMaster.findByVolume", query = "SELECT o FROM OrderMaster o WHERE o.volume = :volume"),
    @NamedQuery(name = "OrderMaster.findByPrice", query = "SELECT o FROM OrderMaster o WHERE o.price = :price"),
    @NamedQuery(name = "OrderMaster.findByOrderDate", query = "SELECT o FROM OrderMaster o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "OrderMaster.findByOrderType", query = "SELECT o FROM OrderMaster o WHERE o.orderType = :orderType"),
    @NamedQuery(name = "OrderMaster.findByPending", query = "SELECT o FROM OrderMaster o WHERE o.pending = :pending")})
public class OrderMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Double orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volume")
    private long volume;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "order_type")
    private String orderType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "pending")
    private String pending;
    @JoinColumn(name = "trader_id", referencedColumnName = "trader_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TraderMaster traderId;
    @JoinColumn(name = "script_id", referencedColumnName = "script_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private StockDetails scriptId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId", fetch = FetchType.EAGER)
    private List<TransactionDetails> transactionDetailsList;

    public OrderMaster() {
    }

    public OrderMaster(Double orderId) {
        this.orderId = orderId;
    }

    public OrderMaster( long volume, double price, Date orderDate, String orderType, String pending) {
      
        this.volume = volume;
        this.price = price;
        this.orderDate = orderDate;
        this.orderType = orderType;
        this.pending = pending;
    }

    public Double getOrderId() {
        return orderId;
    }

    public void setOrderId(Double orderId) {
        this.orderId = orderId;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public TraderMaster getTraderId() {
        return traderId;
    }

    public void setTraderId(TraderMaster traderId) {
        this.traderId = traderId;
    }

    public StockDetails getScriptId() {
        return scriptId;
    }

    public void setScriptId(StockDetails scriptId) {
        this.scriptId = scriptId;
    }

    @XmlTransient
    public List<TransactionDetails> getTransactionDetailsList() {
        return transactionDetailsList;
    }

    public void setTransactionDetailsList(List<TransactionDetails> transactionDetailsList) {
        this.transactionDetailsList = transactionDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderMaster)) {
            return false;
        }
        OrderMaster other = (OrderMaster) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OrderMaster[ orderId=" + orderId + " ]";
    }
    
}
