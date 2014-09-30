/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paresh
 */
@Entity
@Table(name = "news_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewsMaster.findAll", query = "SELECT n FROM NewsMaster n"),
    @NamedQuery(name = "NewsMaster.findByNewsId", query = "SELECT n FROM NewsMaster n WHERE n.newsId = :newsId"),
    @NamedQuery(name = "NewsMaster.findByTopic", query = "SELECT n FROM NewsMaster n WHERE n.topic = :topic"),
    @NamedQuery(name = "NewsMaster.findByNewsDate", query = "SELECT n FROM NewsMaster n WHERE n.newsDate = :newsDate"),
    @NamedQuery(name = "NewsMaster.findByDetails", query = "SELECT n FROM NewsMaster n WHERE n.details = :details")})
public class NewsMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "news_id")
    private Long newsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "topic")
    private String topic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "news_date")
    @Temporal(TemporalType.DATE)
    private Date newsDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11000)
    @Column(name = "details")
    private String details;

    public NewsMaster() {
    }

    public NewsMaster(Long newsId) {
        this.newsId = newsId;
    }

    public NewsMaster( String topic, Date newsDate, String details) {
        
        this.topic = topic;
        this.newsDate = newsDate;
        this.details = details;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsId != null ? newsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsMaster)) {
            return false;
        }
        NewsMaster other = (NewsMaster) object;
        if ((this.newsId == null && other.newsId != null) || (this.newsId != null && !this.newsId.equals(other.newsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.NewsMaster[ newsId=" + newsId + " ]";
    }
    
}
