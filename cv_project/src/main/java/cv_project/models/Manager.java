package cv_project.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@Table(name="manager")
@NamedQueries({
	@NamedQuery(name="Manager.getAll",
			query="SELECT m FROM Manager m"),
})


public class Manager extends Person {
	
    private static final long serialVersionUID = 1L;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manager", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
		CascadeType.REFRESH })
    private List<Request> requestList = new ArrayList<>();

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

   
    
}
