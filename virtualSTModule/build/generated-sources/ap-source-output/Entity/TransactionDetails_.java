package Entity;

import Entity.OrderMaster;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(TransactionDetails.class)
public class TransactionDetails_ { 

    public static volatile SingularAttribute<TransactionDetails, Date> transDate;
    public static volatile SingularAttribute<TransactionDetails, Double> transId;
    public static volatile SingularAttribute<TransactionDetails, Double> brokrage;
    public static volatile SingularAttribute<TransactionDetails, OrderMaster> orderId;

}