package control;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import cv_project.models.Recruiter;
import cv_project.repositories.EntityRepository;

@RequestScoped
public class ControllerRecruiter {
	
	@Inject
	EntityRepository <Recruiter> db;
	
	
	
	
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
	
}
