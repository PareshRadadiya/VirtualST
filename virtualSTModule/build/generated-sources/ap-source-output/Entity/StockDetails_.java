package Entity;

import Entity.OrderMaster;
import Entity.TraderStock;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(StockDetails.class)
public class StockDetails_ { 

    public static volatile SingularAttribute<StockDetails, String> groupType;
    public static volatile SingularAttribute<StockDetails, String> fax;
    public static volatile SingularAttribute<StockDetails, Integer> marketLot;
    public static volatile SingularAttribute<StockDetails, Date> listingDate;
    public static volatile SingularAttribute<StockDetails, String> website;
    public static volatile SingularAttribute<StockDetails, String> director;
    public static volatile SingularAttribute<StockDetails, String> companyName;
    public static volatile SingularAttribute<StockDetails, String> stat;
    public static volatile SingularAttribute<StockDetails, String> city;
    public static volatile SingularAttribute<StockDetails, String> phoneNo;
    public static volatile SingularAttribute<StockDetails, String> emailId;
    public static volatile SingularAttribute<StockDetails, String> scriptCode;
    public static volatile SingularAttribute<StockDetails, String> address;
    public static volatile ListAttribute<StockDetails, TraderStock> traderStockList;
    public static volatile ListAttribute<StockDetails, OrderMaster> orderMasterList;
    public static volatile SingularAttribute<StockDetails, Integer> faceValue;
    public static volatile SingularAttribute<StockDetails, String> scriptId;
    public static volatile SingularAttribute<StockDetails, String> industry;

}