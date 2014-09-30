/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import Entity.*;
import java.util.*;
import javax.ejb.Remote;

/**
 *
 * @author paresh
 */
@Remote
public interface stockBeanLocal {
public void addStock(String script_id,String script_code,String group,String industry,Integer market_lot,Date listing_date,Integer face_value,String company_name,String address,String state,String city,String phoneno,String fax,String email_id,String director,String website);
public void updateStock(String script_id,String script_code,String group,String industry,Integer market_lot,Date listing_date,Integer face_value,String company_name,String address,String state,String city,String phoneno,String fax,String email_id,String director,String website);
public void deleteStock(String script_id);
public List<StockDetails> getStockDetails();
public List<StockDetails> getStockDetails(String script_id);

public void addBroker(String broker_name,String user_id,String correspond_office,String state,String city,String clearingNo,String trade_name,String corporate_email,String phone_no, String SEBIno,Double deposit);
public void updateBroker(Long broker_id,String broker_name,String user_id,String correspond_office,String state,String city,String clearingNo,String trade_name,String corporate_email,String phone_no, String SEBIno,Double deposit,Double fund);
public void deleteBroker(Long broker_id);
public void addBrokerFund(Long brokerId, Double fund);
public List<BrokerMaster> getBrokerDetails();
public List<BrokerMaster> getBrokerDetails(Long broker_id);
public BrokerMaster getObjBroker(Long broker_id);
public List<BrokerMaster> getBrokerByUserId(String user_id);

public void addNews(String topic,String details);
public void updateNews(Long news_id,String topic,String details);
public void deleteNews(Long news_id);
public List<NewsMaster> getNewsDetails();
public List<NewsMaster> getNewsDetails(Long newsId);

public void addOrder(Double trader_id,Long volume,Double price,String script_id,Date order_date,String order_type,String pending);
public void updateOrder(Double order_id,Double trader_id,Long volume,Double price,String script_id,Date order_date,String order_type,String pending);
public void deleteOrder(Double order_id);
public List<OrderMaster> getPendingOrder();
public List<OrderMaster> getPendingOrder(Double trader_id,String order_type,String script_id,Date order_date_from, Date order_date_to);
public List<OrderMaster> getOrderDetails();
public List<OrderMaster> getOrderDetails(Double trader_id);
public OrderMaster getObjOrderDetails(Double order_id);


public void addTrader(String trader_name,Long broker_id,String user_id,Double deposite,String address,String state,String city,String PANno,String phoneno,String email_id);
public void updateTrader(Double trader_id,String trader_name,Long broker_id,String user_id,Double deposite,String address,String state,String city,String PANno,String phoneno,String email_id,Double fund);
public void deleteTrader(Double trader_id);
public void addTraderFund(Double traderId, Double fund);
public List<TraderMaster> getTraderDetails();
public List<TraderMaster> getTraderDetailsByBrocker(Long broker_id);
public List<TraderMaster> getTraderDetails(Double trader_id);
public List<TraderMaster> getTraderByUserId(String user_id);
public List<TraderMaster> getTraderByBrokerId(Long broker_id);
public TraderMaster getObjTrader(Double trader_id );

public void addTransaction();
public List<TransactionDetails> getTransactionDetails();
public List<TransactionDetails> getTransactionDetails(Double trader_id);
public List<TransactionDetails> getTransactionDetails(Long broker_id);
public List<TransactionDetails> getTransactionSell(Long broker_id);
public List<TransactionDetails> getTransactionBuy(Long broker_id);
public List<TransactionDetails> getTransactionSell(Double trader_id);
public List<TransactionDetails> getTransactionBuy(Double trader_id);
public List<TransactionDetails> getTransactionSell();
public List<TransactionDetails> getTransactionBuy();
public List<TransactionDetails> getTransactionOfMonth();
public List<String[]> getMonthWiseTotal(Double trader_id);
public   List getMonthWiseMonth(Double trader_id);

public List<TransactionDetails> getTransactionDetails(Double trader_id,String order_type,String script_id,Date order_date_from, Date order_date_to);

public void addUser(String user_id,String password);
public void updateUser(String user_id,String password);
public void deleteUser(String user_id);
public List<UserMaster> getUserMasterDetails();
public UserMaster getObjUserDetails(String user_id);

public void deleteUserGroup(String user_id,String group);
public void addUserSGroup(String user_id,String group_type);
public List<UserGroup> getUserGroupDetails();


public void addAdmin(String userId, String emailId, String phoneNo, String details);
public void deleteAdmin(Integer adminId);
public List<AdminMaster> getAdminDetails();
public List<AdminMaster> getAdminByUserId(String user_id);

public boolean checkUserAvability(String user_id);

public List getQuotes(String Stock_Symbol); 

public void changePassword(String uname, String curPwd, String newPwd);

public List<TraderStock> getTraddersStock(Double trader_id );
public List<TraderStock> getTraddersStock();
public TraderStock getObjTraddersStock(Double trader_id, String script_id);


public List<StateMaster> getAllStates();
public List<CityMaster> getCityByState(Integer stateId);
public List<CityMaster> getAllCity();
public List<StateMaster> getState(String state_name);
public StateMaster getObjState(Integer state_id);
public List getAuto(String Stock_Symbol);

public void sendMail(String Receiver,String Sub,String Msg);
public void sendSms(Object phone, String msg);


     public void registrationTrader(String guestName, String emailId, String phoneNo, String address,String stat,String city,String pin, String pan,Long brokerId, String pending);
     
     public List<RegistrationMst> getRegistrationDetails();

    public RegistrationMst getRegistrationDetails(Integer guestId);

    public List<RegistrationMst> getPendingRegistation();

    public void updateRegistration(Integer guestId, String guestName, String emailId, String phoneNo, String address, Long brokerId, String pending);
    public List getMonthAll(Double trader_id);
}
