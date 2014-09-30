/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.StService_Service;
import Service.StringArray;
import Service.TraderStock;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
@ViewScoped
public class sellBean {

    

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    FacesContext fc = FacesContext.getCurrentInstance();
    HttpServletRequest objReq = (HttpServletRequest) fc.getExternalContext().getRequest();
    HttpSession objSession = objReq.getSession(true);
    private String Stock_Symbol = "";
    private String Stock_Name = "";
    private BigDecimal Stock_Price;
    private String Stock_Open;
    private String Stock_DaysHigh;
    private String Stock_DaysLow;
    private String Stock_Change = "";
    private String Stock_Volume;
    private String Stock_Date;
    private String Stock_Symbol_Search;
    private int Buy_Stock_Qty;
    private String Buy_Stock_Status;
    private Date dt = new Date();
    private String MsgStatus = "";
    private Double traderId;
    private Long volume;
    private Long ordervolume;
    private Double price;
    private String scriptId;
    private XMLGregorianCalendar orderDate;
    private String orderType;
    private String pending;
    private Double stockDetails;
    private String msg;
    private Service.TraderMaster objTrader;
    private Boolean rend;
    private String operation;
    private List<Service.TraderStock> objTraderStock = new ArrayList<Service.TraderStock>();
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    HttpSession session = request.getSession();

    public List<TraderStock> getObjTraderStock() {
        return objTraderStock;
    }

    public void setObjTraderStock(List<TraderStock> objTraderStock) {
        this.objTraderStock = objTraderStock;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Boolean getRend() {
        return rend;
    }

    public void setRend(Boolean rend) {
        this.rend = rend;
    }

    public FacesContext getFc() {
        return fc;
    }

    public void setFc(FacesContext fc) {
        this.fc = fc;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public XMLGregorianCalendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(XMLGregorianCalendar orderDate) {
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

    public void setPending(String pending) {
        this.pending = pending;
    }

    public String getMsgStatus() {
        return MsgStatus;
    }

    public void setMsgStatus(String MsgStatus) {
        this.MsgStatus = MsgStatus;
    }

    public String getStock_Change() {
        return Stock_Change;
    }

    public void setStock_Change(String Stock_Change) {
        this.Stock_Change = Stock_Change;
    }

    public String getStock_Date() {
        return Stock_Date;
    }

    public void setStock_Date(String Stock_Date) {
        this.Stock_Date = Stock_Date;
    }

    public String getStock_DaysHigh() {
        return Stock_DaysHigh;
    }

    public void setStock_DaysHigh(String Stock_DaysHigh) {
        this.Stock_DaysHigh = Stock_DaysHigh;
    }

    public String getStock_DaysLow() {
        return Stock_DaysLow;
    }

    public void setStock_DaysLow(String Stock_DaysLow) {
        this.Stock_DaysLow = Stock_DaysLow;
    }

    public String getStock_Name() {
        return Stock_Name;
    }

    public void setStock_Name(String Stock_Name) {
        this.Stock_Name = Stock_Name;
    }

    public String getStock_Open() {
        return Stock_Open;
    }

    public void setStock_Open(String Stock_Open) {
        this.Stock_Open = Stock_Open;
    }

    public BigDecimal getStock_Price() {
        return Stock_Price;
    }

    public void setStock_Price(BigDecimal Stock_Price) {
        this.Stock_Price = Stock_Price;
    }

    public String getStock_Symbol() {
        return Stock_Symbol;
    }

    public void setStock_Symbol(String Stock_Symbol) {
        this.Stock_Symbol = Stock_Symbol;
    }

    public Double getStockDetails() {
        return stockDetails;
    }

    public void setStockDetails(Double stockDetails) {
        this.stockDetails = stockDetails;
    }

    public String getStock_Volume() {
        return Stock_Volume;
    }

    public void setStock_Volume(String Stock_Volume) {
        this.Stock_Volume = Stock_Volume;
    }

    public String getStock_Symbol_Search() {
        return Stock_Symbol_Search;
    }

    public void setStock_Symbol_Search(String Stock_Symbol_Search) {
        this.Stock_Symbol_Search = Stock_Symbol_Search;
    }

    public int getBuy_Stock_Qty() {
        return Buy_Stock_Qty;
    }

    public void setBuy_Stock_Qty(int Buy_Stock_Qty) {
        this.Buy_Stock_Qty = Buy_Stock_Qty;
    }

    public String getBuy_Stock_Status() {
        return Buy_Stock_Status;
    }

    public void setBuy_Stock_Status(String Buy_Stock_Status) {
        this.Buy_Stock_Status = Buy_Stock_Status;
    }

    public Long getOrdervolume() {
        return ordervolume;
    }

    public void setOrdervolume(Long ordervolume) {
        this.ordervolume = ordervolume;
    }

   

    public void addOrder() throws Exception {

        Service.StService port = service.getStServicePort();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal);
        try {
            port.addStock(Stock_Symbol, Stock_Symbol, "", "", 0, xcal, 0, Stock_Name, "", "", "", "", "", "", "", "");
        } catch (Exception e) {
        }
        port.addOrder(traderId, volume, price, Stock_Symbol, xcal, orderType, "yes");
        volume = null;
        price = null;
        msg = null;
        operation = "Added";
    }

    public void checkStock(Double ablvolume) {

        if (volume <= ablvolume) {
            msg = "<div class='alert alert-success fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Remaining Stock : " + (ablvolume - volume) + "</div>";
            rend = false;
        } else if (ablvolume < volume) {
            msg = "<div class='alert alert-danger fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Have not enough stock for Sell</div>";

            rend = true;
        }
    }

    public void checkFund(Double trader) {
        Service.StService port = service.getStServicePort();
        objTrader = port.getObjTrader(trader);
        Double brokrage = (volume * price * 1.5) / 100;
        if (((volume * price) + brokrage) < objTrader.getFund()) {
            msg = "<div class='alert alert-success fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Remaining Fund : " + (objTrader.getFund() - ((volume * price) + brokrage)) + "</div>";
            rend = false;
        } else {
            msg = "<div class='alert alert-danger fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Have not enough fund for Buy</div>";
            rend = true;
        }
    }

    public void handleTraderChange() {
        Service.StService port = service.getStServicePort();
        System.out.println(traderId);
        if (traderId != null) {
            objTraderStock = port.getTraddersStock(traderId);
        } else {
            objTraderStock = port.getTraddersStock(1.0);
        }
    }

    public List<Service.TraderStock> getTraddersStock() {
        Service.StService port = service.getStServicePort();
        return port.getTraddersStock(Double.valueOf(session.getAttribute("user").toString()));
    }
    
     public List getMonthWiseTotal() {
        Service.StService port = service.getStServicePort();
        List objList = new ArrayList();
        List<StringArray> ls = new ArrayList<StringArray>();
        ls = port.getMonthWiseTotal(traderId);
        Iterator it = ls.iterator();
        while (it.hasNext()) {
            StringArray singleList = (StringArray) it.next();
            objList.add(singleList.getItem());
        }
        return objList;
    }

    public List<Object> getMonthAll() {
        Service.StService port = service.getStServicePort();
        return port.getMonthAll(traderId);
    }
}

