/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.StService_Service;
import Service.TransactionDetails;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author paresh
 */
@ManagedBean
@RequestScoped
public class transactionBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    private List<Service.TransactionDetails> objTraderTrans = new ArrayList<Service.TransactionDetails>();
    private Double traderId;
    private String orderType;
    private String scriptId;
    private Date to;
    private Date from;
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    HttpSession session = request.getSession();

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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getScriptId() {
        return scriptId;
    }

    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }

    public Double getTraderId() {
        return traderId;
    }

    public void setTraderId(Double traderId) {
        this.traderId = traderId;
    }

    /**
     * Creates a new instance of transactionBean
     */
    public transactionBean() {
    }

    public List<TransactionDetails> getObjTraderTrans() {
        return objTraderTrans;
    }

    public void setObjTraderTrans(List<TransactionDetails> objTraderTrans) {
        this.objTraderTrans = objTraderTrans;
    }

    public List getTransactionDetails() {
        Service.StService port = service.getStServicePort();
        return port.getTransactionDetails();
    }

    public void handleTraderChange() {
        Service.StService port = service.getStServicePort();
        if (traderId != null) {
            objTraderTrans = port.getTransactionDetails1(traderId);
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
        objTraderTrans = port.getTransactionDetails3(traderId, orderType, scriptId, toxcal, fromxcal);
        session.setAttribute("objTraderTrans", objTraderTrans);
    }
}
