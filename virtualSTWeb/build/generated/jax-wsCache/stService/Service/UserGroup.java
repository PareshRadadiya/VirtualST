
package Service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userGroupPK" type="{http://Service/}userGroupPK" minOccurs="0"/>
 *         &lt;element ref="{http://Service/}userMaster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userGroup", propOrder = {
    "userGroupPK",
    "userMaster"
})
public class UserGroup {

    protected UserGroupPK userGroupPK;
    @XmlElement(namespace = "http://Service/")
    protected UserMaster userMaster;

    /**
     * Gets the value of the userGroupPK property.
     * 
     * @return
     *     possible object is
     *     {@link UserGroupPK }
     *     
     */
    public UserGroupPK getUserGroupPK() {
        return userGroupPK;
    }

    /**
     * Sets the value of the userGroupPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserGroupPK }
     *     
     */
    public void setUserGroupPK(UserGroupPK value) {
        this.userGroupPK = value;
    }

    /**
     * Gets the value of the userMaster property.
     * 
     * @return
     *     possible object is
     *     {@link UserMaster }
     *     
     */
    public UserMaster getUserMaster() {
        return userMaster;
    }

    /**
     * Sets the value of the userMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserMaster }
     *     
     */
    public void setUserMaster(UserMaster value) {
        this.userMaster = value;
    }

}
