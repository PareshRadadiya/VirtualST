/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.StService_Service;
import Service.UserMaster;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Rushit
 */
@ManagedBean
@RequestScoped
public class passwordBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    /**
     * Creates a new instance of passwordBean
     */
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    HttpSession session = request.getSession();
    private String uname;
    private String curPwd;
    private String newPwd;
    private Service.UserMaster objUser;
    private String reset;
    private Boolean rend;
    private String msg;
   private String operation;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
   
   
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getReset() {
        return reset;
    }

    public Boolean getRend() {
        return rend;
    }

    public void setRend(Boolean rend) {
        this.rend = rend;
    }

    public void setReset(String reset) {
        this.reset = reset;
    }

    public UserMaster getObjUser() {
        return objUser;
    }

    public void setObjUser(UserMaster objUser) {
        this.objUser = objUser;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCurPwd() {
        return curPwd;
    }

    public void setCurPwd(String curPwd) {
        this.curPwd = curPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public passwordBean() {
    }

    public void checkPassword() throws Exception {
       
        Service.StService port = service.getStServicePort();
        objUser = port.getObjUserDetails(session.getAttribute("username").toString());
        MessageDigest objDigest = MessageDigest.getInstance("MD5");
        objDigest.update(curPwd.getBytes(), 0, curPwd.length());
        String digestCurPwd = new BigInteger(1, objDigest.digest()).toString(16);
        if (objUser.getPassword().equals(digestCurPwd)) {
             msg = "<div class='alert alert-success fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Current password is matched</div>";
            rend = false;          
        }else{
            msg = "<div class='alert alert-danger fade in'><a href='#' class='close' data-dismiss='alert'>&times;</a>Current password is not matched</div>";
            rend = true;   
        }

    }

    public void changePassword() throws Exception {
        Service.StService port = service.getStServicePort();
        MessageDigest objDigest = MessageDigest.getInstance("MD5");
        if (reset == null) {

            objDigest.update(newPwd.getBytes(), 0, newPwd.length());
            String password = new BigInteger(1, objDigest.digest()).toString(16);
            objDigest.update(curPwd.getBytes(), 0, curPwd.length());
            String password1 = new BigInteger(1, objDigest.digest()).toString(16);
            port.changePassword(uname, password1, password);
            operation="Added";
        } else {
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(999999999);
            newPwd = String.valueOf(randomInt);
            System.out.println(newPwd);
            objUser = port.getObjUserDetails(uname);
            if (objUser != null) {
                curPwd = "";
                objDigest.update(newPwd.getBytes(), 0, newPwd.length());
                String password = new BigInteger(1, objDigest.digest()).toString(16);

                port.changePassword(uname, curPwd, password);
                List<Service.BrokerMaster> broker = port.getBrokerByUserId(uname);
                List<Service.TraderMaster> trader = port.getTraderByUserId(uname);
                List<Service.AdminMaster> admin = port.getAdminByUserId(uname);
                if (broker.size() > 0) {
                    Iterator it = broker.iterator();
                    while (it.hasNext()) {
                        Service.BrokerMaster objBroker = (Service.BrokerMaster) it.next();
                        port.sendMail(objBroker.getCorporateEmail(), "Password Resetting For Virtual Stock Trading Users", "Your New Password Is:" + newPwd);
                        port.sendSms(objBroker.getPhoneNo(), "Password+Resetting+For+Virtual+Stock+Trading,+Your+New+Password+Is:+" + newPwd);
                    }
                } else if (trader.size() > 0) {
                    Iterator it = trader.iterator();
                    while (it.hasNext()) {
                        Service.TraderMaster objTrader = (Service.TraderMaster) it.next();
                        port.sendMail(objTrader.getEmailId(), "Password Resetting For Virtual Stock Trading Users", "Your New Password:" + newPwd);
                        port.sendSms(objTrader.getPhoneNo(), "Password+Resetting+For+Virtual+Stock+Trading,+Your+New+Password+Is:+" + newPwd);
                    }
                } else if (admin.size() > 0) {
                    Iterator it = admin.iterator();
                    while (it.hasNext()) {
                        Service.AdminMaster objAdmin = (Service.AdminMaster) it.next();
                        port.sendMail(objAdmin.getEmailId(), "Password Resetting For Virtual Stock Trading Users", "Your New Password:" + newPwd);
                        port.sendSms(objAdmin.getPhoneNo(), "Password+Resetting+For+Virtual+Stock+Trading,+Your+New+Password+Is:+" + newPwd);
                    }
                }

            }
        }
    }
}
