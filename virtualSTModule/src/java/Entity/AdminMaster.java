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
@Table(name = "admin_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminMaster.findAll", query = "SELECT a FROM AdminMaster a"),
    @NamedQuery(name = "AdminMaster.findByAdminId", query = "SELECT a FROM AdminMaster a WHERE a.adminId = :adminId"),
    @NamedQuery(name = "AdminMaster.findByEmailId", query = "SELECT a FROM AdminMaster a WHERE a.emailId = :emailId"),
    @NamedQuery(name = "AdminMaster.findByPhoneNo", query = "SELECT a FROM AdminMaster a WHERE a.phoneNo = :phoneNo"),
    @NamedQuery(name = "AdminMaster.findByDetails", query = "SELECT a FROM AdminMaster a WHERE a.details = :details")})
public class AdminMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adminId")
    private Integer adminId;
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
    @Column(name = "details")
    private String details;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UserMaster userId;

    public AdminMaster() {
    }

    public AdminMaster(Integer adminId) {
        this.adminId = adminId;
    }

    public AdminMaster( String emailId, String phoneNo, String details) {
       
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.details = details;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public UserMaster getUserId() {
        return userId;
    }

    public void setUserId(UserMaster userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminMaster)) {
            return false;
        }
        AdminMaster other = (AdminMaster) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AdminMaster[ adminId=" + adminId + " ]";
    }
    
}
