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
import javax.persistence.Id;
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
@Table(name = "stock_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockDetails.findAll", query = "SELECT s FROM StockDetails s"),
    @NamedQuery(name = "StockDetails.findByScriptId", query = "SELECT s FROM StockDetails s WHERE s.scriptId = :scriptId"),
    @NamedQuery(name = "StockDetails.findByScriptCode", query = "SELECT s FROM StockDetails s WHERE s.scriptCode = :scriptCode"),
    @NamedQuery(name = "StockDetails.findByGroupType", query = "SELECT s FROM StockDetails s WHERE s.groupType = :groupType"),
    @NamedQuery(name = "StockDetails.findByIndustry", query = "SELECT s FROM StockDetails s WHERE s.industry = :industry"),
    @NamedQuery(name = "StockDetails.findByMarketLot", query = "SELECT s FROM StockDetails s WHERE s.marketLot = :marketLot"),
    @NamedQuery(name = "StockDetails.findByListingDate", query = "SELECT s FROM StockDetails s WHERE s.listingDate = :listingDate"),
    @NamedQuery(name = "StockDetails.findByFaceValue", query = "SELECT s FROM StockDetails s WHERE s.faceValue = :faceValue"),
    @NamedQuery(name = "StockDetails.findByCompanyName", query = "SELECT s FROM StockDetails s WHERE s.companyName = :companyName"),
    @NamedQuery(name = "StockDetails.findByAddress", query = "SELECT s FROM StockDetails s WHERE s.address = :address"),
    @NamedQuery(name = "StockDetails.findByStat", query = "SELECT s FROM StockDetails s WHERE s.stat = :stat"),
    @NamedQuery(name = "StockDetails.findByCity", query = "SELECT s FROM StockDetails s WHERE s.city = :city"),
    @NamedQuery(name = "StockDetails.findByPhoneNo", query = "SELECT s FROM StockDetails s WHERE s.phoneNo = :phoneNo"),
    @NamedQuery(name = "StockDetails.findByFax", query = "SELECT s FROM StockDetails s WHERE s.fax = :fax"),
    @NamedQuery(name = "StockDetails.findByEmailId", query = "SELECT s FROM StockDetails s WHERE s.emailId = :emailId"),
    @NamedQuery(name = "StockDetails.findByDirector", query = "SELECT s FROM StockDetails s WHERE s.director = :director"),
    @NamedQuery(name = "StockDetails.findByWebsite", query = "SELECT s FROM StockDetails s WHERE s.website = :website")})
public class StockDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "script_id")
    private String scriptId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "script_code")
    private String scriptCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "group_type")
    private String groupType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "industry")
    private String industry;
    @Basic(optional = false)
    @NotNull
    @Column(name = "market_lot")
    private int marketLot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "listing_date")
    @Temporal(TemporalType.DATE)
    private Date listingDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "face_value")
    private int faceValue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "company_name")
    private String companyName;
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
    @Size(min = 1, max = 15)
    @Column(name = "phone_no")
    private String phoneNo;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "fax")
    private String fax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email_id")
    private String emailId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "director")
    private String director;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "website")
    private String website;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stockDetails", fetch = FetchType.EAGER)
    private List<TraderStock> traderStockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scriptId", fetch = FetchType.EAGER)
    private List<OrderMaster> orderMasterList;

    public StockDetails() {
    }

    public StockDetails(String scriptId) {
        this.scriptId = scriptId;
    }

    public StockDetails(String scriptId, String scriptCode, String groupType, String industry, int marketLot, Date listingDate, int faceValue, String companyName, String address, String stat, String city, String phoneNo, String fax, String emailId, String director, String website) {
        this.scriptId = scriptId;
        this.scriptCode = scriptCode;
        this.groupType = groupType;
        this.industry = industry;
        this.marketLot = marketLot;
        this.listingDate = listingDate;
        this.faceValue = faceValue;
        this.companyName = companyName;
        this.address = address;
        this.stat = stat;
        this.city = city;
        this.phoneNo = phoneNo;
        this.fax = fax;
        this.emailId = emailId;
        this.director = director;
        this.website = website;
    }

    public String getScriptId() {
        return scriptId;
    }

    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptCode() {
        return scriptCode;
    }

    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getMarketLot() {
        return marketLot;
    }

    public void setMarketLot(int marketLot) {
        this.marketLot = marketLot;
    }

    public Date getListingDate() {
        return listingDate;
    }

    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @XmlTransient
    public List<TraderStock> getTraderStockList() {
        return traderStockList;
    }

    public void setTraderStockList(List<TraderStock> traderStockList) {
        this.traderStockList = traderStockList;
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
        hash += (scriptId != null ? scriptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockDetails)) {
            return false;
        }
        StockDetails other = (StockDetails) object;
        if ((this.scriptId == null && other.scriptId != null) || (this.scriptId != null && !this.scriptId.equals(other.scriptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StockDetails[ scriptId=" + scriptId + " ]";
    }
    
}
