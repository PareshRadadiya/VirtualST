/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Bean.stockBeanLocal;
import Entity.AdminMaster;
import Entity.BrokerMaster;
import Entity.CityMaster;
import Entity.NewsMaster;
import Entity.OrderMaster;
import Entity.RegistrationMst;
import Entity.StateMaster;
import Entity.StockDetails;
import Entity.TraderMaster;
import Entity.TraderStock;
import Entity.TransactionDetails;
import Entity.UserGroup;
import Entity.UserMaster;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author paresh
 */
@WebService(serviceName = "stService")
@Stateless()
public class stService {
    @EJB
    private stockBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addStock")
    @Oneway
    public void addStock(@WebParam(name = "script_id") String script_id, @WebParam(name = "script_code") String script_code, @WebParam(name = "group") String group, @WebParam(name = "industry") String industry, @WebParam(name = "market_lot") Integer market_lot, @WebParam(name = "listing_date") Date listing_date, @WebParam(name = "face_value") Integer face_value, @WebParam(name = "company_name") String company_name, @WebParam(name = "address") String address, @WebParam(name = "state") String state, @WebParam(name = "city") String city, @WebParam(name = "phoneno") String phoneno, @WebParam(name = "fax") String fax, @WebParam(name = "email_id") String email_id, @WebParam(name = "director") String director, @WebParam(name = "website") String website) {
        ejbRef.addStock(script_id, script_code, group, industry, market_lot, listing_date, face_value, company_name, address, state, city, phoneno, fax, email_id, director, website);
    }

    @WebMethod(operationName = "updateStock")
    @Oneway
    public void updateStock(@WebParam(name = "script_id") String script_id, @WebParam(name = "script_code") String script_code, @WebParam(name = "group") String group, @WebParam(name = "industry") String industry, @WebParam(name = "market_lot") Integer market_lot, @WebParam(name = "listing_date") Date listing_date, @WebParam(name = "face_value") Integer face_value, @WebParam(name = "company_name") String company_name, @WebParam(name = "address") String address, @WebParam(name = "state") String state, @WebParam(name = "city") String city, @WebParam(name = "phoneno") String phoneno, @WebParam(name = "fax") String fax, @WebParam(name = "email_id") String email_id, @WebParam(name = "director") String director, @WebParam(name = "website") String website) {
        ejbRef.updateStock(script_id, script_code, group, industry, market_lot, listing_date, face_value, company_name, address, state, city, phoneno, fax, email_id, director, website);
    }

    @WebMethod(operationName = "deleteStock")
    @Oneway
    public void deleteStock(@WebParam(name = "script_id") String script_id) {
        ejbRef.deleteStock(script_id);
    }

    @WebMethod(operationName = "getStockDetails")
    public List<StockDetails> getStockDetails() {
        return ejbRef.getStockDetails();
    }

    @WebMethod(operationName = "getStockDetails_1")
    @RequestWrapper(className = "getStockDetails_1")
    @ResponseWrapper(className = "getStockDetails_1Response")
    public List<StockDetails> getStockDetails(@WebParam(name = "script_id") String script_id) {
        return ejbRef.getStockDetails(script_id);
    }

    @WebMethod(operationName = "addBroker")
    @Oneway
    public void addBroker(@WebParam(name = "broker_name") String broker_name, @WebParam(name = "user_id") String user_id, @WebParam(name = "correspond_office") String correspond_office, @WebParam(name = "state") String state, @WebParam(name = "city") String city, @WebParam(name = "clearingNo") String clearingNo, @WebParam(name = "trade_name") String trade_name, @WebParam(name = "corporate_email") String corporate_email, @WebParam(name = "phone_no") String phone_no, @WebParam(name = "SEBIno") String SEBIno, @WebParam(name = "deposit") Double deposit) {
        ejbRef.addBroker(broker_name, user_id, correspond_office, state, city, clearingNo, trade_name, corporate_email, phone_no, SEBIno, deposit);
    }

