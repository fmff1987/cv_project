package pt.aubay.cv.models;

import java.util.ArrayList;
import java.util.Iterator;
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
	

})


public class Recruiter extends Person {
    
    private static final long serialVersionUID = 1L;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recruiter", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.REFRESH })
    private List<Request> requestList = new ArrayList<>();

    public List<Request> getRequestList() {
        return requestList;
    }

<<<<<<< HEAD:cv_project/src/main/java/cv_project/models/Recruiter.java
    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    @PreRemove
    public void preRemove() {
    	for(Request r: requestList) {
    		r.setRecruiter(null);
    	}
    }
=======
>>>>>>> Fernando:pt.aubay.cv/src/main/java/pt/aubay/cv/models/Recruiter.java
    
}
