package cv_project.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="request")
public class Request extends cv_project.models.Entity{
	
	private static final long serialVersionUID = 1L;
    
        @ManyToOne
	protected Manager manager;
        
        @ManyToOne
	protected Recruiter recruiter;
        
        @OneToOne
	protected Candidate candidate;
	
	
	public Manager getIdManager() {
		return manager;
	}
	public void setIdManager(Manager id) {
		this.manager = id;
	}
	public Recruiter getRecruiterList() {
		return recruiter;
	}
	public void setRecruiterList(Recruiter id) {
		recruiter = id;
	}
	public Candidate getCandidateList() {
		return candidate;
	}
	public void setCandidateList(Candidate id) {
		candidate = id;
	}

}
