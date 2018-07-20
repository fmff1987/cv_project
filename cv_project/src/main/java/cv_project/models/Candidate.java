package cv_project.models;

import javax.persistence.Entity;
import javax.persistence.Table;
        
import javax.persistence.OneToOne;


@Entity
@Table(name="cadidate")
public class Candidate extends Person {
	
    protected String cvAubay;
    
    
    @OneToOne(mappedBy="candidate")
    protected Request request;
    
    

    public Request getIdRequest() {
            return request;
    }
    public void setIdRequest(Request id) {
            this.request = id;
    }
    
    public String getCvAubay() {
            return cvAubay;
    }
    public void setCvAubay(String cv) {
            this.cvAubay = cv;
    }

}
