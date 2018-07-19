package cv_project.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="cadidate")
public class Candidate extends Person {
	
    protected String cv;
    
    @OneToOne(mappedBy="candidate")
    protected Request request;
    
    

    public Request getIdRequest() {
            return request;
    }
    public void setIdRequest(Request id) {
            this.request = id;
    }
    
    public String getCv() {
            return cv;
    }
    public void setCv(String cv) {
            this.cv = cv;
    }

}
