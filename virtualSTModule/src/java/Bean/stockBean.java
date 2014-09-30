/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entity.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlSeeAlso;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author paresh
 */
@Stateless
public class stockBean implements stockBeanLocal {

    @PersistenceContext(unitName = "virtualSTModulePU")
    EntityManager em;

    @Override
    public void addStock(String script_id, String script_code, String group, String industry, Integer market_lot, Date listing_date, Integer face_value, String company_name, String address, String state, String city, String phoneno, String fax, String email_id, String director, String website) {
        StockDetails objStock = em.find(StockDetails.class, script_id);
        if (objStock == null) {
            StockDetails objStock1 = new StockDetails(script_id, script_code, group, industry, market_lot, listing_date, face_value, company_name, address, state, city, phoneno, fax, email_id, director, website);
            em.persist(objStock1);
        }

    }

    @Override
    public void updateStock(String script_id, String script_code, String group, String industry, Integer market_lot, Date listing_date, Integer face_value, String company_name, String address, String state, String city, String phoneno, String fax, String email_id, String director, String website) {
        StockDetails objStock = em.find(StockDetails.class, script_id);
        objStock.setAddress(address);
        objStock.setCity(city);
        objStock.setCompanyName(company_name);
        objStock.setDirector(director);
        objStock.setEmailId(email_id);
        objStock.setFaceValue(face_value);
        objStock.setFax(fax);
        objStock.setGroupType(group);
        objStock.setIndustry(industry);
        objStock.setListingDate(listing_date);
        objStock.setMarketLot(market_lot);
        objStock.setPhoneNo(phoneno);
        objStock.setScriptCode(script_code);
        objStock.setWebsite(website);
        objStock.setStat(state);
        em.merge(objStock);
    }

    @Override
    public void deleteStock(String script_id) {
        StockDetails objStock = em.find(StockDetails.class, script_id);
        em.remove(objStock);
    }

    @Override
    public void addUser(String user_id, String password) {
        UserMaster objUser = new UserMaster(user_id, password);
        em.persist(objUser);
    }

    @Override
    public void updateUser(String user_id, String password) {
        UserMaster objUser = em.find(UserMaster.class, user_id);
        objUser.setPassword(password);
        em.merge(objUser);
    }

    @Override
    public void deleteUser(String user_id) {
        UserMaster objUser = em.find(UserMaster.class, user_id);
        em.remove(objUser);
    }

    @Override
    public void addBroker(String broker_name, String user_id, String correspond_office, String state, String city, String clearingNo, String trade_name, String corporate_email, String phone_no, String SEBIno, Double deposit) {
        BrokerMaster objBroker = new BrokerMaster(broker_name, correspond_office, state, city, clearingNo, trade_name, corporate_email, phone_no, SEBIno, deposit, 0);
        UserMaster objUser = em.find(UserMaster.class, user_id);
        objBroker.setUserId(objUser);
        em.persist(objBroker);
    }

    @Override
    public void updateBroker(Long broker_id, String broker_name, String user_id, String correspond_office, String state, String city, String clearingNo, String trade_name, String corporate_email, String phone_no, String SEBIno, Double deposit, Double fund) {
        BrokerMaster objBroker = em.find(BrokerMaster.class, broker_id);
        objBroker.setBrokerName(broker_name);
        objBroker.setCity(city);
        objBroker.setClearingNo(clearingNo);
        objBroker.setCorrespondOffice(correspond_office);
        objBroker.setCorporateEmail(corporate_email);
        objBroker.setPhoneNo(phone_no);
        objBroker.setDeposit(deposit);
        objBroker.setSebiNo(SEBIno);
        objBroker.setStat(state);
        objBroker.setFund(fund);
        objBroker.setTradeName(trade_name);
        UserMaster objUser = em.find(UserMaster.class, user_id);
        objBroker.setUserId(objUser);
        em.merge(objBroker);
    }

    @Override
    public void deleteBroker(Long broker_id) {
        BrokerMaster objBroker = em.find(BrokerMaster.class, broker_id);
        em.remove(objBroker);
    }

    @Override
    public void addNews(String topic, String details) {
        NewsMaster objNews = new NewsMaster(topic, new Date(), details);
        em.persist(objNews);
    }

    @Override
    public void updateNews(Long news_id, String topic, String details) {
        NewsMaster objNews = em.find(NewsMaster.class, news_id);
        objNews.setDetails(details);
        objNews.setTopic(topic);
        objNews.setNewsDate(new Date());
        em.merge(objNews);
    }

    @Override
    public void deleteNews(Long news_id) {
        NewsMaster objNews = em.find(NewsMaster.class, news_id);
        em.remove(objNews);
    }

    @Override
    public void addOrder(Double trader_id, Long volume, Double price, String script_id, Date order_date, String order_type, String pending) {
        OrderMaster objOrder = new OrderMaster(volume, price, order_date, order_type, pending);
        TraderMaster objTrader = em.find(TraderMaster.class, trader_id);
        objOrder.setTraderId(objTrader);
        StockDetails objStock = em.find(StockDetails.class, script_id);
        objOrder.setScriptId(objStock);
        em.persist(objOrder);
    }

