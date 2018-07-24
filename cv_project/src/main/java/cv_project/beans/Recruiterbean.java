package cv_project.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cv_project.control.ControllerRecruiter;
import cv_project.models.Recruiter;

@Named("RecBean")
@RequestScoped
public class Recruiterbean {


	 private Recruiter recruiter = new Recruiter();
	 private List<Recruiter> recruiterList;
	 
	 
	 public List<Recruiter> getRecruiterList() {
		return recruiterList;
	}
	@Inject
	 private ControllerRecruiter cr;
	 
	@PostConstruct
	private void loadRecruiters() {
		recruiterList = cr.getRec();
	}
//	public List<Recruiter> getRec(){
//		return cr.getRec();
//	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public ControllerRecruiter getCr() {
		return cr;
	}

	public void setCr(ControllerRecruiter cr) {
		this.cr = cr;
	}
	
	
	
	public void createRec() {
		cr.createRec(recruiter);
		//return "index";
	}
	
	public void removeRec() {
		cr.removeRec(recruiter);
	}
	public void updateRec() {
		cr.updateList();
	}
	

	

}
