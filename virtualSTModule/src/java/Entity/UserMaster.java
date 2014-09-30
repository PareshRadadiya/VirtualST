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
import javax.persistence.Id;
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
@Table(name = "user_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMaster.findAll", query = "SELECT u FROM UserMaster u"),
    @NamedQuery(name = "UserMaster.findByUserId", query = "SELECT u FROM UserMaster u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserMaster.findByPassword", query = "SELECT u FROM UserMaster u WHERE u.password = :password")})
public class UserMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.EAGER)
    private List<BrokerMaster> brokerMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userMaster", fetch = FetchType.EAGER)
    private List<UserGroup> userGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.EAGER)
    private List<TraderMaster> traderMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.EAGER)
    private List<AdminMaster> adminMasterList;

    public UserMaster() {
    }

    public UserMaster(String userId) {
        this.userId = userId;
    }

    public UserMaster(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<BrokerMaster> getBrokerMasterList() {
        return brokerMasterList;
    }

    public void setBrokerMasterList(List<BrokerMaster> brokerMasterList) {
        this.brokerMasterList = brokerMasterList;
    }

    @XmlTransient
    public List<UserGroup> getUserGroupList() {
        return userGroupList;
    }

    public void setUserGroupList(List<UserGroup> userGroupList) {
        this.userGroupList = userGroupList;
    }

    @XmlTransient
    public List<TraderMaster> getTraderMasterList() {
        return traderMasterList;
    }

    public void setTraderMasterList(List<TraderMaster> traderMasterList) {
        this.traderMasterList = traderMasterList;
    }

    @XmlTransient
    public List<AdminMaster> getAdminMasterList() {
        return adminMasterList;
    }

    public void setAdminMasterList(List<AdminMaster> adminMasterList) {
        this.adminMasterList = adminMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMaster)) {
            return false;
        }
        UserMaster other = (UserMaster) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.UserMaster[ userId=" + userId + " ]";
    }
    
}
