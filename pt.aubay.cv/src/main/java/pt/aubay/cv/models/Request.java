package pt.aubay.cv.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "request")
@NamedQueries({
	//São criadas as queries assim que o programa é compilado 
	@NamedQuery(name="Request.getAll",
			query="SELECT r FROM Request r JOIN FETCH r.manager JOIN FETCH r.recruiter"),
	@NamedQuery(name="Request.getAllWithRecruiterAndManagers",
	query="SELECT r FROM Request r JOIN FETCH r.manager WHERE r.recruiter IS  null"),
	
	@NamedQuery(name="Request.getAllAprovado", 
	query="SELECT r FROM Request r JOIN FETCH r.manager JOIN FETCH r.recruiter WHERE r.estado = :estado "),
	
	@NamedQuery(name= "Request.getAllNotAprovado", 
	query = "SELECT r FROM Request r JOIN FETCH r.manager JOIN FETCH r.recruiter WHERE NOT r.estado = :estado")
	
}) 


public class Request extends pt.aubay.cv.models.Entity {

    private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	protected Manager manager;

	@ManyToOne(fetch=FetchType.LAZY)
	protected Recruiter recruiter;

	private String candidateName;
	private String candidateEmail;
	
	@Enumerated(EnumType.STRING)
	private Status estado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    private String cvOrigPath;
    private String cvAubayPath;
    
    private String comment;
    

    public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Status getEstado() {
        return estado;
    }

    public void setEstado(Status estado) {
        this.estado = estado;
    }

    public String getCvOrigPath() {
        return cvOrigPath;
    }

    public void setCvOrigPath(String cvOrigPath) {
        this.cvOrigPath = cvOrigPath;
    }

    public String getCvAubayPath() {
        return cvAubayPath;
    }

    public void setCvAubayPath(String cvAubayPath) {
        this.cvAubayPath = cvAubayPath;
    }

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

    @PreRemove
    public void preRemove() {
        manager.getRequestList().remove(this);
        recruiter.getRequestList().remove(this);
    }

}
