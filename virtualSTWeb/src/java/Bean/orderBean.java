/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;
import Service.OrderMaster;
import Service.TraderStock;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

/**
 *
 * @author paresh
 */
@ManagedBean
@RequestScoped
public class orderBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    private Double orderId;
    private Double traderId;
    private Long volume;
    private Double price;
    private String scriptId;
    private Date orderDate;
    private String orderType;
    private String pending;
    private String operation;
    private String msg;
    private Boolean rend;
    private Date to;
    private Date from;
    private Service.TraderMaster objTrader;
    private List<Service.OrderMaster> objTraderOrder = new ArrayList<Service.OrderMaster>();
    private List<Service.OrderMaster> objData = new ArrayList<Service.OrderMaster>();
    private Map<Double, Boolean> selectedIds = new HashMap<Double, Boolean>();
    private List<Service.OrderMaster> selectedDataList;
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    HttpSession session = request.getSession();

    @PostConstruct
    public void init() {
        Service.StService port = service.getStServicePort();
          objTraderOrder = port.getPendingOrder();
    }

    public String renderForm(Double orderId) {
        Service.StService port = service.getStServicePort();
        System.out.println(orderId);
        Service.OrderMaster data = port.getObjOrderDetails(orderId);
        this.orderId = data.getOrderId();
        traderId = data.getTraderId().getTraderId();
        volume = data.getVolume();
        price = data.getPrice();
        scriptId = data.getScriptId().getScriptId();
        orderDate = data.getOrderDate().toGregorianCalendar().getTime();
        orderType = data.getOrderType();
        pending = data.getPending();
        return "Order_Update";
    }

    public List<Service.OrderMaster> getSelectedItems() {
        Service.StService port = service.getStServicePort();
        selectedDataList = new ArrayList<Service.OrderMaster>();
        for (Service.OrderMaster dataItem : port.getPendingOrder()) {
            System.out.println(dataItem.getOrderId());
            if (selectedIds.get(dataItem.getOrderId())) {
                selectedDataList.add(dataItem);
            }
        }
        selectedIds.clear();
        return selectedDataList;
    }

    // Getters -----------------------------------------------------------------------------------
    public Map<Double, Boolean> getSelectedIds() {
        return selectedIds;
    }

    public List<Service.OrderMaster> getSelectedDataList() {
        return selectedDataList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getRend() {
        return rend;
    }

    public void setRend(Boolean rend) {
        this.rend = rend;
    }

    public orderBean() {
        objData = new ArrayList<Service.OrderMaster>();
    }

    public List<OrderMaster> getObjTraderOrder() {
        return objTraderOrder;
    }

    public void setObjTraderOrder(List<OrderMaster> objTraderOrder) {
        this.objTraderOrder = objTraderOrder;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getOrderId() {
        return orderId;
    }

    public void setOrderId(Double orderId) {
        this.orderId = orderId;
    }

    public Double getTraderId() {
        return traderId;
    }

    public void setTraderId(Double traderId) {
        this.traderId = traderId;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getScriptId() {
        return scriptId;
    }

    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPending() {
        return pending;
    }

    public DataModel<OrderMaster> getObjData() {
        Service.StService port = service.getStServicePort();
        return new ListDataModel(port.getPendingOrder());
    }

    public void setObjData(List<OrderMaster> objData) {
        this.objData = objData;
    }

    public void setSelectedDataList(List<OrderMaster> selectedDataList) {
        this.selectedDataList = selectedDataList;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public String updateOrder() throws Exception {
        Service.StService port = service.getStServicePort();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal);
        port.updateOrder(orderId, traderId, volume, price, scriptId, xcal, orderType, pending);
        operation = "Updated";
        traderId = null;
        objTraderOrder = port.getPendingOrder();
        return "Order";

    }

    public void deleteOrder() {
        Service.StService port = service.getStServicePort();
        Iterator it = getSelectedItems().iterator();
        while (it.hasNext()) {
            Service.OrderMaster data = (Service.OrderMaster) it.next();
            port.deleteOrder(data.getOrderId());

        }
        operation = "Deleted";
        objTraderOrder=port.getPendingOrder();
    }

    public void handleTraderChange() {
        Service.StService port = service.getStServicePort();
        //System.out.println(traderId);
        objTraderOrder = null;
        if (traderId != null) {
            objTraderOrder = port.getOrderDetails1(traderId);
        }



    }

    public void checkStock() {
        Service.StService port = service.getStServicePort();
        if (orderType.equals("S")) {
            TraderStock objTraderStock = port.getObjTraddersStock(traderId, scriptId);

            if (volume <= objTraderStock.getVolume()) {
                msg = "<div class='alert alert-success fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Remaining Stock : " + (objTraderStock.getVolume() - volume) + "</div>";
                rend = false;
            } else if (objTraderStock.getVolume() < volume) {
                msg = "<div class='alert alert-danger fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Have not enough stock for Sell</div>";
                rend = true;
            }
        } else if (orderType.equals("B")) {

            objTrader = port.getObjTrader(traderId);
            Double brokrage = (volume * price * 1.5) / 100;
            if (((volume * price) + brokrage) < objTrader.getFund()) {
                msg = "<div class='alert alert-success fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Remaining Fund : " + (objTrader.getFund() - ((volume * price) + brokrage)) + "</div>";
                rend = false;
            } else {
                msg = "<div class='alert alert-danger fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Have not enough fund for Buy</div>";
                rend = true;
            }
        }

    }

    public void Search() throws Exception {
        Service.StService port = service.getStServicePort();
        Calendar cal = Calendar.getInstance();
        XMLGregorianCalendar toxcal = null;
        XMLGregorianCalendar fromxcal = null;

        if (to != null) {
            cal.setTime(to);
            toxcal = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal);
        }
        if (from != null) {
            cal.setTime(from);
            fromxcal = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal);
        }
        if (scriptId.equals("")) {
            scriptId = null;
        }
        objTraderOrder = port.getPendingOrder1(traderId, orderType, scriptId, toxcal, fromxcal);
        session.setAttribute("objTraderOrder", objTraderOrder);
    }

}
