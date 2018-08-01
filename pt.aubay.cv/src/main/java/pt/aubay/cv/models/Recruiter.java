package pt.aubay.cv.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;


@Entity
@Table(name="recruiter")
@NamedQueries({
	@NamedQuery(name="Recruiter.getAll",
			query="SELECT r FROM Recruiter r"),
	@NamedQuery(name= "Recruiter.getRecruiterActive",
	query = "SELECT r FROM Recruiter r WHERE r.active = true"),
	
})


public class Recruiter extends Person {
    
    private static final long serialVersionUID = 1L;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recruiter", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.REFRESH })
    private List<Request> requestList = new ArrayList<>();

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    @PreRemove
    public void preRemove() {
    	for(Request r: requestList) {
    		r.setRecruiter(null);
    	}
    }
    
}
