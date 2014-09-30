package Entity;

import Entity.StockDetails;
import Entity.TraderMaster;
import Entity.TraderStockPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(TraderStock.class)
public class TraderStock_ { 

    public static volatile SingularAttribute<TraderStock, StockDetails> stockDetails;
    public static volatile SingularAttribute<TraderStock, Long> volume;
    public static volatile SingularAttribute<TraderStock, TraderMaster> traderMaster;
    public static volatile SingularAttribute<TraderStock, TraderStockPK> traderStockPK;

}