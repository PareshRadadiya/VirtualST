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
@Table(name = "city_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CityMaster.findAll", query = "SELECT c FROM CityMaster c"),
    @NamedQuery(name = "CityMaster.findByCityId", query = "SELECT c FROM CityMaster c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "CityMaster.findByCityName", query = "SELECT c FROM CityMaster c WHERE c.cityName = :cityName")})
public class CityMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "city_id")
    private Integer cityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "city_name")
    private String cityName;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private StateMaster stateId;

    public CityMaster() {
    }

    public CityMaster(Integer cityId) {
        this.cityId = cityId;
    }

    public CityMaster(Integer cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public StateMaster getStateId() {
        return stateId;
    }

    public void setStateId(StateMaster stateId) {
        this.stateId = stateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityMaster)) {
            return false;
        }
        CityMaster other = (CityMaster) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CityMaster[ cityId=" + cityId + " ]";
    }
    
}
