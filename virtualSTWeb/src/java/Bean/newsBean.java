/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.NewsMaster;
import Service.StService_Service;
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

@ManagedBean
@RequestScoped
public class newsBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    private String topic;
    private String details;
    private Long newsId;
    private String operation;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    
    
    public DataModel<Service.NewsMaster> getObjData() {
        Service.StService port = service.getStServicePort();
        return new ListDataModel(port.getNewsDetails());
    }

    public void setObjData(List<NewsMaster> objData) {
        this.objData = objData;
    }

    public Map<Long, Boolean> getSelectedIds() {
        return selectedIds;
    }

    public void setSelectedIds(Map<Long, Boolean> selectedIds) {
        this.selectedIds = selectedIds;
    }

    public List<NewsMaster> getSelectedDataList() {
        return selectedDataList;
    }

    public void setSelectedDataList(List<NewsMaster> selectedDataList) {
        this.selectedDataList = selectedDataList;
    }
    private List<Service.NewsMaster> objData = new ArrayList<Service.NewsMaster>();
    private Map<Long, Boolean> selectedIds = new HashMap<Long, Boolean>();
    private List<Service.NewsMaster> selectedDataList;

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public newsBean() {
        objData = new ArrayList<Service.NewsMaster>();
    }

    public String addNews() {
        Service.StService port = service.getStServicePort();
        port.addNews(topic, details);
        operation="Added";
         return "news";
    }

    public List<Service.NewsMaster> getSelectedItems() {
        Service.StService port = service.getStServicePort();
        selectedDataList = new ArrayList<Service.NewsMaster>();
        for (Service.NewsMaster dataItem : port.getNewsDetails()) {
            if (selectedIds.get(dataItem.getNewsId())) {
                selectedDataList.add(dataItem);
            }
        }
        selectedIds.clear();
        return selectedDataList;
    }

    public String renderForm(Long newsId) {

        Service.StService port = service.getStServicePort();
        Iterator it = port.getNewsDetails1(newsId).iterator();
        while (it.hasNext()) {
            Service.NewsMaster data = (Service.NewsMaster) it.next();
            this.newsId = data.getNewsId();
            topic = data.getTopic();
            details = data.getDetails();

        }

        return "news_Add";
    }

    public void deleteNews() {
        Service.StService port = service.getStServicePort();
        Iterator it = getSelectedItems().iterator();
        while (it.hasNext()) {
            Service.NewsMaster data = (Service.NewsMaster) it.next();
            port.deleteNews(data.getNewsId());
        }
        operation="Deleted";
    }

    public String updateNews() {
        Service.StService port = service.getStServicePort();
        port.updateNews(newsId, topic, details);
        operation="Updated";
        return "news";
    }
}
