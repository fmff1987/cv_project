package cv_project.beans;

import java.util.Collection;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import cv_project.control.ControllerRecruiter;
import cv_project.models.Order;
import cv_project.models.Recruiter;

@Named("recruiterbean")
@RequestScoped
public class Recruiterbean {

	////////////////////////////// ATRIBUTS
	 private Recruiter recruiter = new Recruiter();
	 
	 @Inject
	 private ControllerRecruiter cr;
	 
	 
	 ////////////////////////////// GETTER & SETTER
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
	
	public List<Recruiter> getRec(){
		return cr.getRec();
	}
	
//	public void getListO(){
//		recruiter.getListO();
//	}
//	
//	public void setList(List<Order> listO){
//		recruiter.setListO(listO);
//	}
}
