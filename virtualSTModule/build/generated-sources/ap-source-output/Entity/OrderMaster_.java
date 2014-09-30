package Entity;

import Entity.StockDetails;
import Entity.TraderMaster;
import Entity.TransactionDetails;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(OrderMaster.class)
public class OrderMaster_ { 

    public static volatile SingularAttribute<OrderMaster, Double> price;
    public static volatile ListAttribute<OrderMaster, TransactionDetails> transactionDetailsList;
    public static volatile SingularAttribute<OrderMaster, String> orderType;
    public static volatile SingularAttribute<OrderMaster, TraderMaster> traderId;
    public static volatile SingularAttribute<OrderMaster, Date> orderDate;
    public static volatile SingularAttribute<OrderMaster, String> pending;
    public static volatile SingularAttribute<OrderMaster, Long> volume;
    public static volatile SingularAttribute<OrderMaster, StockDetails> scriptId;
    public static volatile SingularAttribute<OrderMaster, Double> orderId;

}