    @Override
    public void updateOrder(Double order_id, Double trader_id, Long volume, Double price, String script_id, Date order_date, String order_type, String pending) {
        OrderMaster objOrder = em.find(OrderMaster.class, order_id);
        objOrder.setOrderDate(order_date);
        objOrder.setOrderType(order_type);
        objOrder.setPending(pending);
        objOrder.setPrice(price);
        objOrder.setVolume(volume);
        TraderMaster objTrader = em.find(TraderMaster.class, trader_id);
        objOrder.setTraderId(objTrader);
        StockDetails objStock = em.find(StockDetails.class, script_id);
        objOrder.setScriptId(objStock);
        em.merge(objOrder);
    }

    @Override
    public void deleteOrder(Double order_id) {
        OrderMaster objOrder = em.find(OrderMaster.class, order_id);
        em.remove(objOrder);


    }

    @Override
    public void addTrader(String trader_name, Long broker_id, String user_id, Double deposite, String address, String state, String city, String PANno, String phoneno, String email_id) {
        TraderMaster objTrader = new TraderMaster(trader_name, deposite, address, state, city, PANno, phoneno, email_id, 0);
        BrokerMaster objBroker = em.find(BrokerMaster.class, broker_id);
        objTrader.setBrokerId(objBroker);
        UserMaster objUser = em.find(UserMaster.class, user_id);
        objTrader.setUserId(objUser);
        em.persist(objTrader);
        //em.refresh(objTrader);
        //em.close();

    }

    @Override
    public void updateTrader(Double trader_id, String trader_name, Long broker_id, String user_id, Double deposite, String address, String state, String city, String PANno, String phoneno, String email_id, Double fund) {
        TraderMaster objTrader = em.find(TraderMaster.class, trader_id);
        objTrader.setAddress(address);
        objTrader.setCity(city);
        objTrader.setDeposit(deposite);
        objTrader.setEmailId(email_id);
        objTrader.setPanNo(PANno);
        objTrader.setPhoneNo(phoneno);
        objTrader.setStat(state);
        objTrader.setTraderName(trader_name);
        objTrader.setFund(fund);
        BrokerMaster objBroker = em.find(BrokerMaster.class, broker_id);
        UserMaster objUser = em.find(UserMaster.class, user_id);
        objTrader.setBrokerId(objBroker);
        objTrader.setUserId(objUser);
        em.merge(objTrader);
    }

    @Override
    public void deleteTrader(Double trader_id) {
        TraderMaster objTrader = em.find(TraderMaster.class, trader_id);
        em.remove(objTrader);
        //em.refresh(objTrader);
        //em.close();
    }

