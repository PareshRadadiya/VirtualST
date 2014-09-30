/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.AdminMaster;
import Service.StService_Service;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Rushit
 */
@ManagedBean
@RequestScoped
public class adminBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    private Integer adminId;
    private String userId;
    private String emailId;
    private String phoneNo;
    private String details;
    private List<Service.AdminMaster> objData = new ArrayList<Service.AdminMaster>();
    private Map<Long, Boolean> selectedIds = new HashMap<Long, Boolean>();
    private List<Service.AdminMaster> selectedDataList;
    private String operation;

    public Integer getAdminId() {
        return adminId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public DataModel<Service.AdminMaster> getObjData() {
        Service.StService port = service.getStServicePort();
        return new ListDataModel(port.getAdminDetails());
    }

    public void setObjData(List<AdminMaster> objData) {
        this.objData = objData;
    }

    public Map<Long, Boolean> getSelectedIds() {
        return selectedIds;
    }

    public void setSelectedIds(Map<Long, Boolean> selectedIds) {
        this.selectedIds = selectedIds;
    }

    public List<AdminMaster> getSelectedDataList() {
        return selectedDataList;
    }

    public void setSelectedDataList(List<AdminMaster> selectedDataList) {
        this.selectedDataList = selectedDataList;
    }

    public List<Service.AdminMaster> getSelectedItems() {
        Service.StService port = service.getStServicePort();
        selectedDataList = new ArrayList<Service.AdminMaster>();
        for (Service.AdminMaster dataItem : port.getAdminDetails()) {
            if (selectedIds.get(dataItem.getAdminId())) {
                selectedDataList.add(dataItem);
            }
        }
        selectedIds.clear();
        return selectedDataList;
    }

    public adminBean() {
        objData = new ArrayList<Service.AdminMaster>();
    }

    public String addAdmin() throws Exception {
        Service.StService port = service.getStServicePort();
        MessageDigest objDigest = MessageDigest.getInstance("MD5");
        objDigest.update(userId.getBytes(), 0, userId.length());
        String password = new BigInteger(1, objDigest.digest()).toString(16);
        port.addUser(userId, password);
        port.addUserSGroup(userId, "admin");
        port.addAdmin(userId, emailId, phoneNo, details);
        operation = "Added";
        return "AdminUser";
    }

    public void deleteAdmin() {
        Service.StService port = service.getStServicePort();
        Iterator it = getSelectedItems().iterator();
        while (it.hasNext()) {
            Service.AdminMaster data = (Service.AdminMaster) it.next();

            port.deleteAdmin(data.getAdminId());
            port.deleteUserGroup(data.getUserId().getUserId(), "admin");
            port.deleteUser(data.getUserId().getUserId());

        }
        operation = "Deleted";
    }
}
