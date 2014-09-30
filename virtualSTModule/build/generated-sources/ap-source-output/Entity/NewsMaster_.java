package Entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-02T23:04:46")
@StaticMetamodel(NewsMaster.class)
public class NewsMaster_ { 

    public static volatile SingularAttribute<NewsMaster, String> topic;
    public static volatile SingularAttribute<NewsMaster, Long> newsId;
    public static volatile SingularAttribute<NewsMaster, String> details;
    public static volatile SingularAttribute<NewsMaster, Date> newsDate;

}