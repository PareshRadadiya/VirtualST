package Entity;

import Entity.StateMaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(CityMaster.class)
public class CityMaster_ { 

    public static volatile SingularAttribute<CityMaster, Integer> cityId;
    public static volatile SingularAttribute<CityMaster, StateMaster> stateId;
    public static volatile SingularAttribute<CityMaster, String> cityName;

}