
package Service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-2b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "stService", targetNamespace = "http://Service/", wsdlLocation = "http://localhost:8080/stService/stService?wsdl")
public class StService_Service
    extends Service
{

    private final static URL STSERVICE_WSDL_LOCATION;
    private final static WebServiceException STSERVICE_EXCEPTION;
    private final static QName STSERVICE_QNAME = new QName("http://Service/", "stService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/stService/stService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STSERVICE_WSDL_LOCATION = url;
        STSERVICE_EXCEPTION = e;
    }

    public StService_Service() {
        super(__getWsdlLocation(), STSERVICE_QNAME);
    }

    public StService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), STSERVICE_QNAME, features);
    }

    public StService_Service(URL wsdlLocation) {
        super(wsdlLocation, STSERVICE_QNAME);
    }

    public StService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, STSERVICE_QNAME, features);
    }

    public StService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns StService
     */
    @WebEndpoint(name = "stServicePort")
    public StService getStServicePort() {
        return super.getPort(new QName("http://Service/", "stServicePort"), StService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StService
     */
    @WebEndpoint(name = "stServicePort")
    public StService getStServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Service/", "stServicePort"), StService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (STSERVICE_EXCEPTION!= null) {
            throw STSERVICE_EXCEPTION;
        }
        return STSERVICE_WSDL_LOCATION;
    }

}
