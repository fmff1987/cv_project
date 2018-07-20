package cv_project.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import cv_project.models.Candidate;
import cv_project.repositories.CandidateRepository;

@RequestScoped
public class ControllerCandidate {
	
	@Inject
	CandidateRepository db;
	
	public List<Candidate> getCan() {
		return db.getList(Candidate.class);
	}
	
	public void removeCandidate(Candidate c) {
		db.removeEntity(c);
		db.updateLocalList();
	}
	
	public void createCandidate(Candidate c) {
		db.createEntity(c);
	}
	
	public void updateCan() {
	db.updateLocalList();
	}
}
