package cv_project.models;

import javax.persistence.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="request")
public class Request extends cv_project.models.Entity{
	
	private static final long serialVersionUID = 1L;
    
	protected String date;
	
    @ManyToOne
	protected Manager manager;
        
    @ManyToOne
	protected Recruiter recruiter;
        
    @OneToOne
	protected Candidate candidate;

        
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
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

		public Candidate getCandidate() {
			return candidate;
		}

		public void setCandidate(Candidate candidate) {
			this.candidate = candidate;
		}
	
}
