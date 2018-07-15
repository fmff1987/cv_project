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
		
	public void createRecruiter(Recruiter p) {
		db.createEntity(p);
	}
	
	public void removeRecruter(Recruiter p) {
		db.removeEntity(p);
		updateList();
		
	}
	
	public void updateList() {
		db.updateLocalList();
	}

	public List<Recruiter> getRec() {
		return db.getList(Recruiter.class);
	}
	
}