    @Schedule(second = "*", dayOfWeek = "1-5", hour = "9-16", minute = "0-59")
    @Override
    public void addTransaction() {
        try {
            String YahooStock;
            List<OrderMaster> pendingOrder = getPendingOrder();
            Iterator it = pendingOrder.iterator();
            if (pendingOrder.size() > 0) {
                while (it.hasNext()) {
                    OrderMaster order = (OrderMaster) it.next();
                    List stockData = getQuotes(order.getScriptId().getScriptId());
                    Integer i = 0;
                    while (i < stockData.size()) {
                        YahooStock = (String) stockData.get(i);
                        String[] YahooStockDetail = YahooStock.split(",");
                        TraderMaster objTrader = em.find(TraderMaster.class, order.getTraderId().getTraderId());
                        BrokerMaster objBroker = em.find(BrokerMaster.class, objTrader.getBrokerId().getBrokerId());
                        Double commition = (order.getVolume() * Double.valueOf(YahooStockDetail[1]) * 1.5) / 100;

                        if (order.getOrderType().equals("S")) {
                            if (order.getPrice() <= Double.valueOf(YahooStockDetail[1])) {

                                updateOrder(order.getOrderId(), order.getTraderId().getTraderId(), order.getVolume(), Double.valueOf(YahooStockDetail[1]), order.getScriptId().getScriptId(), order.getOrderDate(), "S", "no");
                                objBroker.setFund(objBroker.getFund() + commition);
                                em.merge(objBroker);
                                objTrader.setFund(objTrader.getFund() + ((order.getVolume() * Double.valueOf(YahooStockDetail[1])) - commition));
                                em.merge(objTrader);
                                TraderStockPK objTraderStockPK = new TraderStockPK(objTrader.getTraderId(), order.getScriptId().getScriptId());
                                TraderStock objTraderStock = em.find(TraderStock.class, objTraderStockPK);
                                objTraderStock.setVolume(objTraderStock.getVolume() - order.getVolume());
                                em.merge(objTraderStock);
                                TransactionDetails objTransaction = new TransactionDetails(new Date(), commition);
                                objTransaction.setOrderId(order);
                                em.persist(objTransaction);
                            }
                        } else if (order.getOrderType().equals("B")) {
                            if (order.getPrice() >= Double.valueOf(YahooStockDetail[1])) {
                                if (objTrader.getFund() > ((order.getVolume() * Double.valueOf(YahooStockDetail[1])) + commition)) {
                                    updateOrder(order.getOrderId(), order.getTraderId().getTraderId(), order.getVolume(), Double.valueOf(YahooStockDetail[1]), order.getScriptId().getScriptId(), order.getOrderDate(), "B", "no");
                                    objBroker.setFund(objBroker.getFund() + commition);
                                    em.merge(objBroker);
                                    objTrader.setFund(objTrader.getFund() - ((order.getVolume() * Double.valueOf(YahooStockDetail[1])) + commition));
                                    em.merge(objTrader);
                                    TraderStockPK objTraderStockPK = new TraderStockPK(objTrader.getTraderId(), order.getScriptId().getScriptId());
                                    TraderStock objTraderStock = em.find(TraderStock.class, objTraderStockPK);
                                    if (objTraderStock == null) {

                                        TraderStock objTraderStock1 = new TraderStock(objTrader.getTraderId(), order.getScriptId().getScriptId());
                                        objTraderStock1.setVolume(objTraderStock1.getVolume() + order.getVolume());
                                        em.persist(objTraderStock1);

                                    } else {
                                        objTraderStock.setVolume(objTraderStock.getVolume() + order.getVolume());
                                        em.merge(objTraderStock);
                                    }
                                    TransactionDetails objTransaction = new TransactionDetails(new Date(), commition);
                                    objTransaction.setOrderId(order);
                                    em.persist(objTransaction);
                                }
                            }
                        }
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<StockDetails> getStockDetails() {
        return em.createNamedQuery("StockDetails.findAll").getResultList();
    }

    @Override
    public boolean checkUserAvability(String user_id) {
        try {
            UserMaster objUser = em.find(UserMaster.class, user_id);
            if (objUser.getUserId().equals(user_id)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public List<TraderMaster> getTraderDetails(Double trader_id) {
        return em.createNamedQuery("TraderMaster.findByTraderId").setParameter("traderId", trader_id).getResultList();
    }

    @Override
    public List<BrokerMaster> getBrokerDetails() {
        return em.createNamedQuery("BrokerMaster.findAll").getResultList();
    }

    @Override
    public List<BrokerMaster> getBrokerDetails(Long broker_id) {
        return em.createNamedQuery("BrokerMaster.findByBrokerId").setParameter("brokerId", broker_id).getResultList();
    }

    @Override
    public List<StockDetails> getStockDetails(String script_id) {
        return em.createNamedQuery("StockDetails.findByScriptId").setParameter("scriptId", script_id).getResultList();
    }

    @Override
    public List<TraderMaster> getTraderDetails() {
        return em.createNamedQuery("TraderMaster.findAll").getResultList();
    }

    @Override
    public void addUserSGroup(String user_id, String group_type) {
        UserGroup objGroup = new UserGroup(user_id, group_type);
        em.persist(objGroup);
    }

    @Override
    public List<TraderMaster> getTraderDetailsByBrocker(Long broker_id) {
        BrokerMaster objBroker = em.find(BrokerMaster.class, broker_id);
        return objBroker.getTraderMasterList();
    }

    @Override
    public List<OrderMaster> getOrderDetails() {
        return em.createNamedQuery("OrderMaster.findAll").getResultList();
    }

    @Override
    public OrderMaster getObjOrderDetails(Double order_id) {
        OrderMaster objOrder = em.find(OrderMaster.class, order_id);
        em.refresh(objOrder);
        return objOrder;
    }

    @Override
    public void changePassword(String uname, String curPwd, String newPwd) {
        UserMaster um = em.find(UserMaster.class, uname);
        if (curPwd.equals("")) {
            um.setPassword(newPwd);
            em.merge(um);
        } else {
            if (um.getUserId().equals(uname) && um.getPassword().equals(curPwd)) {
                um.setPassword(newPwd);
                em.merge(um);
            }
        }


    }

    @Override
    public List<UserMaster> getUserMasterDetails() {
        return em.createNamedQuery("UserMaster.findAll").getResultList();
    }

    @Override
    public List<NewsMaster> getNewsDetails() {
        return em.createNamedQuery("NewsMaster.findAll").getResultList();
    }

    @Override
    public List<NewsMaster> getNewsDetails(Long newsId) {
        return em.createNamedQuery("NewsMaster.findByNewsId").setParameter("newsId", newsId).getResultList();
    }

    @Override
    public List<StateMaster> getAllStates() {
        return em.createNamedQuery("StateMaster.findAll").getResultList();
    }

    @Override
    public List<CityMaster> getCityByState(Integer stateId) {
        StateMaster objstate = em.find(StateMaster.class, stateId);
        return objstate.getCityMasterList();

    }

    @Override
    public List<TraderStock> getTraddersStock(Double trader_id) {
        TraderMaster objTrader = em.find(TraderMaster.class, trader_id);
        return objTrader.getTraderStockList();
    }

    @Override
    public List<BrokerMaster> getBrokerByUserId(String user_id) {
        UserMaster objUser = em.find(UserMaster.class, user_id);
        return objUser.getBrokerMasterList();
    }

    @Override
    public List<TraderMaster> getTraderByUserId(String user_id) {
        UserMaster objUser = em.find(UserMaster.class, user_id);
        return objUser.getTraderMasterList();
    }

    @Override
    public List<AdminMaster> getAdminByUserId(String user_id) {
        UserMaster objUser = em.find(UserMaster.class, user_id);
        return objUser.getAdminMasterList();
    }

    @Override
    public TraderMaster getObjTrader(Double trader_id) {
        TraderMaster objTrader = em.find(TraderMaster.class, trader_id);
        return objTrader;
    }

    @Override
    public List<TraderStock> getTraddersStock() {
        return em.createNamedQuery("TraderStock.findAll").getResultList();
    }

    @Override
    public List getQuotes(String Stock_Symbol) {
        List objStockList = new ArrayList();
        BufferedReader objBR = null;
        URLConnection objURLCon = null;
        String objFileURL = null;
        URL objURL = null;
        String objLine;
        Integer objIndex;
        try {
            objFileURL = "http://quote.yahoo.com/d/quotes.csv?s=" + Stock_Symbol + /*"ORACLEFIN.BO+BBDB.TO+NT.TO+GE+MSFT" +*/ "&f=sl1ohgcvd2n";
            objURL = new URL(objFileURL);
            objURLCon = objURL.openConnection();
            objURLCon.setConnectTimeout(1000);
            objURLCon.setReadTimeout(1000);
            objBR = new BufferedReader(new InputStreamReader(objURL.openStream()));
            objIndex = 0;
            if ((objLine = objBR.readLine()) != null) {
                objStockList.add(objIndex, objLine);
                objIndex++;
            }

        } catch (Exception ex) {
        } finally {
            return objStockList;
        }
    }

    @Override
    public List getAuto(String Stock_Symbol) {
        List objStockList = new ArrayList();
        BufferedReader objBR = null;
        URLConnection objURLCon = null;
        String objFileURL = null;
        URL objURL = null;

        try {
            objFileURL = "http://d.yimg.com/autoc.finance.yahoo.com/autoc?query=" + Stock_Symbol + "&callback=YAHOO.Finance.SymbolSuggest.ssCallback";
            objURL = new URL(objFileURL);
            objURLCon = objURL.openConnection();

            objBR = new BufferedReader(new InputStreamReader(objURL.openStream()));

            String jsonString = "";
            String line;

            while ((line = objBR.readLine()) != null) {
                jsonString += line;
            }
            objBR.close();
            JSONObject jo = new JSONObject(jsonString.substring(jsonString.indexOf("{")));
            JSONArray ja;
            jo = jo.getJSONObject("ResultSet");
            ja = jo.getJSONArray("Result");

            int resultCount = ja.length();
            for (int i = 0; i < resultCount; i++) {
                JSONObject resultObject = ja.getJSONObject(i);

                objStockList.add(resultObject.get("symbol").toString());

            }

        } catch (Exception ex) {
        } finally {
            return objStockList;
        }

    }

    @Override
    public void sendMail(String Receiver, String Sub, String Msg) {
        final String username = "pareshpravin@gmail.com";
        final String password = "9909601320";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("pareshpravin@gmail.com", "9909601320");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from-email@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(Receiver));
            message.setSubject(Sub);
            message.setText("Dear User,"
                    + "\n\n " + Msg + "!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendSms(Object phone, String msg) {
        try {
            URL url = new URL("http://www.ubaid.tk/sms/sms.aspx?uid=8128969396&pwd=9909601320&msg=" + msg + "&phone=" + phone + "&provider=way2sms");

            URLConnection conn = url.openConnection();
            conn.connect();
            InputStreamReader content = new InputStreamReader(conn.getInputStream());
            for (int i = 0; i != -1; i = content.read()) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public UserMaster getObjUserDetails(String user_id) {
        return em.find(UserMaster.class, user_id);
    }

    @Override
    public StateMaster getObjState(Integer state_id) {
        return em.find(StateMaster.class, state_id);
    }

    @Override
    public List<CityMaster> getAllCity() {
        return em.createNamedQuery("CityMaster.findAll").getResultList();
    }

    @Override
    public List<StateMaster> getState(String state_name) {
        return em.createNamedQuery("StateMaster.findByStateName").setParameter("stateName", state_name).getResultList();
    }

    @Override
    public void deleteUserGroup(String user_id, String group) {
        UserGroupPK objGroupPk = new UserGroupPK(user_id, group);
        UserGroup objGroup = em.find(UserGroup.class, objGroupPk);
        em.remove(objGroup);
    }

    @Override
    public void addBrokerFund(Long brokerId, Double fund) {
        BrokerMaster bm = em.find(BrokerMaster.class, brokerId);
        Double value = 0.0;
        value = bm.getFund() + fund;
        bm.setFund(value);
        em.merge(bm);


    }

    @Override
    public void addTraderFund(Double traderId, Double fund) {
        TraderMaster tm = em.find(TraderMaster.class, traderId);
        Double value = 0.0;
        value = tm.getFund() + fund;
        tm.setFund(value);
        em.merge(tm);
    }

    @Override
    public List<UserGroup> getUserGroupDetails() {
        return em.createNamedQuery("UserGroup.findAll").getResultList();
    }

    @Override
    public void addAdmin(String userId, String emailId, String phoneNo, String details) {
        AdminMaster objadmin = new AdminMaster(emailId, phoneNo, details);
        UserMaster um = em.find(UserMaster.class, userId);
        objadmin.setUserId(um);
        em.persist(objadmin);
    }

    @Override
    public void deleteAdmin(Integer adminId) {
        AdminMaster objadmin = em.find(AdminMaster.class, adminId);
        em.remove(objadmin);
    }

    @Override
    public List<AdminMaster> getAdminDetails() {
        return em.createNamedQuery("AdminMaster.findAll").getResultList();
    }

    @Override
    public List<TraderMaster> getTraderByBrokerId(Long broker_id) {
        BrokerMaster objBroker = em.find(BrokerMaster.class, broker_id);
        em.refresh(objBroker);
        return objBroker.getTraderMasterList();
    }

    @Override
    public List<OrderMaster> getOrderDetails(Double trader_id) {
        TraderMaster objTrader = em.find(TraderMaster.class, trader_id);
        em.refresh(objTrader);
        return objTrader.getOrderMasterList();
    }

    @Override
    public TraderStock getObjTraddersStock(Double trader_id, String script_id) {
        TraderStockPK objTraderStockPK = new TraderStockPK(trader_id, script_id);
        TraderStock objTraderStock = em.find(TraderStock.class, objTraderStockPK);
        return objTraderStock;
    }

    @Override
    public List<TransactionDetails> getTransactionDetails() {
        return em.createNamedQuery("TransactionDetails.findAll").getResultList();
    }

    @Override
    public BrokerMaster getObjBroker(Long broker_id) {
        BrokerMaster objBroker = em.find(BrokerMaster.class, broker_id);
        return objBroker;
    }

    @Override
    public List<TransactionDetails> getTransactionDetails(Long broker_id) {
        return em.createQuery("SELECT t FROM TransactionDetails t  WHERE t.orderId.traderId.brokerId.brokerId=:brokerId AND FUNC('MONTH', t.transDate)=FUNC('MONTH',CURRENT_DATE) AND  FUNC('YEAR', t.transDate)=FUNC('YEAR',CURRENT_DATE)").setParameter("brokerId", broker_id).getResultList();
    }

    @Override
    public List<TransactionDetails> getTransactionSell(Long broker_id) {
        return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.brokerId.brokerId=:brokerId AND t.orderId.orderType='S' AND FUNC('MONTH', t.transDate)=FUNC('MONTH',CURRENT_DATE) AND  FUNC('YEAR', t.transDate)=FUNC('YEAR',CURRENT_DATE)").setParameter("brokerId", broker_id).getResultList();
    }

    @Override
    public List<TransactionDetails> getTransactionBuy(Long broker_id) {
        return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.brokerId.brokerId=:brokerId AND t.orderId.orderType='B' AND FUNC('MONTH', t.transDate)=FUNC('MONTH',CURRENT_DATE) AND  FUNC('YEAR', t.transDate)=FUNC('YEAR',CURRENT_DATE)").setParameter("brokerId", broker_id).getResultList();
    }

    @Override
    public List<OrderMaster> getPendingOrder(Double trader_id, String order_type, String script_id, Date order_date_from, Date order_date_to) {
        if (trader_id != null && order_type == null && script_id == null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.traderId.traderId=:traderId AND o.pending='yes'").setParameter("traderId", trader_id).getResultList();
        } else if (trader_id == null && order_type != null && script_id == null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.orderType=:orderType AND o.pending='yes'").setParameter("orderType", order_type).getResultList();
        } else if (trader_id == null && order_type == null && script_id != null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.scriptId.scriptId=:script_id AND o.pending='yes'").setParameter("script_id", script_id).getResultList();
        } else if (trader_id == null && order_type == null && script_id == null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.orderDate=:orderDateFrom  AND o.pending='yes'").setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id == null && order_type == null && script_id == null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.orderDate=:orderDateTo  AND o.pending='yes'").setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type == null && script_id == null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.orderDate<=:orderDateFrom  AND o.orderDate>=:orderDateTo AND o.pending='yes'").setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id == null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.traderId.traderId=:traderId AND o.orderType=:orderType AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).getResultList();
        } else if (trader_id != null && order_type == null && script_id != null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.traderId.traderId=:traderId AND o.scriptId.scriptId=:script_id  AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("script_id", script_id).getResultList();
        } else if (trader_id != null && order_type == null && script_id == null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.traderId.traderId=:traderId AND  o.orderDate=:orderDateFrom   AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id != null && order_type == null && script_id == null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.traderId.traderId=:traderId AND o.orderDate=:orderDateTo   AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type == null && script_id == null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.traderId.traderId=:traderId AND o.orderDate<=:orderDateFrom  AND o.orderDate>=:orderDateTo AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.traderId.traderId=:traderId AND o.orderType=:orderType AND o.scriptId.scriptId=:script_id AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).getResultList();
        } else if (trader_id != null && order_type != null && script_id == null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.traderId.traderId=:traderId AND o.orderType=:orderType AND o.orderDate=:orderDateFrom  AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id != null && order_type != null && script_id == null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.traderId.traderId=:traderId AND o.orderType=:orderType AND o.orderDate=:orderDateTo  AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id == null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.traderId.traderId=:traderId AND o.orderType=:orderType AND o.orderDate<=:orderDateFrom  AND o.orderDate>=:orderDateTo  AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.traderId.traderId=:traderId AND o.scriptId.scriptId=:script_id AND  o.orderType=:orderType AND o.orderDate=:orderDateFrom  AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE   o.traderId.traderId=:traderId AND o.scriptId.scriptId=:script_id  AND  o.orderType=:orderType AND o.orderDate=:orderDateTo  AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE   o.traderId.traderId=:traderId AND o.scriptId.scriptId=:script_id  AND o.orderType=:orderType  AND  o.orderDate<=:orderDateFrom  AND o.orderDate>=:orderDateTo AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.traderId.traderId=:traderId AND o.scriptId.scriptId=:script_id AND  o.orderType=:orderType AND o.orderDate=:orderDateFrom  AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.traderId.traderId=:traderId AND o.scriptId.scriptId=:script_id AND  o.orderType=:orderType AND o.orderDate=:orderDateTo  AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE   o.traderId.traderId=:traderId AND o.scriptId.scriptId=:script_id  AND o.orderType=:orderType  AND  o.orderDate<=:orderDateFrom  AND o.orderDate>=:orderDateTo AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.traderId.traderId=:traderId AND o.scriptId.scriptId=:script_id AND  o.orderType=:orderType AND o.orderDate=:orderDateTo  AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE   o.traderId.traderId=:traderId AND o.scriptId.scriptId=:script_id  AND o.orderType=:orderType  AND  o.orderDate<=:orderDateFrom  AND o.orderDate>=:orderDateTo AND o.pending='yes'").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type != null && script_id != null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE o.orderType=:orderType AND o.scriptId.scriptId=:script_id AND   o.pending='yes'").setParameter("orderType", order_type).setParameter("script_id", script_id).getResultList();
        } else if (trader_id == null && order_type != null && script_id == null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.orderType=:orderType AND  o.orderDate=:orderDateFrom   AND o.pending='yes'").setParameter("orderType", order_type).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id == null && order_type != null && script_id == null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.orderType=:orderType AND  o.orderDate=:orderDateTo  AND o.pending='yes'").setParameter("orderType", order_type).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type != null && script_id == null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.orderType=:orderType AND  o.orderDate<=:orderDateFrom AND o.orderDate>=:orderDateTo  AND o.pending='yes'").setParameter("orderType", order_type).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type != null && script_id != null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.scriptId.scriptId=:script_id AND o.orderType=:orderType AND  o.orderDate=:orderDateFrom  AND o.pending='yes'").setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id == null && order_type != null && script_id != null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.scriptId.scriptId=:script_id AND o.orderType=:orderType AND  o.orderDate=:orderDateTo  AND o.pending='yes'").setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type != null && script_id != null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.scriptId.scriptId=:script_id AND o.orderType=:orderType AND  o.orderDate<=:orderDateFrom AND o.orderDate>=:orderDateTo  AND o.pending='yes'").setParameter("script_id", script_id).setParameter("orderType", order_type).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type == null && script_id != null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.scriptId.scriptId=:script_id AND o.orderDate=:orderDateFrom  AND o.pending='yes'").setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id == null && order_type == null && script_id != null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.scriptId.scriptId=:script_id AND o.orderDate=:orderDateTo  AND o.pending='yes'").setParameter("script_id", script_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type == null && script_id != null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE  o.scriptId.scriptId=:script_id AND   o.orderDate<=:orderDateFrom AND o.orderDate>=:orderDateTo  AND o.pending='yes'").setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type == null && script_id == null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT o FROM OrderMaster o WHERE   o.orderDate<=:orderDateFrom AND o.orderDate>=:orderDateTo  AND o.pending='yes'").setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else {
            return em.createNamedQuery("OrderMaster.findByPending").setParameter("pending", "yes").getResultList();
        }
    }

    @Override
    public List<OrderMaster> getPendingOrder() {
        return em.createNamedQuery("OrderMaster.findByPending").setParameter("pending", "yes").getResultList();
    }

    @Override
    public List<TransactionDetails> getTransactionDetails(Double trader_id, String order_type, String script_id, Date order_date_from, Date order_date_to) {
        if (trader_id != null && order_type == null && script_id == null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.traderId=:traderId ").setParameter("traderId", trader_id).getResultList();
        } else if (trader_id == null && order_type != null && script_id == null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.orderType=:orderType ").setParameter("orderType", order_type).getResultList();
        } else if (trader_id == null && order_type == null && script_id != null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.scriptId.scriptId=:script_id ").setParameter("script_id", script_id).getResultList();
        } else if (trader_id == null && order_type == null && script_id == null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.orderDate=:orderDateFrom  ").setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id == null && order_type == null && script_id == null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.orderDate=:orderDateTo  ").setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type == null && script_id == null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.orderDate<=:orderDateFrom  AND t.orderId.orderDate>=:orderDateTo ").setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id == null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.traderId=:traderId AND t.orderId.orderType=:orderType ").setParameter("traderId", trader_id).setParameter("orderType", order_type).getResultList();
        } else if (trader_id != null && order_type == null && script_id != null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.traderId=:traderId AND t.orderId.scriptId.scriptId=:script_id  ").setParameter("traderId", trader_id).setParameter("script_id", script_id).getResultList();
        } else if (trader_id != null && order_type == null && script_id == null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.traderId=:traderId AND  t.orderId.orderDate=:orderDateFrom   ").setParameter("traderId", trader_id).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id != null && order_type == null && script_id == null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.traderId=:traderId AND t.orderId.orderDate=:orderDateTo   ").setParameter("traderId", trader_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type == null && script_id == null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.traderId=:traderId AND t.orderId.orderDate<=:orderDateFrom  AND t.orderId.orderDate>=:orderDateTo ").setParameter("traderId", trader_id).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.traderId.traderId=:traderId AND t.orderId.orderType=:orderType AND t.orderId.scriptId.scriptId=:script_id ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).getResultList();
        } else if (trader_id != null && order_type != null && script_id == null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.traderId.traderId=:traderId AND t.orderId.orderType=:orderType AND t.orderId.orderDate=:orderDateFrom  ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id != null && order_type != null && script_id == null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.traderId=:traderId AND t.orderId.orderType=:orderType AND t.orderId.orderDate=:orderDateTo  ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id == null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.traderId.traderId=:traderId AND t.orderId.orderType=:orderType AND t.orderId.orderDate<=:orderDateFrom  AND t.orderId.orderDate>=:orderDateTo  ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.traderId.traderId=:traderId AND t.orderId.scriptId.scriptId=:script_id AND  t.orderId.orderType=:orderType AND t.orderId.orderDate=:orderDateFrom  ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE   t.orderId.traderId.traderId=:traderId AND t.orderId.scriptId.scriptId=:script_id  AND  t.orderId.orderType=:orderType AND t.orderId.orderDate=:orderDateTo  ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE   t.orderId.traderId.traderId=:traderId AND t.orderId.scriptId.scriptId=:script_id  AND t.orderId.orderType=:orderType  AND  t.orderId.orderDate<=:orderDateFrom  AND t.orderId.orderDate>=:orderDateTo ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.traderId.traderId=:traderId AND t.orderId.scriptId.scriptId=:script_id AND  t.orderId.orderType=:orderType AND t.orderId.orderDate=:orderDateFrom  ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.traderId.traderId=:traderId AND t.orderId.scriptId.scriptId=:script_id AND  t.orderId.orderType=:orderType AND t.orderId.orderDate=:orderDateTo  ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE   t.orderId.traderId.traderId=:traderId AND t.orderId.scriptId.scriptId=:script_id  AND t.orderId.orderType=:orderType  AND  t.orderId.orderDate<=:orderDateFrom  AND t.orderId.orderDate>=:orderDateTo ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.traderId.traderId=:traderId AND t.orderId.scriptId.scriptId=:script_id AND  t.orderId.orderType=:orderType AND t.orderId.orderDate=:orderDateTo  ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id != null && order_type != null && script_id != null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE   t.orderId.traderId.traderId=:traderId AND t.orderId.scriptId.scriptId=:script_id  AND t.orderId.orderType=:orderType  AND  t.orderId.orderDate<=:orderDateFrom  AND t.orderId.orderDate>=:orderDateTo ").setParameter("traderId", trader_id).setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type != null && script_id != null && order_date_from == null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.orderType=:orderType AND t.orderId.scriptId.scriptId=:script_id ").setParameter("orderType", order_type).setParameter("script_id", script_id).getResultList();
        } else if (trader_id == null && order_type != null && script_id == null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.orderType=:orderType AND  t.orderId.orderDate=:orderDateFrom   ").setParameter("orderType", order_type).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id == null && order_type != null && script_id == null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.orderType=:orderType AND  t.orderId.orderDate=:orderDateTo  ").setParameter("orderType", order_type).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type != null && script_id == null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.orderType=:orderType AND  t.orderId.orderDate<=:orderDateFrom AND t.orderId.orderDate>=:orderDateTo  ").setParameter("orderType", order_type).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type != null && script_id != null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.scriptId.scriptId=:script_id AND t.orderId.orderType=:orderType AND  t.orderId.orderDate=:orderDateFrom  ").setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id == null && order_type != null && script_id != null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.scriptId.scriptId=:script_id AND t.orderId.orderType=:orderType AND  t.orderId.orderDate=:orderDateTo  ").setParameter("orderType", order_type).setParameter("script_id", script_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type != null && script_id != null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.scriptId.scriptId=:script_id AND t.orderId.orderType=:orderType AND  t.orderId.orderDate<=:orderDateFrom AND t.orderId.orderDate>=:orderDateTo  ").setParameter("script_id", script_id).setParameter("orderType", order_type).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type == null && script_id != null && order_date_from != null && order_date_to == null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.scriptId.scriptId=:script_id AND t.orderId.orderDate=:orderDateFrom  ").setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).getResultList();
        } else if (trader_id == null && order_type == null && script_id != null && order_date_from == null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.scriptId.scriptId=:script_id AND t.orderId.orderDate=:orderDateTo  ").setParameter("script_id", script_id).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type == null && script_id != null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE  t.orderId.scriptId.scriptId=:script_id AND   t.orderId.orderDate<=:orderDateFrom AND t.orderId.orderDate>=:orderDateTo  ").setParameter("script_id", script_id).setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else if (trader_id == null && order_type == null && script_id == null && order_date_from != null && order_date_to != null) {
            return em.createQuery("SELECT t FROM TransactionDetails t WHERE   t.orderId.orderDate<=:orderDateFrom AND t.orderId.orderDate>=:orderDateTo  ").setParameter("orderDateFrom", order_date_from).setParameter("orderDateTo", order_date_to).getResultList();
        } else {
            return em.createNamedQuery("TransactionDetails.findAll").getResultList();
        }
    }

    @Override
    public List<TransactionDetails> getTransactionSell(Double trader_id) {
        return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.traderId=:traderId AND t.orderId.orderType='S' AND FUNC('MONTH', t.transDate)=FUNC('MONTH',CURRENT_DATE) AND  FUNC('YEAR', t.transDate)=FUNC('YEAR',CURRENT_DATE)").setParameter("traderId", trader_id).getResultList();
    }

    @Override
    public List<TransactionDetails> getTransactionBuy(Double trader_id) {
        return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.traderId=:traderId AND t.orderId.orderType='B' AND FUNC('MONTH', t.transDate)=FUNC('MONTH',CURRENT_DATE) AND  FUNC('YEAR', t.transDate)=FUNC('YEAR',CURRENT_DATE)").setParameter("traderId", trader_id).getResultList();
    }

    @Override
    public List<TransactionDetails> getTransactionDetails(Double trader_id) {
        return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.traderId.traderId=:traderId").setParameter("traderId", trader_id).getResultList();
    }

    @Override
    public List<TransactionDetails> getTransactionSell() {
        return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.orderType='S' AND FUNC('MONTH', t.transDate)=FUNC('MONTH',CURRENT_DATE) AND  FUNC('YEAR', t.transDate)=FUNC('YEAR',CURRENT_DATE)").getResultList();
    }

    @Override
    public List<TransactionDetails> getTransactionBuy() {
        return em.createQuery("SELECT t FROM TransactionDetails t WHERE t.orderId.orderType='B' AND FUNC('MONTH', t.transDate)=FUNC('MONTH',CURRENT_DATE) AND  FUNC('YEAR', t.transDate)=FUNC('YEAR',CURRENT_DATE)").getResultList();
    }

    @Override
    public List<TransactionDetails> getTransactionOfMonth() {
        return em.createQuery("SELECT t FROM TransactionDetails t WHERE FUNC('MONTH', t.transDate)=FUNC('MONTH',CURRENT_DATE) AND  FUNC('YEAR', t.transDate)=FUNC('YEAR',CURRENT_DATE)").getResultList();
    }

   

    @Override
    public List getMonthWiseMonth(Double trader_id) {
        return em.createQuery("SELECT   FUNC('MONTHNAME', t.transDate) AS mon FROM TransactionDetails t WHERE t.orderId.traderId.traderId=:traderId GROUP BY FUNC('MONTHNAME', t.transDate) ").setParameter("traderId", trader_id).getResultList();
    }

    @Override
    public void registrationTrader(String guestName, String emailId, String phoneNo, String address,String stat,String city,String pin, String pan,Long brokerId, String pending) {
        RegistrationMst objreg =new RegistrationMst(guestName, emailId, phoneNo, address, stat, city, pin, pan, pending);
        
        BrokerMaster bm = em.find(BrokerMaster.class, brokerId);
        objreg.setBrokerId(bm);
        em.persist(objreg);


    }

    @Override
    public List<RegistrationMst> getRegistrationDetails() {
        return em.createNamedQuery("RegistrationMst.findAll").getResultList();
    }

    @Override
    public List<RegistrationMst> getPendingRegistation() {

        return em.createQuery("Select r from RegistrationMst r where r.pending='Yes'").getResultList();

    }

    @Override
    public RegistrationMst getRegistrationDetails(Integer guestId) {
        return em.find(RegistrationMst.class, guestId);
    }

    @Override
    public void updateRegistration(Integer guestId, String guestName, String emailId, String phoneNo, String address, Long brokerId, String pending) {
        RegistrationMst regObj = em.find(RegistrationMst.class, guestId);
        regObj.setGuestName(guestName);
        regObj.setEmailId(emailId);
        regObj.setPhoneNo(phoneNo);
        regObj.setAddress(address);
        regObj.setPending(pending);
        BrokerMaster bm = em.find(BrokerMaster.class, brokerId);
        regObj.setBrokerId(bm);
        em.merge(regObj);
    }
    @Override
    public List<String[]> getMonthWiseTotal(Double trader_id) {
        List<Object[]> objList = em.createQuery("SELECT COUNT(t),t.orderId.orderType,FUNC('MONTHNAME', t.transDate) FROM TransactionDetails t  WHERE t.orderId.traderId.traderId=:traderId GROUP BY FUNC('MONTH', t.transDate), t.orderId.orderType ").setParameter("traderId", trader_id).getResultList();
        List<String[]> ls = new ArrayList<String[]>();
        for (Object[] resultElement : objList) {
            String[] singleList = new String[3];
            singleList[0] = resultElement[0].toString();
            singleList[1] = resultElement[1].toString();
            singleList[2] = resultElement[2].toString();
            ls.add(singleList);
        }
        return ls;
    }

    @Override
    public List getMonthAll(Double trader_id) {
        return em.createQuery("SELECT DISTINCT FUNC('MONTHNAME', t.transDate) FROM TransactionDetails t  WHERE t.orderId.traderId.traderId=:traderId").setParameter("traderId", trader_id).getResultList();  
    }
}
