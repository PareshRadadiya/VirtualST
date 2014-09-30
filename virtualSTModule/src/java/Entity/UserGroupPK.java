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
public class UserGroupPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "group_type")
    private String groupType;

    public UserGroupPK() {
    }

    public UserGroupPK(String userId, String groupType) {
        this.userId = userId;
        this.groupType = groupType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        hash += (groupType != null ? groupType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGroupPK)) {
            return false;
        }
        UserGroupPK other = (UserGroupPK) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        if ((this.groupType == null && other.groupType != null) || (this.groupType != null && !this.groupType.equals(other.groupType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.UserGroupPK[ userId=" + userId + ", groupType=" + groupType + " ]";
    }
    
}
