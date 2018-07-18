package cv_project.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.ManyToMany;


@Entity
@Table(name="recruiter")
public class Recruiter extends Person {
	
       @ManyToMany
	protected List<Request> requestList= new ArrayList<>();
       
	public List getListO() {
		return requestList;
	}

	public void setListO(List<Request> rList) {
		requestList = rList;
	}
	
}
