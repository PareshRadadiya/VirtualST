package Entity;

import Entity.UserMaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(AdminMaster.class)
public class AdminMaster_ { 

    public static volatile SingularAttribute<AdminMaster, String> phoneNo;
    public static volatile SingularAttribute<AdminMaster, Integer> adminId;
    public static volatile SingularAttribute<AdminMaster, String> emailId;
    public static volatile SingularAttribute<AdminMaster, String> details;
    public static volatile SingularAttribute<AdminMaster, UserMaster> userId;

}