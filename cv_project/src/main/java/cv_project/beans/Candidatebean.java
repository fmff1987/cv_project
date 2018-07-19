package cv_project.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import cv_project.control.ControllerCandidate;
import cv_project.models.Candidate;

@Named("CanBean")
@RequestScoped
public class Candidatebean {

	////////////////////////////// ATRIBUTS
	 private Candidate candidate = new Candidate();
	 
	 @Inject
	 private ControllerCandidate cc;
	 
	 
	 ////////////////////////////// GETTER & SETTER
	
		public Candidate getCandidate() {
			return candidate;
		}

		public void setCandidate(Candidate candidate) {
			this.candidate = candidate;
		}

		public ControllerCandidate getCc() {
			return cc;
		}

		public void setCc(ControllerCandidate cc) {
			this.cc = cc;
		}

		public List<Candidate> getCan(){
			return cc.getCan();
		}
		
		public void createCan() {
			cc.createCandidate(candidate);
		}
	
		public void removeRec() {
			cc.removeCandidate(candidate);
		}
		
		public void updateCan() {
			cc.updateCan();
		}
}