    @WebMethod(operationName = "updateBroker")
    @Oneway
    public void updateBroker(@WebParam(name = "broker_id") Long broker_id, @WebParam(name = "broker_name") String broker_name, @WebParam(name = "user_id") String user_id, @WebParam(name = "correspond_office") String correspond_office, @WebParam(name = "state") String state, @WebParam(name = "city") String city, @WebParam(name = "clearingNo") String clearingNo, @WebParam(name = "trade_name") String trade_name, @WebParam(name = "corporate_email") String corporate_email, @WebParam(name = "phone_no") String phone_no, @WebParam(name = "SEBIno") String SEBIno, @WebParam(name = "deposit") Double deposit, @WebParam(name = "fund") Double fund) {
        ejbRef.updateBroker(broker_id, broker_name, user_id, correspond_office, state, city, clearingNo, trade_name, corporate_email, phone_no, SEBIno, deposit, fund);
    }

    @WebMethod(operationName = "deleteBroker")
    @Oneway
    public void deleteBroker(@WebParam(name = "broker_id") Long broker_id) {
        ejbRef.deleteBroker(broker_id);
    }

    @WebMethod(operationName = "addBrokerFund")
    @Oneway
    public void addBrokerFund(@WebParam(name = "brokerId") Long brokerId, @WebParam(name = "fund") Double fund) {
        ejbRef.addBrokerFund(brokerId, fund);
    }

    @WebMethod(operationName = "getBrokerDetails")
    public List<BrokerMaster> getBrokerDetails() {
        return ejbRef.getBrokerDetails();
    }

    @WebMethod(operationName = "getBrokerDetails_1")
    @RequestWrapper(className = "getBrokerDetails_1")
    @ResponseWrapper(className = "getBrokerDetails_1Response")
    public List<BrokerMaster> getBrokerDetails(@WebParam(name = "broker_id") Long broker_id) {
        return ejbRef.getBrokerDetails(broker_id);
    }

    @WebMethod(operationName = "getObjBroker")
    public BrokerMaster getObjBroker(@WebParam(name = "broker_id") Long broker_id) {
        return ejbRef.getObjBroker(broker_id);
    }

    @WebMethod(operationName = "getBrokerByUserId")
    public List<BrokerMaster> getBrokerByUserId(@WebParam(name = "user_id") String user_id) {
        return ejbRef.getBrokerByUserId(user_id);
    }

    @WebMethod(operationName = "addNews")
    @Oneway
    public void addNews(@WebParam(name = "topic") String topic, @WebParam(name = "details") String details) {
        ejbRef.addNews(topic, details);
    }

    @WebMethod(operationName = "updateNews")
    @Oneway
    public void updateNews(@WebParam(name = "news_id") Long news_id, @WebParam(name = "topic") String topic, @WebParam(name = "details") String details) {
        ejbRef.updateNews(news_id, topic, details);
    }

    @WebMethod(operationName = "deleteNews")
    @Oneway
    public void deleteNews(@WebParam(name = "news_id") Long news_id) {
        ejbRef.deleteNews(news_id);
    }

    @WebMethod(operationName = "getNewsDetails")
    public List<NewsMaster> getNewsDetails() {
        return ejbRef.getNewsDetails();
    }

    @WebMethod(operationName = "getNewsDetails_1")
    @RequestWrapper(className = "getNewsDetails_1")
    @ResponseWrapper(className = "getNewsDetails_1Response")
    public List<NewsMaster> getNewsDetails(@WebParam(name = "newsId") Long newsId) {
        return ejbRef.getNewsDetails(newsId);
    }

    @WebMethod(operationName = "addOrder")
    @Oneway
    public void addOrder(@WebParam(name = "trader_id") Double trader_id, @WebParam(name = "volume") Long volume, @WebParam(name = "price") Double price, @WebParam(name = "script_id") String script_id, @WebParam(name = "order_date") Date order_date, @WebParam(name = "order_type") String order_type, @WebParam(name = "pending") String pending) {
        ejbRef.addOrder(trader_id, volume, price, script_id, order_date, order_type, pending);
    }

    @WebMethod(operationName = "updateOrder")
    @Oneway
    public void updateOrder(@WebParam(name = "order_id") Double order_id, @WebParam(name = "trader_id") Double trader_id, @WebParam(name = "volume") Long volume, @WebParam(name = "price") Double price, @WebParam(name = "script_id") String script_id, @WebParam(name = "order_date") Date order_date, @WebParam(name = "order_type") String order_type, @WebParam(name = "pending") String pending) {
        ejbRef.updateOrder(order_id, trader_id, volume, price, script_id, order_date, order_type, pending);
    }

