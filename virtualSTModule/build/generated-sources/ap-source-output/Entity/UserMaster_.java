package Entity;

import Entity.AdminMaster;
import Entity.BrokerMaster;
import Entity.TraderMaster;
import Entity.UserGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(UserMaster.class)
public class UserMaster_ { 

    public static volatile ListAttribute<UserMaster, BrokerMaster> brokerMasterList;
    public static volatile ListAttribute<UserMaster, UserGroup> userGroupList;
    public static volatile SingularAttribute<UserMaster, String> userId;
    public static volatile ListAttribute<UserMaster, TraderMaster> traderMasterList;
    public static volatile SingularAttribute<UserMaster, String> password;
    public static volatile ListAttribute<UserMaster, AdminMaster> adminMasterList;

}