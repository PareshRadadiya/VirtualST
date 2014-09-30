/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.CityMaster;
import Service.StService_Service;
import Service.TraderMaster;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
 * @author Rushit
 */
@ManagedBean
@RequestScoped
public class traderBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    /**
     * Creates a new instance of traderBean
     */
    private Integer guestId;
    private String pending;
    private Double traderId;
    private String traderName;
    private String guestName;
    private Long brokerId;
    private String userId;
    private Double deposit;
    private String address;
    private String panNo;
    private String phoneNo;
    private String emailId;
    private Double fund;
    private Integer stateId;
    private String stateName;
    private String cityName;
    private String operation;
    private List<Service.CityMaster> objcity = new ArrayList<Service.CityMaster>();
    private List<Service.TraderMaster> objData = new ArrayList<Service.TraderMaster>();
    private List<Service.TraderMaster> objData1 = new ArrayList<Service.TraderMaster>();
    private List<Service.TraderMaster> objData2 = new ArrayList<Service.TraderMaster>();
    private Map<Long, Boolean> selectedIds = new HashMap<Long, Boolean>();
    private List<Service.TraderMaster> selectedDataList;
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    HttpSession session = request.getSession();

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    @PostConstruct
    public void init() {
        Service.StService port = service.getStServicePort();
        objcity = port.getAllCity();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Double getTraderId() {
        return traderId;
    }

    public void setTraderId(Double traderId) {
        this.traderId = traderId;
    }

    public String getTraderName() {
        return traderName;
    }

    public void setTraderName(String traderName) {
        this.traderName = traderName;
    }

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public DataModel<Service.RegistrationMst> getObjData2() {
        Service.StService port = service.getStServicePort();
        return new ListDataModel(port.getPendingRegistation());
    }

    public void setObjData2(List<TraderMaster> objData2) {
        this.objData2 = objData2;
    }

    public DataModel<Service.TraderMaster> getObjData() {
        Service.StService port = service.getStServicePort();
        return new ListDataModel(port.getTraderByBrokerId(Long.valueOf(session.getAttribute("user").toString())));
    }

    public void setObjData(List<TraderMaster> objData) {
        this.objData = objData;
    }

    public DataModel<Service.TraderMaster> getObjData1() {
        Service.StService port = service.getStServicePort();
        traderId = Double.valueOf(String.valueOf(session.getAttribute("user")));
        return new ListDataModel(port.getTraderDetails1(traderId));
    }

    public void setObjData1(List<TraderMaster> objData1) {
        this.objData1 = objData1;
    }

    public Map<Long, Boolean> getSelectedIds() {
        return selectedIds;
    }

    public void setSelectedIds(Map<Long, Boolean> selectedIds) {
        this.selectedIds = selectedIds;
    }

    public List<TraderMaster> getSelectedDataList() {
        return selectedDataList;
    }

    public void setSelectedDataList(List<TraderMaster> selectedDataList) {
        this.selectedDataList = selectedDataList;
    }

    public Double getFund() {
        return fund;
    }

    public void setFund(Double fund) {
        this.fund = fund;
    }

    public traderBean() {
    }

    public List<Service.TraderMaster> getSelectedItems() {
        Service.StService port = service.getStServicePort();
        selectedDataList = new ArrayList<Service.TraderMaster>();
        for (Service.TraderMaster dataItem : port.getTraderDetails()) {
            if (selectedIds.get(dataItem.getTraderId())) {
                selectedDataList.add(dataItem);
            }
        }
        selectedIds.clear();
        return selectedDataList;
    }

    public String renderForm(Long traderId) {

        Service.StService port = service.getStServicePort();
        Iterator it = port.getTraderDetails1(Double.valueOf(traderId)).iterator();
        while (it.hasNext()) {
            Service.TraderMaster data = (Service.TraderMaster) it.next();
            this.traderId = data.getTraderId();
            traderName = data.getTraderName();
            brokerId = data.getBrokerId().getBrokerId();
            userId = data.getUserId().getUserId();
            deposit = data.getDeposit();
            address = data.getAddress();
            cityName = data.getCity();
            Iterator it1 = port.getState(data.getStat()).iterator();
            while (it1.hasNext()) {
                Service.StateMaster objState = (Service.StateMaster) it1.next();
                stateId = objState.getStateId();
            }
            panNo = data.getPanNo();
            phoneNo = data.getPhoneNo();
            emailId = data.getEmailId();
            fund = data.getFund();
            session.setAttribute("action", "update");
        }

        return "Trader_Add";
    }

    public String renderForm2(Long traderId) {

        Service.StService port = service.getStServicePort();
        Iterator it = port.getTraderDetails1(Double.valueOf(traderId)).iterator();
        while (it.hasNext()) {
            Service.TraderMaster data = (Service.TraderMaster) it.next();
            this.traderId = data.getTraderId();
            traderName = data.getTraderName();
            brokerId = data.getBrokerId().getBrokerId();
            userId = data.getUserId().getUserId();
            deposit = data.getDeposit();
            address = data.getAddress();
            cityName = data.getCity();
            Iterator it1 = port.getState(data.getStat()).iterator();
            while (it1.hasNext()) {
                Service.StateMaster objState = (Service.StateMaster) it1.next();
                stateId = objState.getStateId();
            }
            panNo = data.getPanNo();
            phoneNo = data.getPhoneNo();
            emailId = data.getEmailId();
            fund = data.getFund();
            session.setAttribute("action", "update2");
        }

        return "TraderProfile_Edit";
    }

    public String addTrader() throws Exception {
        Service.StService port = service.getStServicePort();
        MessageDigest objDigest = MessageDigest.getInstance("MD5");
        objDigest.update(traderName.getBytes(), 0, traderName.length());
        String password = new BigInteger(1, objDigest.digest()).toString(16);
        port.addUser(traderName, password);
        port.addUserSGroup(traderName, "trader");
        brokerId = Long.valueOf(session.getAttribute("user").toString());
        port.addTrader(traderName, brokerId, traderName, deposit, address, port.getObjState(stateId).getStateName(), cityName, panNo, phoneNo, emailId);
        operation = "Added";
        objData = null;
        return "Trader";
    }

    public void deleteTrader() {
        Service.StService port = service.getStServicePort();
        Iterator it = getSelectedItems().iterator();
        while (it.hasNext()) {
            Service.TraderMaster data = (Service.TraderMaster) it.next();
            port.deleteTrader(data.getTraderId());
            port.deleteUserGroup(data.getUserId().getUserId(), "trader");
            port.deleteUser(data.getUserId().getUserId());
        }
        objData = null;
        operation = "Deleted";
    }

    public String updateTrader() {
        Service.StService port = service.getStServicePort();
        port.updateTrader(traderId, traderName, brokerId, userId, deposit, address, port.getObjState(stateId).getStateName(), cityName, panNo, phoneNo, emailId, fund);
        operation = "Updated";
        session.setAttribute("action", "add");

        return "Trader";

    }

    public String updateTrader1() throws Exception {
        Service.StService port = service.getStServicePort();
        MessageDigest objDigest = MessageDigest.getInstance("MD5");
        objDigest.update(traderName.getBytes(), 0, traderName.length());
        String password = new BigInteger(1, objDigest.digest()).toString(16);
        port.addUser(traderName, password);
        port.addUserSGroup(traderName, "trader");
        brokerId = Long.valueOf(session.getAttribute("user").toString());
        port.addTrader(traderName, brokerId, traderName, deposit, address, port.getObjState(stateId).getStateName(), cityName, panNo, phoneNo, emailId);
        port.updateRegistration(guestId, guestName, emailId, phoneNo, address, brokerId, "No");
        operation = "Added";
        session.setAttribute("action", "add");

        return "Trader";
    }

    public String updateTrader2() throws Exception {
        Service.StService port = service.getStServicePort();
        MessageDigest objDigest = MessageDigest.getInstance("MD5");
        objDigest.update(traderName.getBytes(), 0, traderName.length());
        String password = new BigInteger(1, objDigest.digest()).toString(16);
        port.deleteUserGroup(traderName, "trader");
        port.updateUser(traderName, password);
        port.addUserSGroup(traderName, "trader");
        brokerId = Long.valueOf(String.valueOf(session.getAttribute("user")));

        userId = session.getAttribute("username").toString();

        port.updateTrader(traderId, traderName, brokerId, userId, deposit, address, port.getObjState(stateId).getStateName(), cityName, panNo, phoneNo, emailId, fund);
        operation = "Updated";
        session.setAttribute("action", "add");

        return "TraderProfile";
    }

    public java.util.List<Service.TraderMaster> getTraderDetails() {
        Service.StService port = service.getStServicePort();
        return port.getTraderDetails();
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

    public void addTraderFund() {
        Service.StService port = service.getStServicePort();
        port.addTraderFund(traderId, fund);
        operation = "Added";
    }

    public void addNew(Integer id) throws NoSuchAlgorithmException {
        Service.StService port = service.getStServicePort();
        Service.RegistrationMst objReg = port.getRegistrationDetails1(id);
        MessageDigest objDigest = MessageDigest.getInstance("MD5");
        objDigest.update(objReg.getGuestName().getBytes(), 0, objReg.getGuestName().length());
        String password = new BigInteger(1, objDigest.digest()).toString(16);
        port.addUser(objReg.getGuestName(), password);
        port.addUserSGroup(objReg.getGuestName(), "trader");
        brokerId = Long.valueOf(session.getAttribute("user").toString());
        operation = "Added";
        port.addTrader(objReg.getGuestName(), objReg.getBrokerId().getBrokerId(), objReg.getGuestName(), 0.0, objReg.getAddress(), objReg.getStat(), objReg.getCity(), String.valueOf(objReg.getPanNo()), objReg.getPhoneNo(), objReg.getEmailId());
        port.updateRegistration(id, objReg.getGuestName(), objReg.getEmailId(), objReg.getPanNo(), objReg.getAddress(), objReg.getBrokerId().getBrokerId(), "No");
    }
}
