/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.CityMaster;
import Service.StService_Service;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Rushit
 */
@ManagedBean
@RequestScoped
public class registrationBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    private Integer guestId;
    private String guestName;
    private String emailId;
    private String phoneNo;
    private String address;
    private Integer stateId;
    private String stateName;
    private String cityName;
    private String pincode;
    private Long brokerId;
    private String pending;
    private String panNo;
    private String pin;
    private List<Service.CityMaster> objcity = new ArrayList<Service.CityMaster>();

    @PostConstruct
    public void init() {
        Service.StService port = service.getStServicePort();
        objcity = port.getAllCity();


    }

    public List<Service.StateMaster> getAllStates() {
        Service.StService port = service.getStServicePort();
        return port.getAllStates();
    }

    public List<CityMaster> getObjcity() {
        return objcity;
    }

    public void setObjcity(List<CityMaster> objcity) {
        this.objcity = objcity;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
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

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getTraderName() {
        return guestName;
    }

    public void setTraderName(String guestName) {
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

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public registrationBean() {
    }

    public java.util.List<Service.BrokerMaster> getBrokerDetails() {
        Service.StService port = service.getStServicePort();
        return port.getBrokerDetails();
    }

    public String registrationTrader() {
        Service.StService port = service.getStServicePort();
        port.registrationTrader(guestName, emailId, phoneNo, address, port.getObjState(stateId).getStateName(), cityName, pin, panNo, brokerId, "Yes");
        // port.registrationTrader(guestName, emailId, phoneNo, address, brokerId, "Yes");
        return "index";
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void handleCityChange() {
        Service.StService port = service.getStServicePort();
        if (stateId != null && stateId != 0) {
            objcity = port.getCityByState(stateId);
        } else {
            objcity = new ArrayList<Service.CityMaster>();
        }
    }
}
