package cv_project.models;

import javax.persistence.Entity;
import javax.persistence.Table;
        
import javax.persistence.ManyToOne;


@Entity
@Table(name="cadidate")
public class Candidate extends Person {
	
    protected String cv;
    
    @ManyToOne
    protected Request idRequest;
    
    

    public Request getIdRequest() {
            return idRequest;
    }
    public void setIdRequest(Request idOrder) {
            this.idRequest = idOrder;
    }
    
    public String getCv() {
            return cv;
    }
    public void setCv(String cv) {
            this.cv = cv;
    }

}
