package cv_project.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;


@Entity
@Table(name="recruiter")
public class Recruiter extends Person {
    
    private static final long serialVersionUID = 1L;
	
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recruiter", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.REFRESH })
    private List<Request> requestList = new ArrayList<>();

    public List getListO() {
            return requestList;
    }

    public void setListO(List<Request> rList) {
            requestList = rList;
    } 
    
}
