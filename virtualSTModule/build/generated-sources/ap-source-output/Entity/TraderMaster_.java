package Entity;

import Entity.BrokerMaster;
import Entity.OrderMaster;
import Entity.TraderStock;
import Entity.UserMaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(TraderMaster.class)
public class TraderMaster_ { 

    public static volatile SingularAttribute<TraderMaster, Double> deposit;
    public static volatile SingularAttribute<TraderMaster, String> traderName;
    public static volatile SingularAttribute<TraderMaster, BrokerMaster> brokerId;
    public static volatile SingularAttribute<TraderMaster, String> stat;
    public static volatile SingularAttribute<TraderMaster, String> city;
    public static volatile SingularAttribute<TraderMaster, String> phoneNo;
    public static volatile SingularAttribute<TraderMaster, String> emailId;
    public static volatile SingularAttribute<TraderMaster, String> panNo;
    public static volatile SingularAttribute<TraderMaster, Double> traderId;
    public static volatile SingularAttribute<TraderMaster, String> address;
    public static volatile SingularAttribute<TraderMaster, UserMaster> userId;
    public static volatile ListAttribute<TraderMaster, OrderMaster> orderMasterList;
    public static volatile ListAttribute<TraderMaster, TraderStock> traderStockList;
    public static volatile SingularAttribute<TraderMaster, Double> fund;

}