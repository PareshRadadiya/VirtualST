package Entity;

import Entity.BrokerMaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(RegistrationMst.class)
public class RegistrationMst_ { 

    public static volatile SingularAttribute<RegistrationMst, String> phoneNo;
    public static volatile SingularAttribute<RegistrationMst, String> pincode;
    public static volatile SingularAttribute<RegistrationMst, String> guestName;
    public static volatile SingularAttribute<RegistrationMst, String> emailId;
    public static volatile SingularAttribute<RegistrationMst, String> panNo;
    public static volatile SingularAttribute<RegistrationMst, String> address;
    public static volatile SingularAttribute<RegistrationMst, String> pending;
    public static volatile SingularAttribute<RegistrationMst, Integer> guestId;
    public static volatile SingularAttribute<RegistrationMst, BrokerMaster> brokerId;
    public static volatile SingularAttribute<RegistrationMst, String> stat;
    public static volatile SingularAttribute<RegistrationMst, String> city;

}