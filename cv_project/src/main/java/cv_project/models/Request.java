package cv_project.models;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="request")
public class Request extends cv_project.models.Entity{
	
	private static final long serialVersionUID = 1L;
    
        @ManyToOne
	protected Manager idManager;
        
        @ManyToMany(mappedBy="requestList")
	protected List<Recruiter> recruiterList = new ArrayList<>();
        
        @OneToMany(fetch = FetchType.EAGER, mappedBy = "idRequest", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
	protected List<Candidate> cadidateList = new ArrayList<>();
	
	
	public Manager getIdManager() {
		return idManager;
	}
	public void setIdManager(Manager idManager) {
		this.idManager = idManager;
	}
	public List getRecruiterList() {
		return recruiterList;
	}
	public void setRecruiterList(List<Recruiter> rList) {
		recruiterList = rList;
	}
	public List<Candidate> getCandidateList() {
		return cadidateList;
	}
	public void setCandidateList(List<Candidate> cList) {
		cadidateList = cList;
	}

}
