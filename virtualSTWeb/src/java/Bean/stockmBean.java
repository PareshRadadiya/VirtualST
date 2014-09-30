/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.CityMaster;
import Service.StService_Service;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author paresh
 */
@ManagedBean
@RequestScoped
public class stockmBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    private String scriptId;
    private String scriptCode;
    private String groupType;
    private String industry;
    private Integer marketLot;
    private Date listingDate;
    private Integer faceValue;
    private String companyName;
    private String address;
    private Integer stateId;
    private String stateName;
    private String cityName;
    private String phoneno;
    private String fax;
    private String emailId;
    private String director;
    private String website;
    private String operation;
    private List<Service.CityMaster> objcity = new ArrayList<Service.CityMaster>();
    private List<Service.StockDetails> objData = new ArrayList<Service.StockDetails>();
    private Map<Long, Boolean> selectedIds = new HashMap<Long, Boolean>();
    private List<Service.StockDetails> selectedDataList;
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    HttpSession session = request.getSession();

    @PostConstruct
    public void init() {
        Service.StService port = service.getStServicePort();
        objcity = port.getAllCity();
    }

    public String renderForm(String scriptId) {

        Service.StService port = service.getStServicePort();
        Iterator it = port.getStockDetails1(scriptId).iterator();
        while (it.hasNext()) {
            Service.StockDetails data = (Service.StockDetails) it.next();
            this.scriptId = data.getScriptId();
            scriptCode = data.getScriptCode();
            groupType = data.getGroupType();
            industry = data.getIndustry();
            marketLot = data.getMarketLot();
            listingDate = data.getListingDate().toGregorianCalendar().getTime();
            faceValue = data.getFaceValue();
            companyName = data.getCompanyName();
            address = data.getAddress();
            cityName = data.getCity();
            Iterator it1 = port.getState(data.getStat()).iterator();
            while (it1.hasNext()) {
                Service.StateMaster objState = (Service.StateMaster) it1.next();
                stateId = objState.getStateId();
            }
            phoneno = data.getPhoneNo();
            fax = data.getFax();
            emailId = data.getEmailId();
            director = data.getDirector();
            website = data.getWebsite();
            session.setAttribute("action", "update");
        }
        return "Stock_Add";
    }

    // System.out.println(objReq.getParameter("id"));
    // Actions -----------------------------------------------------------------------------------
    public List<Service.StockDetails> getSelectedItems() {
        Service.StService port = service.getStServicePort();
        selectedDataList = new ArrayList<Service.StockDetails>();
        for (Service.StockDetails dataItem : port.getStockDetails()) {
            if (selectedIds.get(dataItem.getScriptId())) {
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

    public List<Service.StockDetails> getSelectedDataList() {
        return selectedDataList;
    }

    public DataModel<Service.StockDetails> getObjData() {
        Service.StService port = service.getStServicePort();
        return new ListDataModel(port.getStockDetails());
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
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

    public Integer getMarketLot() {
        return marketLot;
    }

    public void setMarketLot(Integer marketLot) {
        this.marketLot = marketLot;
    }

    public Date getListingDate() {
        return listingDate;
    }

    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    public Integer getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Integer faceValue) {
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

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
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

    public String addStock() throws DatatypeConfigurationException {
        Service.StService port = service.getStServicePort();
        Calendar cal = Calendar.getInstance();
        cal.setTime(listingDate);
        XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal);

        port.addStock(scriptId, scriptCode, groupType, industry, marketLot, xcal, faceValue, companyName, address, port.getObjState(stateId).getStateName(), cityName, phoneno, fax, emailId, director, website);
        operation = "Added";
        return "Stock";
    }

    public String updateStock() throws DatatypeConfigurationException {
        try {
            Service.StService port = service.getStServicePort();
            Calendar cal = Calendar.getInstance();
            cal.setTime(listingDate);
            XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal);

            port.updateStock(scriptId, scriptCode, groupType, industry, marketLot, xcal, faceValue, companyName, address, port.getObjState(stateId).getStateName(), cityName, phoneno, fax, emailId, director, website);
            session.setAttribute("action", "add");
            operation = "Updated";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Stock";
    }

    public void deleteStock() {
        Service.StService port = service.getStServicePort();
        Iterator it = getSelectedItems().iterator();
        while (it.hasNext()) {
            Service.StockDetails data = (Service.StockDetails) it.next();
            port.deleteStock(data.getScriptId());
        }
        operation = "Deleted";
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
