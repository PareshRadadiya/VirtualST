package Entity;

import Entity.RegistrationMst;
import Entity.TraderMaster;
import Entity.UserMaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(BrokerMaster.class)
public class BrokerMaster_ { 

    public static volatile SingularAttribute<BrokerMaster, String> clearingNo;
    public static volatile SingularAttribute<BrokerMaster, Double> deposit;
    public static volatile SingularAttribute<BrokerMaster, String> tradeName;
    public static volatile ListAttribute<BrokerMaster, TraderMaster> traderMasterList;
    public static volatile SingularAttribute<BrokerMaster, String> sebiNo;
    public static volatile SingularAttribute<BrokerMaster, Long> brokerId;
    public static volatile SingularAttribute<BrokerMaster, String> stat;
    public static volatile SingularAttribute<BrokerMaster, String> city;
    public static volatile SingularAttribute<BrokerMaster, String> phoneNo;
    public static volatile ListAttribute<BrokerMaster, RegistrationMst> registrationList;
    public static volatile SingularAttribute<BrokerMaster, String> corporateEmail;
    public static volatile SingularAttribute<BrokerMaster, String> correspondOffice;
    public static volatile SingularAttribute<BrokerMaster, UserMaster> userId;
    public static volatile SingularAttribute<BrokerMaster, String> brokerName;
    public static volatile SingularAttribute<BrokerMaster, Double> fund;

}