/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author paresh
 */
@Entity
@Table(name = "trader_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TraderMaster.findAll", query = "SELECT t FROM TraderMaster t"),
    @NamedQuery(name = "TraderMaster.findByTraderId", query = "SELECT t FROM TraderMaster t WHERE t.traderId = :traderId"),
    @NamedQuery(name = "TraderMaster.findByTraderName", query = "SELECT t FROM TraderMaster t WHERE t.traderName = :traderName"),
    @NamedQuery(name = "TraderMaster.findByDeposit", query = "SELECT t FROM TraderMaster t WHERE t.deposit = :deposit"),
    @NamedQuery(name = "TraderMaster.findByAddress", query = "SELECT t FROM TraderMaster t WHERE t.address = :address"),
    @NamedQuery(name = "TraderMaster.findByStat", query = "SELECT t FROM TraderMaster t WHERE t.stat = :stat"),
    @NamedQuery(name = "TraderMaster.findByCity", query = "SELECT t FROM TraderMaster t WHERE t.city = :city"),
    @NamedQuery(name = "TraderMaster.findByPanNo", query = "SELECT t FROM TraderMaster t WHERE t.panNo = :panNo"),
    @NamedQuery(name = "TraderMaster.findByPhoneNo", query = "SELECT t FROM TraderMaster t WHERE t.phoneNo = :phoneNo"),
    @NamedQuery(name = "TraderMaster.findByEmailId", query = "SELECT t FROM TraderMaster t WHERE t.emailId = :emailId"),
    @NamedQuery(name = "TraderMaster.findByFund", query = "SELECT t FROM TraderMaster t WHERE t.fund = :fund")})
public class TraderMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trader_id")
    private Double traderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "trader_name")
    private String traderName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deposit")
    private double deposit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "stat")
    private String stat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pan_no")
    private String panNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "phone_no")
    private String phoneNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email_id")
    private String emailId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fund")
    private double fund;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traderMaster", fetch = FetchType.EAGER)
    private List<TraderStock> traderStockList;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UserMaster userId;
    @JoinColumn(name = "broker_id", referencedColumnName = "broker_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BrokerMaster brokerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traderId", fetch = FetchType.EAGER)
    private List<OrderMaster> orderMasterList;

    public TraderMaster() {
    }

    public TraderMaster(Double traderId) {
        this.traderId = traderId;
    }

    public TraderMaster( String traderName, double deposit, String address, String stat, String city, String panNo, String phoneNo, String emailId, double fund) {
       
        this.traderName = traderName;
        this.deposit = deposit;
        this.address = address;
        this.stat = stat;
        this.city = city;
        this.panNo = panNo;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.fund = fund;
    }

    public Double getTraderId() {
        return traderId;
    }

    public void setTraderId(Double traderId) {
        this.traderId = traderId;
    }

    public String getTraderName() {
        return traderName;
    }

    public void setTraderName(String traderName) {
        this.traderName = traderName;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    @XmlTransient
    public List<TraderStock> getTraderStockList() {
        return traderStockList;
    }

    public void setTraderStockList(List<TraderStock> traderStockList) {
        this.traderStockList = traderStockList;
    }

    public UserMaster getUserId() {
        return userId;
    }

    public void setUserId(UserMaster userId) {
        this.userId = userId;
    }

    public BrokerMaster getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(BrokerMaster brokerId) {
        this.brokerId = brokerId;
    }

    @XmlTransient
    public List<OrderMaster> getOrderMasterList() {
        return orderMasterList;
    }

    public void setOrderMasterList(List<OrderMaster> orderMasterList) {
        this.orderMasterList = orderMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traderId != null ? traderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraderMaster)) {
            return false;
        }
        TraderMaster other = (TraderMaster) object;
        if ((this.traderId == null && other.traderId != null) || (this.traderId != null && !this.traderId.equals(other.traderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TraderMaster[ traderId=" + traderId + " ]";
    }
    
}