    @WebMethod(operationName = "deleteOrder")
    @Oneway
    public void deleteOrder(@WebParam(name = "order_id") Double order_id) {
        ejbRef.deleteOrder(order_id);
    }

    @WebMethod(operationName = "getPendingOrder")
    public List<OrderMaster> getPendingOrder() {
        return ejbRef.getPendingOrder();
    }

    @WebMethod(operationName = "getPendingOrder_1")
    @RequestWrapper(className = "getPendingOrder_1")
    @ResponseWrapper(className = "getPendingOrder_1Response")
    public List<OrderMaster> getPendingOrder(@WebParam(name = "trader_id") Double trader_id, @WebParam(name = "order_type") String order_type, @WebParam(name = "script_id") String script_id, @WebParam(name = "order_date_from") Date order_date_from, @WebParam(name = "order_date_to") Date order_date_to) {
        return ejbRef.getPendingOrder(trader_id, order_type, script_id, order_date_from, order_date_to);
    }

    @WebMethod(operationName = "getOrderDetails")
    public List<OrderMaster> getOrderDetails() {
        return ejbRef.getOrderDetails();
    }

    @WebMethod(operationName = "getOrderDetails_1")
    @RequestWrapper(className = "getOrderDetails_1")
    @ResponseWrapper(className = "getOrderDetails_1Response")
    public List<OrderMaster> getOrderDetails(@WebParam(name = "trader_id") Double trader_id) {
        return ejbRef.getOrderDetails(trader_id);
    }

    @WebMethod(operationName = "getObjOrderDetails")
    public OrderMaster getObjOrderDetails(@WebParam(name = "order_id") Double order_id) {
        return ejbRef.getObjOrderDetails(order_id);
    }

    @WebMethod(operationName = "addTrader")
    @Oneway
    public void addTrader(@WebParam(name = "trader_name") String trader_name, @WebParam(name = "broker_id") Long broker_id, @WebParam(name = "user_id") String user_id, @WebParam(name = "deposite") Double deposite, @WebParam(name = "address") String address, @WebParam(name = "state") String state, @WebParam(name = "city") String city, @WebParam(name = "PANno") String PANno, @WebParam(name = "phoneno") String phoneno, @WebParam(name = "email_id") String email_id) {
        ejbRef.addTrader(trader_name, broker_id, user_id, deposite, address, state, city, PANno, phoneno, email_id);
    }

    @WebMethod(operationName = "updateTrader")
    @Oneway
    public void updateTrader(@WebParam(name = "trader_id") Double trader_id, @WebParam(name = "trader_name") String trader_name, @WebParam(name = "broker_id") Long broker_id, @WebParam(name = "user_id") String user_id, @WebParam(name = "deposite") Double deposite, @WebParam(name = "address") String address, @WebParam(name = "state") String state, @WebParam(name = "city") String city, @WebParam(name = "PANno") String PANno, @WebParam(name = "phoneno") String phoneno, @WebParam(name = "email_id") String email_id, @WebParam(name = "fund") Double fund) {
        ejbRef.updateTrader(trader_id, trader_name, broker_id, user_id, deposite, address, state, city, PANno, phoneno, email_id, fund);
    }

    @WebMethod(operationName = "deleteTrader")
    @Oneway
    public void deleteTrader(@WebParam(name = "trader_id") Double trader_id) {
        ejbRef.deleteTrader(trader_id);
    }

    @WebMethod(operationName = "addTraderFund")
    @Oneway
    public void addTraderFund(@WebParam(name = "traderId") Double traderId, @WebParam(name = "fund") Double fund) {
        ejbRef.addTraderFund(traderId, fund);
    }

    @WebMethod(operationName = "getTraderDetails")
    public List<TraderMaster> getTraderDetails() {
        return ejbRef.getTraderDetails();
    }

    @WebMethod(operationName = "getTraderDetailsByBrocker")
    public List<TraderMaster> getTraderDetailsByBrocker(@WebParam(name = "broker_id") Long broker_id) {
        return ejbRef.getTraderDetailsByBrocker(broker_id);
    }

    @WebMethod(operationName = "getTraderDetails_1")
    @RequestWrapper(className = "getTraderDetails_1")
    @ResponseWrapper(className = "getTraderDetails_1Response")
    public List<TraderMaster> getTraderDetails(@WebParam(name = "trader_id") Double trader_id) {
        return ejbRef.getTraderDetails(trader_id);
    }

