/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.BrokerMaster;
import Service.StService_Service;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author paresh
 */
@ManagedBean
@RequestScoped
public class homeBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    HttpSession session = request.getSession();
    private Double fund;
    private Double deposit;
    Service.BrokerMaster objBroker;
    Service.TraderMaster objTrader;
    private Integer user;
    private Integer sell;
    private Integer buy;
    private Integer all;
    private Double comision;
    private String broker;
    private Integer noBroker;
    private Integer noTrader;
    @PostConstruct
    public void init() {
        Service.StService port = service.getStServicePort();
        if (session.getAttribute("usertype").equals("Broker")) {
            Service.BrokerMaster objBroker = port.getObjBroker(Long.valueOf(session.getAttribute("user").toString()));
            fund = objBroker.getFund();
            deposit = objBroker.getDeposit();
            user = port.getTraderByBrokerId(objBroker.getBrokerId()).size();
            sell = port.getTransactionSell(objBroker.getBrokerId()).size();
            buy = port.getTransactionBuy(objBroker.getBrokerId()).size();
            all = port.getTransactionDetails2(objBroker.getBrokerId()).size();
            comision = 0.0;
            Iterator it = port.getTransactionDetails2(Long.valueOf(session.getAttribute("user").toString())).iterator();
            while (it.hasNext()) {
                Service.TransactionDetails objTransaction = (Service.TransactionDetails) it.next();
                comision = comision + objTransaction.getBrokrage();
            }
        } else if (session.getAttribute("usertype").equals("Trader")) {
            objTrader = port.getObjTrader(Double.valueOf(session.getAttribute("user").toString()));
            fund = objTrader.getFund();
            deposit = objTrader.getDeposit();
            sell = port.getTransactionSell1(objTrader.getTraderId()).size();
            buy = port.getTransactionBuy1(objTrader.getTraderId()).size();
            all = port.getTransactionDetails1(objTrader.getTraderId()).size();
            broker=objTrader.getBrokerId().getBrokerName();
        } else if (session.getAttribute("usertype").equals("Admin")) {
                noBroker=port.getBrokerDetails().size();
                noTrader=port.getTraderDetails().size();
                all=port.getTransactionOfMonth().size();
                sell= port.getTransactionSell2().size();
                buy=port.getTransactionBuy2().size();        
        }

    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    public Integer getBuy() {
        return buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
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

    public BrokerMaster getObjBroker() {
        return objBroker;
    }

    public void setObjBroker(BrokerMaster objBroker) {
        this.objBroker = objBroker;
    }

    public Integer getNoBroker() {
        return noBroker;
    }

    public void setNoBroker(Integer noBroker) {
        this.noBroker = noBroker;
    }

    public Integer getNoTrader() {
        return noTrader;
    }

    public void setNoTrader(Integer noTrader) {
        this.noTrader = noTrader;
    }

    public List<Service.NewsMaster> getNewsDetails() {
        Service.StService port = service.getStServicePort();
        return port.getNewsDetails();
    }

   

  
}
