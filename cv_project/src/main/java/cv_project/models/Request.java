package cv_project.models;

import javax.persistence.ManyToOne;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="request")
public class Request extends cv_project.models.Entity {
	
	private static final long serialVersionUID = 1L;
    
        @ManyToOne(fetch=FetchType.LAZY)
	protected Manager manager;
        
        @ManyToOne
	protected Recruiter recruiter;
        
        @OneToOne
	protected Candidate candidate;
        
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;    
	
	
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