    @WebMethod(operationName = "getTraderByUserId")
    public List<TraderMaster> getTraderByUserId(@WebParam(name = "user_id") String user_id) {
        return ejbRef.getTraderByUserId(user_id);
    }

    @WebMethod(operationName = "getTraderByBrokerId")
    public List<TraderMaster> getTraderByBrokerId(@WebParam(name = "broker_id") Long broker_id) {
        return ejbRef.getTraderByBrokerId(broker_id);
    }

    @WebMethod(operationName = "getObjTrader")
    public TraderMaster getObjTrader(@WebParam(name = "trader_id") Double trader_id) {
        return ejbRef.getObjTrader(trader_id);
    }

    @WebMethod(operationName = "addTransaction")
    @Oneway
    public void addTransaction() {
        ejbRef.addTransaction();
    }

    @WebMethod(operationName = "getTransactionDetails")
    public List<TransactionDetails> getTransactionDetails() {
        return ejbRef.getTransactionDetails();
    }

    @WebMethod(operationName = "getTransactionDetails_1")
    @RequestWrapper(className = "getTransactionDetails_1")
    @ResponseWrapper(className = "getTransactionDetails_1Response")
    public List<TransactionDetails> getTransactionDetails(@WebParam(name = "trader_id") Double trader_id) {
        return ejbRef.getTransactionDetails(trader_id);
    }

    @WebMethod(operationName = "getTransactionDetails_2")
    @RequestWrapper(className = "getTransactionDetails_2")
    @ResponseWrapper(className = "getTransactionDetails_2Response")
    public List<TransactionDetails> getTransactionDetails(@WebParam(name = "broker_id") Long broker_id) {
        return ejbRef.getTransactionDetails(broker_id);
    }

    @WebMethod(operationName = "getTransactionSell")
    public List<TransactionDetails> getTransactionSell(@WebParam(name = "broker_id") Long broker_id) {
        return ejbRef.getTransactionSell(broker_id);
    }

    @WebMethod(operationName = "getTransactionBuy")
    public List<TransactionDetails> getTransactionBuy(@WebParam(name = "broker_id") Long broker_id) {
        return ejbRef.getTransactionBuy(broker_id);
    }

    @WebMethod(operationName = "getTransactionSell_1")
    @RequestWrapper(className = "getTransactionSell_1")
    @ResponseWrapper(className = "getTransactionSell_1Response")
    public List<TransactionDetails> getTransactionSell(@WebParam(name = "trader_id") Double trader_id) {
        return ejbRef.getTransactionSell(trader_id);
    }

    @WebMethod(operationName = "getTransactionBuy_1")
    @RequestWrapper(className = "getTransactionBuy_1")
    @ResponseWrapper(className = "getTransactionBuy_1Response")
    public List<TransactionDetails> getTransactionBuy(@WebParam(name = "trader_id") Double trader_id) {
        return ejbRef.getTransactionBuy(trader_id);
    }

    @WebMethod(operationName = "getTransactionSell_2")
    @RequestWrapper(className = "getTransactionSell_2")
    @ResponseWrapper(className = "getTransactionSell_2Response")
    public List<TransactionDetails> getTransactionSell() {
        return ejbRef.getTransactionSell();
    }

    @WebMethod(operationName = "getTransactionBuy_2")
    @RequestWrapper(className = "getTransactionBuy_2")
    @ResponseWrapper(className = "getTransactionBuy_2Response")
    public List<TransactionDetails> getTransactionBuy() {
        return ejbRef.getTransactionBuy();
    }

    @WebMethod(operationName = "getTransactionOfMonth")
    public List<TransactionDetails> getTransactionOfMonth() {
        return ejbRef.getTransactionOfMonth();
    }

    @WebMethod(operationName = "getMonthWiseTotal")
    public List<String[]> getMonthWiseTotal(@WebParam(name = "trader_id") Double trader_id) {
        return ejbRef.getMonthWiseTotal(trader_id);
    }

    @WebMethod(operationName = "getMonthWiseMonth")
    public List getMonthWiseMonth(@WebParam(name = "trader_id") Double trader_id) {
        return ejbRef.getMonthWiseMonth(trader_id);
    }

