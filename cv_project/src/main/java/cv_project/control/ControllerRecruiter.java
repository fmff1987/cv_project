package cv_project.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import cv_project.models.Recruiter;
import cv_project.repositories.RecruiterRepository;

@RequestScoped
public class ControllerRecruiter {
	
	@Inject
	RecruiterRepository db;
		
	public void createRec(Recruiter p) {
	db.createEntity(p);
	}
	
	public List<Recruiter> getRec() {
	return db.getList(Recruiter.class);
	}
	
	public void updateList() {
	db.updateLocalList();
	}
	
	public void removeRec(Recruiter p) {
	db.removeEntity(p);
	db.updateLocalList();
	}	
}
