/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Service.StService_Service;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author paresh
 */
@ManagedBean
@RequestScoped
public class authBackingBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/stService/stService.wsdl")
    private StService_Service service;
    private String username;
    private String password;
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    HttpSession session = request.getSession();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {

        try {
            request.login(username, password);
            session.setAttribute("username", username);
            session.setAttribute("action", "add");
        } catch (ServletException e) {
            e.printStackTrace();
            return "error?faces-redirect=true";
        }
        if (request.isUserInRole("Admin")) {
            session.setAttribute("usertype", "Admin");
            return "/Admin/Home?faces-redirect=true";
        } else if (request.isUserInRole("Broker")) {
            session.setAttribute("usertype", "Broker");
            Service.StService port = service.getStServicePort();
            List<Service.BrokerMaster> broker = port.getBrokerByUserId(username);
            Iterator it = broker.iterator();
            while (it.hasNext()) {
                Service.BrokerMaster objBroker = (Service.BrokerMaster) it.next();
                session.setAttribute("user", objBroker.getBrokerId());

            }
            return "/Broker/Home?faces-redirect=true";
        } else if (request.isUserInRole("Trader")) {
            session.setAttribute("usertype", "Trader");
            Service.StService port = service.getStServicePort();
            List<Service.TraderMaster> trader = port.getTraderByUserId(username);
            Iterator it = trader.iterator();
            while (it.hasNext()) {
                Service.TraderMaster objTrader = (Service.TraderMaster) it.next();

                session.setAttribute("user", objTrader.getTraderId());
            }
            return "/Trader/Home?faces-redirect=true";
        } else {
            return "error?faces-redirect=true";
        }
    }

    public String logout() {
        String result = "/index?faces-redirect=true";
        try {
            request.logout();
            session.invalidate();

        } catch (ServletException e) {

            result = "/index?faces-redirect=true";
        }
        return result;
    }
}
