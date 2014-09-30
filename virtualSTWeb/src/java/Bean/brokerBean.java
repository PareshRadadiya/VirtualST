/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.BrokerMaster;
import Service.CityMaster;
import Service.StService_Service;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author xyz
 */
@ManagedBean
@RequestScoped
public class brokerBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    private Long brokerId;
    private String brokerName;
    private String userId;
    private String correspondOffice;
    private String clearingNo;
    private String tradeName;
    private String corporateEmail;
    private String sebiNo;
    private Double deposit;
    private Double fund;
    private String phoneNo;
    private List<Service.BrokerMaster> objData = new ArrayList<Service.BrokerMaster>();
    private List<Service.BrokerMaster> objData1 = new ArrayList<Service.BrokerMaster>();
    private Integer stateId;
    private String stateName;
    private String cityName;
    private String operation;
    
    private List<Service.CityMaster> objcity = new ArrayList<Service.CityMaster>();
    private Map<Long, Boolean> selectedIds = new HashMap<Long, Boolean>();
    private List<Service.BrokerMaster> selectedDataList;
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    HttpSession session = request.getSession();

    @PostConstruct
    public void init() {
        Service.StService port = service.getStServicePort();
        objcity = port.getAllCity();
       
     
    }

    public String renderForm(Long brokerId) {

        Service.StService port = service.getStServicePort();
        Iterator it = port.getBrokerDetails1(brokerId).iterator();
        while (it.hasNext()) {
            Service.BrokerMaster data = (Service.BrokerMaster) it.next();
            this.brokerId = data.getBrokerId();
            brokerName = data.getBrokerName();
            userId = data.getUserId().getUserId();
            correspondOffice = data.getCorrespondOffice();
            phoneNo = data.getPhoneNo();
            cityName = data.getCity();
            Iterator it1 = port.getState(data.getStat()).iterator();
            while (it1.hasNext()) {
                Service.StateMaster objState = (Service.StateMaster) it1.next();
                stateId = objState.getStateId();
            }
            clearingNo = data.getClearingNo();
            tradeName = data.getTradeName();
            corporateEmail = data.getCorporateEmail();
            sebiNo = data.getSebiNo();
            deposit = data.getDeposit();
            fund = data.getFund();
            session.setAttribute("action", "update");
        }

        return "Broker_Add";
    }
    public String renderForm1(Long brokerId) {

        Service.StService port = service.getStServicePort();
        Iterator it = port.getBrokerDetails1(brokerId).iterator();
        while (it.hasNext()) {
            Service.BrokerMaster data = (Service.BrokerMaster) it.next();
            this.brokerId = data.getBrokerId();
            brokerName = data.getBrokerName();
            userId = data.getUserId().getUserId();
            correspondOffice = data.getCorrespondOffice();
            phoneNo = data.getPhoneNo();
            cityName = data.getCity();
            Iterator it1 = port.getState(data.getStat()).iterator();
            while (it1.hasNext()) {
                Service.StateMaster objState = (Service.StateMaster) it1.next();
                stateId = objState.getStateId();
            }
            clearingNo = data.getClearingNo();
            tradeName = data.getTradeName();
            corporateEmail = data.getCorporateEmail();
            sebiNo = data.getSebiNo();
            deposit = data.getDeposit();
            fund = data.getFund();
            session.setAttribute("action", "update1");
        }

        return "Broker_Edit";
    }

    // System.out.println(objReq.getParameter("id"));
    // Actions -----------------------------------------------------------------------------------
    public List<Service.BrokerMaster> getSelectedItems() {
        Service.StService port = service.getStServicePort();
        selectedDataList = new ArrayList<Service.BrokerMaster>();
        for (Service.BrokerMaster dataItem : port.getBrokerDetails()) {
            if (selectedIds.get(dataItem.getBrokerId())) {
                selectedDataList.add(dataItem);
            }
        }
        selectedIds.clear();
        return selectedDataList;
    }

    // Getters -----------------------------------------------------------------------------------
    public Map<Long, Boolean> getSelectedIds() {
        return selectedIds;
    }

    public List<Service.BrokerMaster> getSelectedDataList() {
        return selectedDataList;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public DataModel<Service.BrokerMaster> getObjData() {
        Service.StService port = service.getStServicePort();
        return new ListDataModel(port.getBrokerDetails());
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setObjData(List<BrokerMaster> objData) {
        this.objData = objData;
    }

    public DataModel<Service.BrokerMaster> getObjData1() {
        Service.StService port = service.getStServicePort();
        brokerId=Long.valueOf(String.valueOf(session.getAttribute("user")));
        return new ListDataModel(port.getBrokerDetails1(brokerId));
    }

    public void setObjData1(List<BrokerMaster> objData1) {
        this.objData1 = objData1;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCorrespondOffice() {
        return correspondOffice;
    }

    public void setCorrespondOffice(String correspondOffice) {
        this.correspondOffice = correspondOffice;
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

    public String getSebiNo() {
        return sebiNo;
    }

    public void setSebiNo(String sebiNo) {
        this.sebiNo = sebiNo;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getFund() {
        return fund;
    }

    public void setFund(Double fund) {
        this.fund = fund;
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

    public List<CityMaster> getObjcity() {
        return objcity;
    }

    public void setObjcity(List<CityMaster> objcity) {
        this.objcity = objcity;
    }

    public String addBroker() throws Exception {
        Service.StService port = service.getStServicePort();
        MessageDigest objDigest = MessageDigest.getInstance("MD5");
        objDigest.update(brokerName.getBytes(), 0, brokerName.length());
        String password = new BigInteger(1, objDigest.digest()).toString(16);
        port.addUser(brokerName, password);
        port.addUserSGroup(brokerName, "broker");

        port.addBroker(brokerName, brokerName, correspondOffice, port.getObjState(stateId).getStateName(), cityName, clearingNo, tradeName, corporateEmail, phoneNo, sebiNo, deposit);
        operation = "Added";
        return "Broker";
    }

    public void deleteBroker() {
        Service.StService port = service.getStServicePort();
        Iterator it = getSelectedItems().iterator();
        while (it.hasNext()) {
            Service.BrokerMaster data = (Service.BrokerMaster) it.next();
            port.deleteBroker(data.getBrokerId());
            port.deleteUserGroup(data.getUserId().getUserId(), "broker");
            port.deleteUser(data.getUserId().getUserId());
        }
        operation = "Deleted";
    }

    public String updateBroker() {

        Service.StService port = service.getStServicePort();
        port.updateBroker(brokerId, brokerName, userId, correspondOffice, port.getObjState(stateId).getStateName(), cityName, clearingNo, tradeName, corporateEmail, phoneNo, sebiNo, deposit, fund);
        operation = "Updated";
        session.setAttribute("action", "add");
        return "Broker";
    }
    public String updateBroker1() throws Exception{
        
        Service.StService port = service.getStServicePort();
        MessageDigest objDigest = MessageDigest.getInstance("MD5");
        objDigest.update(brokerName.getBytes(), 0, brokerName.length());
        String password = new BigInteger(1, objDigest.digest()).toString(16);
        port.deleteUserGroup(brokerName, "broker");
        port.updateUser(brokerName, password);
        port.addUserSGroup(brokerName, "broker");
        port.updateBroker(brokerId, brokerName, userId, correspondOffice, port.getObjState(stateId).getStateName(), cityName, clearingNo, tradeName, corporateEmail, phoneNo, sebiNo, deposit, fund);
        operation = "Updated";
        session.setAttribute("action", "add");
        return "Broker_Profile";
    }

    

    public List<Service.StateMaster> getAllStates() {
        Service.StService port = service.getStServicePort();
        return port.getAllStates();
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
