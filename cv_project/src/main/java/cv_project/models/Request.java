package cv_project.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="request")
@NamedQueries({
	@NamedQuery(name="Request.getAll",
			query="SELECT r FROM Request r"),
//	@NamedQuery(name="Request.getAllWithManagers",
//	query="SELECT r FROM Request r JOIN FETCH r.manager "),
//	@NamedQuery(name="Request.getAllWithRecruiter",
//	query="SELECT r FROM Request r JOIN FETCH r.recruiter"),
	
}) 

public class Request extends cv_project.models.Entity {


	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.EAGER)
	private Manager manager;

	@ManyToOne
	private Recruiter recruiter;

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
