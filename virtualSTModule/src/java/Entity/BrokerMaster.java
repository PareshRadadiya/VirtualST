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
@Table(name = "broker_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrokerMaster.findAll", query = "SELECT b FROM BrokerMaster b"),
    @NamedQuery(name = "BrokerMaster.findByBrokerId", query = "SELECT b FROM BrokerMaster b WHERE b.brokerId = :brokerId"),
    @NamedQuery(name = "BrokerMaster.findByBrokerName", query = "SELECT b FROM BrokerMaster b WHERE b.brokerName = :brokerName"),
    @NamedQuery(name = "BrokerMaster.findByCorrespondOffice", query = "SELECT b FROM BrokerMaster b WHERE b.correspondOffice = :correspondOffice"),
    @NamedQuery(name = "BrokerMaster.findByStat", query = "SELECT b FROM BrokerMaster b WHERE b.stat = :stat"),
    @NamedQuery(name = "BrokerMaster.findByCity", query = "SELECT b FROM BrokerMaster b WHERE b.city = :city"),
    @NamedQuery(name = "BrokerMaster.findByClearingNo", query = "SELECT b FROM BrokerMaster b WHERE b.clearingNo = :clearingNo"),
    @NamedQuery(name = "BrokerMaster.findByTradeName", query = "SELECT b FROM BrokerMaster b WHERE b.tradeName = :tradeName"),
    @NamedQuery(name = "BrokerMaster.findByCorporateEmail", query = "SELECT b FROM BrokerMaster b WHERE b.corporateEmail = :corporateEmail"),
    @NamedQuery(name = "BrokerMaster.findByPhoneNo", query = "SELECT b FROM BrokerMaster b WHERE b.phoneNo = :phoneNo"),
    @NamedQuery(name = "BrokerMaster.findBySebiNo", query = "SELECT b FROM BrokerMaster b WHERE b.sebiNo = :sebiNo"),
    @NamedQuery(name = "BrokerMaster.findByDeposit", query = "SELECT b FROM BrokerMaster b WHERE b.deposit = :deposit"),
    @NamedQuery(name = "BrokerMaster.findByFund", query = "SELECT b FROM BrokerMaster b WHERE b.fund = :fund")})
public class BrokerMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "broker_id")
    private Long brokerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "broker_name")
    private String brokerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correspond_office")
    private String correspondOffice;
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
    @Size(min = 1, max = 50)
    @Column(name = "clearing_no")
    private String clearingNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "trade_name")
    private String tradeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "corporate_email")
    private String corporateEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "phone_no")
    private String phoneNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "sebi_no")
    private String sebiNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deposit")
    private double deposit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fund")
    private double fund;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UserMaster userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brokerId", fetch = FetchType.EAGER)
    private List<TraderMaster> traderMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brokerId", fetch = FetchType.EAGER)
    private List<RegistrationMst> registrationList;

    public BrokerMaster() {
    }

    public BrokerMaster(Long brokerId) {
        this.brokerId = brokerId;
    }

    public BrokerMaster( String brokerName, String correspondOffice, String stat, String city, String clearingNo, String tradeName, String corporateEmail, String phoneNo, String sebiNo, double deposit, double fund) {
       
        this.brokerName = brokerName;
        this.correspondOffice = correspondOffice;
        this.stat = stat;
        this.city = city;
        this.clearingNo = clearingNo;
        this.tradeName = tradeName;
        this.corporateEmail = corporateEmail;
        this.phoneNo = phoneNo;
        this.sebiNo = sebiNo;
        this.deposit = deposit;
        this.fund = fund;
    }

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getCorrespondOffice() {
        return correspondOffice;
    }

    public void setCorrespondOffice(String correspondOffice) {
        this.correspondOffice = correspondOffice;
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

    public String getClearingNo() {
        return clearingNo;
    }

    public void setClearingNo(String clearingNo) {
        this.clearingNo = clearingNo;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getCorporateEmail() {
        return corporateEmail;
    }

    public void setCorporateEmail(String corporateEmail) {
        this.corporateEmail = corporateEmail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSebiNo() {
        return sebiNo;
    }

    public void setSebiNo(String sebiNo) {
        this.sebiNo = sebiNo;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public UserMaster getUserId() {
        return userId;
    }

    public void setUserId(UserMaster userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<TraderMaster> getTraderMasterList() {
        return traderMasterList;
    }

    public void setTraderMasterList(List<TraderMaster> traderMasterList) {
        this.traderMasterList = traderMasterList;
    }

    @XmlTransient
    public List<RegistrationMst> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<RegistrationMst> registrationList) {
        this.registrationList = registrationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brokerId != null ? brokerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BrokerMaster)) {
            return false;
        }
        BrokerMaster other = (BrokerMaster) object;
        if ((this.brokerId == null && other.brokerId != null) || (this.brokerId != null && !this.brokerId.equals(other.brokerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.BrokerMaster[ brokerId=" + brokerId + " ]";
    }
    
}
