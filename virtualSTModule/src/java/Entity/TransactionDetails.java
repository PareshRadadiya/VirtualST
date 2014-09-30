/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paresh
 */
@Entity
@Table(name = "transaction_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionDetails.findAll", query = "SELECT t FROM TransactionDetails t"),
    @NamedQuery(name = "TransactionDetails.findByTransId", query = "SELECT t FROM TransactionDetails t WHERE t.transId = :transId"),
    @NamedQuery(name = "TransactionDetails.findByTransDate", query = "SELECT t FROM TransactionDetails t WHERE t.transDate = :transDate"),
    @NamedQuery(name = "TransactionDetails.findByBrokrage", query = "SELECT t FROM TransactionDetails t WHERE t.brokrage = :brokrage")})
public class TransactionDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trans_id")
    private Double transId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trans_date")
    @Temporal(TemporalType.DATE)
    private Date transDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "brokrage")
    private double brokrage;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OrderMaster orderId;

    public TransactionDetails() {
    }

    public TransactionDetails(Double transId) {
        this.transId = transId;
    }

    public TransactionDetails(Date transDate, double brokrage) {
       
        this.transDate = transDate;
        this.brokrage = brokrage;
    }

    public Double getTransId() {
        return transId;
    }

    public void setTransId(Double transId) {
        this.transId = transId;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public double getBrokrage() {
        return brokrage;
    }

    public void setBrokrage(double brokrage) {
        this.brokrage = brokrage;
    }

    public OrderMaster getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderMaster orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transId != null ? transId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionDetails)) {
            return false;
        }
        TransactionDetails other = (TransactionDetails) object;
        if ((this.transId == null && other.transId != null) || (this.transId != null && !this.transId.equals(other.transId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TransactionDetails[ transId=" + transId + " ]";
    }
    
}
