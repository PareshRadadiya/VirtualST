/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
public class stockDetailBean implements Serializable {

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

    public List<String> complete(String query) {
        Service.StService port = service.getStServicePort();
        List<String> results = new ArrayList<String>();
        Iterator it = port.getAuto(query).iterator();

        while (it.hasNext()) {
            String s = (String) it.next();

            results.add(s);
        }

        return results;
    }

    public String StockSearch() {
        Service.StService port = service.getStServicePort();

        List objStock = port.getQuotes(Stock_Symbol_Search);
        Integer i = 0;
        String YahooStock = "";
        while (i < objStock.size()) {

            YahooStock = (String) objStock.get(i);

            String[] YahooStockDetail = YahooStock.split(",");
            Stock_Symbol = YahooStockDetail[0].replace("\"", "");
            Stock_Price = new BigDecimal(YahooStockDetail[1]);
            Stock_Open = YahooStockDetail[2];
            Stock_DaysHigh = YahooStockDetail[3];
            Stock_DaysLow = YahooStockDetail[4];
            Stock_Change = YahooStockDetail[5].substring(1, YahooStockDetail[5].length() - 1);
            Stock_Volume = YahooStockDetail[6];
            Stock_Date = YahooStockDetail[7];
            Stock_Name = YahooStockDetail[8].replace("\"", "");
            Stock_Symbol_Search = YahooStockDetail[0].replace("\"", "");
            i++;
        }

        return "StockDetailSearch";
    }

    public void addOrder() throws Exception {
        Service.StService port = service.getStServicePort();
        List objStock = port.getQuotes(Stock_Symbol);
        Integer i = 0;
        String YahooStock = "";
        while (i < objStock.size()) {

            YahooStock = (String) objStock.get(i);

            String[] YahooStockDetail = YahooStock.split(",");
            Stock_Symbol = YahooStockDetail[0].replace("\"", "");
            Stock_Price = new BigDecimal(YahooStockDetail[1]);
            Stock_Open = YahooStockDetail[2];
            Stock_DaysHigh = YahooStockDetail[3];
            Stock_DaysLow = YahooStockDetail[4];
            Stock_Change = YahooStockDetail[5].substring(1, YahooStockDetail[5].length() - 1);
            Stock_Volume = YahooStockDetail[6];
            Stock_Date = YahooStockDetail[7];
            Stock_Name = YahooStockDetail[8].replace("\"", "");
            Stock_Symbol_Search = YahooStockDetail[0].replace("\"", "");
            i++;
        }
        if (Stock_Open.equals("N/A")) {

            msg = "<div class='alert alert-danger fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Invalid Stock Symbole</div>";
            operation = msg;
            rend = false;
        } else {

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
            operation = " <div class=\"alert alert-success fade in\"> <a href=\"#\" class=\"close\" data-dismiss=\"alert\">&times;</a><strong>Success:</strong><br/>Order Is Placed Successfully </div>";
        }

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
        if (traderId != null) {
            objTraderStock = port.getTraddersStock(traderId);
        } else {
            objTraderStock = port.getTraddersStock(1.0);
        }
    }

    public void handleStockChange() {
        Service.StService port = service.getStServicePort();
        List objStock = port.getQuotes(Stock_Symbol);
        Integer i = 0;
        String YahooStock = "";
        while (i < objStock.size()) {

            YahooStock = (String) objStock.get(i);

            String[] YahooStockDetail = YahooStock.split(",");

            Stock_Open = YahooStockDetail[2];
            i++;
        }
        if (Stock_Open.equals("N/A") == false) {
            msg = "<div class='alert alert-success fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Valid Stock Symbole</div>";
            rend = false;
        } else {
            msg = "<div class='alert alert-danger fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Invalid Stock Symbole</div>";
            rend = true;
        }
    }

    public List<Service.TraderStock> getTraddersStock() {
        Service.StService port = service.getStServicePort();
        System.out.println(session.getAttribute("user").toString());
        return port.getTraddersStock(Double.valueOf(session.getAttribute("user").toString()));
    }

    public String News() {
        Service.StService port = service.getStServicePort();
        List objStock = port.getQuotes(Stock_Symbol_Search);
        Integer i = 0;
        String YahooStock = "";
        while (i < objStock.size()) {
            YahooStock = (String) objStock.get(i);
            String[] YahooStockDetail = YahooStock.split(",");
            Stock_Symbol = YahooStockDetail[0].substring(1, YahooStockDetail[0].length() - 1);
            i++;
        }
        msg = "http://api.finance.yahoo.com/instrument/1.0/" + Stock_Symbol + ",GOOG,ORCL/badge;chart=1y,,comparison;news=10;quote/HTML/f.white?AppID=i8iqZkpHzHwNIT0Gco.XhvRgUQybBgdDbcma&amp;sig=1XOsRWLix7Bs4ISqBDtDtejtZEs-&amp;t=1357211528001";
        return "Market_News";
    }

    public List getMonthWiseTotal() {
        Service.StService port = service.getStServicePort();
        List objList = new ArrayList();
        List<StringArray> ls = new ArrayList<StringArray>();
        ls = port.getMonthWiseTotal(Double.valueOf(session.getAttribute("user").toString()));
        Iterator it = ls.iterator();
        while (it.hasNext()) {
            StringArray singleList = (StringArray) it.next();
            objList.add(singleList.getItem());
        }
        return objList;
    }

    public List<Object> getMonthAll() {
        Service.StService port = service.getStServicePort();
        return port.getMonthAll(Double.valueOf(session.getAttribute("user").toString()));
    }

    
}