    @WebMethod(operationName = "getTransactionDetails_3")
    @RequestWrapper(className = "getTransactionDetails_3")
    @ResponseWrapper(className = "getTransactionDetails_3Response")
    public List<TransactionDetails> getTransactionDetails(@WebParam(name = "trader_id") Double trader_id, @WebParam(name = "order_type") String order_type, @WebParam(name = "script_id") String script_id, @WebParam(name = "order_date_from") Date order_date_from, @WebParam(name = "order_date_to") Date order_date_to) {
        return ejbRef.getTransactionDetails(trader_id, order_type, script_id, order_date_from, order_date_to);
    }

    @WebMethod(operationName = "addUser")
    @Oneway
    public void addUser(@WebParam(name = "user_id") String user_id, @WebParam(name = "password") String password) {
        ejbRef.addUser(user_id, password);
    }

    @WebMethod(operationName = "updateUser")
    @Oneway
    public void updateUser(@WebParam(name = "user_id") String user_id, @WebParam(name = "password") String password) {
        ejbRef.updateUser(user_id, password);
    }

    @WebMethod(operationName = "deleteUser")
    @Oneway
    public void deleteUser(@WebParam(name = "user_id") String user_id) {
        ejbRef.deleteUser(user_id);
    }

    @WebMethod(operationName = "getUserMasterDetails")
    public List<UserMaster> getUserMasterDetails() {
        return ejbRef.getUserMasterDetails();
    }

    @WebMethod(operationName = "getObjUserDetails")
    public UserMaster getObjUserDetails(@WebParam(name = "user_id") String user_id) {
        return ejbRef.getObjUserDetails(user_id);
    }

    @WebMethod(operationName = "deleteUserGroup")
    @Oneway
    public void deleteUserGroup(@WebParam(name = "user_id") String user_id, @WebParam(name = "group") String group) {
        ejbRef.deleteUserGroup(user_id, group);
    }

    @WebMethod(operationName = "addUserSGroup")
    @Oneway
    public void addUserSGroup(@WebParam(name = "user_id") String user_id, @WebParam(name = "group_type") String group_type) {
        ejbRef.addUserSGroup(user_id, group_type);
    }

    @WebMethod(operationName = "getUserGroupDetails")
    public List<UserGroup> getUserGroupDetails() {
        return ejbRef.getUserGroupDetails();
    }

    @WebMethod(operationName = "addAdmin")
    @Oneway
    public void addAdmin(@WebParam(name = "userId") String userId, @WebParam(name = "emailId") String emailId, @WebParam(name = "phoneNo") String phoneNo, @WebParam(name = "details") String details) {
        ejbRef.addAdmin(userId, emailId, phoneNo, details);
    }

    @WebMethod(operationName = "deleteAdmin")
    @Oneway
    public void deleteAdmin(@WebParam(name = "adminId") Integer adminId) {
        ejbRef.deleteAdmin(adminId);
    }

    @WebMethod(operationName = "getAdminDetails")
    public List<AdminMaster> getAdminDetails() {
        return ejbRef.getAdminDetails();
    }

    @WebMethod(operationName = "getAdminByUserId")
    public List<AdminMaster> getAdminByUserId(@WebParam(name = "user_id") String user_id) {
        return ejbRef.getAdminByUserId(user_id);
    }

    @WebMethod(operationName = "checkUserAvability")
    public boolean checkUserAvability(@WebParam(name = "user_id") String user_id) {
        return ejbRef.checkUserAvability(user_id);
    }

    @WebMethod(operationName = "getQuotes")
    public List getQuotes(@WebParam(name = "Stock_Symbol") String Stock_Symbol) {
        return ejbRef.getQuotes(Stock_Symbol);
    }

    @WebMethod(operationName = "changePassword")
    @Oneway
    public void changePassword(@WebParam(name = "uname") String uname, @WebParam(name = "curPwd") String curPwd, @WebParam(name = "newPwd") String newPwd) {
        ejbRef.changePassword(uname, curPwd, newPwd);
    }

    @WebMethod(operationName = "getTraddersStock")
    public List<TraderStock> getTraddersStock(@WebParam(name = "trader_id") Double trader_id) {
        return ejbRef.getTraddersStock(trader_id);
    }

