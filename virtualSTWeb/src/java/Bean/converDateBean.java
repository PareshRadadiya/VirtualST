/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author paresh
 */
@ManagedBean
@RequestScoped
public class converDateBean {

    public String convertTime(Date time) throws DatatypeConfigurationException {
        //Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal);

        Format format = new SimpleDateFormat("MM-DD-YYYY");
        return format.format(xcal);
    }
}
