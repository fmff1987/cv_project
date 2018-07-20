package cv_project.models;

import javax.persistence.ManyToOne;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;


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
        
        private String candidateName;
        private String candidateEmail;
        
        @Temporal(TemporalType.TIMESTAMP)
        private Date deadline;    

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }





}
