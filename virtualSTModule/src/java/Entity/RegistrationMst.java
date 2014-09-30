/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paresh
 */
@Entity
@Table(name = "registration_mst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistrationMst.findAll", query = "SELECT r FROM RegistrationMst r"),
    @NamedQuery(name = "RegistrationMst.findByGuestId", query = "SELECT r FROM RegistrationMst r WHERE r.guestId = :guestId"),
    @NamedQuery(name = "RegistrationMst.findByGuestName", query = "SELECT r FROM RegistrationMst r WHERE r.guestName = :guestName"),
    @NamedQuery(name = "RegistrationMst.findByEmailId", query = "SELECT r FROM RegistrationMst r WHERE r.emailId = :emailId"),
    @NamedQuery(name = "RegistrationMst.findByPhoneNo", query = "SELECT r FROM RegistrationMst r WHERE r.phoneNo = :phoneNo"),
    @NamedQuery(name = "RegistrationMst.findByAddress", query = "SELECT r FROM RegistrationMst r WHERE r.address = :address"),
    @NamedQuery(name = "RegistrationMst.findByStat", query = "SELECT r FROM RegistrationMst r WHERE r.stat = :stat"),
    @NamedQuery(name = "RegistrationMst.findByCity", query = "SELECT r FROM RegistrationMst r WHERE r.city = :city"),
    @NamedQuery(name = "RegistrationMst.findByPincode", query = "SELECT r FROM RegistrationMst r WHERE r.pincode = :pincode"),
    @NamedQuery(name = "RegistrationMst.findByPanNo", query = "SELECT r FROM RegistrationMst r WHERE r.panNo = :panNo"),
    @NamedQuery(name = "RegistrationMst.findByPending", query = "SELECT r FROM RegistrationMst r WHERE r.pending = :pending")})
public class RegistrationMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "guest_id")
    private Integer guestId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "guest_name")
    private String guestName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email_id")
    private String emailId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "phone_no")
    private String phoneNo;
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
    @Size(min = 1, max = 10)
    @Column(name = "pincode")
    private String pincode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "panNo")
    private String panNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pending")
    private String pending;
    @JoinColumn(name = "broker_id", referencedColumnName = "broker_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BrokerMaster brokerId;

    public RegistrationMst() {
    }

    public RegistrationMst(Integer guestId) {
        this.guestId = guestId;
    }

    public RegistrationMst( String guestName, String emailId, String phoneNo, String address, String stat, String city, String pincode, String panNo, String pending) {
        
        this.guestName = guestName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.address = address;
        this.stat = stat;
        this.city = city;
        this.pincode = pincode;
        this.panNo = panNo;
        this.pending = pending;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public BrokerMaster getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(BrokerMaster brokerId) {
        this.brokerId = brokerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestId != null ? guestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistrationMst)) {
            return false;
        }
        RegistrationMst other = (RegistrationMst) object;
        if ((this.guestId == null && other.guestId != null) || (this.guestId != null && !this.guestId.equals(other.guestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RegistrationMst[ guestId=" + guestId + " ]";
    }
    
}
