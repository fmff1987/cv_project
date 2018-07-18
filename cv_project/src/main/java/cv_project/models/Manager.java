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
	
    private static final long serialVersionUID = 1L;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idManager", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
    private List<Request> ListO = new ArrayList<>();
    
}