    @WebMethod(operationName = "getTraddersStock_1")
    @RequestWrapper(className = "getTraddersStock_1")
    @ResponseWrapper(className = "getTraddersStock_1Response")
    public List<TraderStock> getTraddersStock() {
        return ejbRef.getTraddersStock();
    }

    @WebMethod(operationName = "getObjTraddersStock")
    public TraderStock getObjTraddersStock(@WebParam(name = "trader_id") Double trader_id, @WebParam(name = "script_id") String script_id) {
        return ejbRef.getObjTraddersStock(trader_id, script_id);
    }

    @WebMethod(operationName = "getAllStates")
    public List<StateMaster> getAllStates() {
        return ejbRef.getAllStates();
    }

    @WebMethod(operationName = "getCityByState")
    public List<CityMaster> getCityByState(@WebParam(name = "stateId") Integer stateId) {
        return ejbRef.getCityByState(stateId);
    }

    @WebMethod(operationName = "getAllCity")
    public List<CityMaster> getAllCity() {
        return ejbRef.getAllCity();
    }

    @WebMethod(operationName = "getState")
    public List<StateMaster> getState(@WebParam(name = "state_name") String state_name) {
        return ejbRef.getState(state_name);
    }

    @WebMethod(operationName = "getObjState")
    public StateMaster getObjState(@WebParam(name = "state_id") Integer state_id) {
        return ejbRef.getObjState(state_id);
    }

    @WebMethod(operationName = "getAuto")
    public List getAuto(@WebParam(name = "Stock_Symbol") String Stock_Symbol) {
        return ejbRef.getAuto(Stock_Symbol);
    }

    @WebMethod(operationName = "sendMail")
    @Oneway
    public void sendMail(@WebParam(name = "Receiver") String Receiver, @WebParam(name = "Sub") String Sub, @WebParam(name = "Msg") String Msg) {
        ejbRef.sendMail(Receiver, Sub, Msg);
    }

    @WebMethod(operationName = "sendSms")
    @Oneway
    public void sendSms(@WebParam(name = "phone") Object phone, @WebParam(name = "msg") String msg) {
        ejbRef.sendSms(phone, msg);
    }

    @WebMethod(operationName = "registrationTrader")
    @Oneway
    public void registrationTrader(@WebParam(name = "guestName") String guestName, @WebParam(name = "emailId") String emailId, @WebParam(name = "phoneNo") String phoneNo, @WebParam(name = "address") String address, @WebParam(name = "stat") String stat, @WebParam(name = "city") String city, @WebParam(name = "pin") String pin, @WebParam(name = "pan") String pan, @WebParam(name = "brokerId") Long brokerId, @WebParam(name = "pending") String pending) {
        ejbRef.registrationTrader(guestName, emailId, phoneNo, address, stat, city, pin, pan, brokerId, pending);
    }

    @WebMethod(operationName = "getRegistrationDetails")
    public List<RegistrationMst> getRegistrationDetails() {
        return ejbRef.getRegistrationDetails();
    }

    @WebMethod(operationName = "getRegistrationDetails_1")
    @RequestWrapper(className = "getRegistrationDetails_1")
    @ResponseWrapper(className = "getRegistrationDetails_1Response")
    public RegistrationMst getRegistrationDetails(@WebParam(name = "guestId") Integer guestId) {
        return ejbRef.getRegistrationDetails(guestId);
    }

    @WebMethod(operationName = "getPendingRegistation")
    public List<RegistrationMst> getPendingRegistation() {
        return ejbRef.getPendingRegistation();
    }

    @WebMethod(operationName = "updateRegistration")
    @Oneway
    public void updateRegistration(@WebParam(name = "guestId") Integer guestId, @WebParam(name = "guestName") String guestName, @WebParam(name = "emailId") String emailId, @WebParam(name = "phoneNo") String phoneNo, @WebParam(name = "address") String address, @WebParam(name = "brokerId") Long brokerId, @WebParam(name = "pending") String pending) {
        ejbRef.updateRegistration(guestId, guestName, emailId, phoneNo, address, brokerId, pending);
    }

    @WebMethod(operationName = "getMonthAll")
    public List getMonthAll(@WebParam(name = "trader_id") Double trader_id) {
        return ejbRef.getMonthAll(trader_id);
    }
    
}
