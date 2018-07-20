package cv_project.models;

import java.util.Date;
import javax.persistence.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="request")
public class Request extends cv_project.models.Entity{
	
    private static final long serialVersionUID = 1L;

    @ManyToOne
    protected Manager manager;

    @ManyToOne
    protected Recruiter recruiter;

    /*@OneToOne
    protected Candidate candidate;*/

    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    private String candidateName;
    private String candidateEmail;

        
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }


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
    
    /*public Candidate getCandidateList() {
            return candidate;
    }
    public void setCandidateList(Candidate id) {
            candidate = id;
    }*/

}
