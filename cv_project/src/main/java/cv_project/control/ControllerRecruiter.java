package cv_project.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import cv_project.models.Recruiter;
import cv_project.repositories.RecruiterRepository;
@Transactional
@RequestScoped
public class ControllerRecruiter {
	
	@Inject
	RecruiterRepository db;
		
	public void createRec(Recruiter p) {
	db.createEntity(p);
	}
	
	public List<Recruiter> getRec() {
	return db.getAll();
	}
	
	public void updateList() {
	//db.updateLocalList();
	}
	
	public void removeRec(Recruiter p) {
	db.removeEntity(p);
	//db.updateLocalList();
	}	
}
