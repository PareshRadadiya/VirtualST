package Entity;

import Entity.CityMaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(StateMaster.class)
public class StateMaster_ { 

    public static volatile ListAttribute<StateMaster, CityMaster> cityMasterList;
    public static volatile SingularAttribute<StateMaster, Integer> stateId;
    public static volatile SingularAttribute<StateMaster, String> stateName;

}