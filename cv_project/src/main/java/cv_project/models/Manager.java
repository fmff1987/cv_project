package cv_project.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
@Table(name="manager")
public class Manager extends Person {
	
    
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "manager", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
		CascadeType.REFRESH })
    private List<Request> requestList = new ArrayList<>();

    
    public List<Request> getListR() {
        return requestList;
    }

    public void setListR(List<Request> rList) {
        this.requestList = rList;
    }
    
}
