package cv_project.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.PreRemove;
import javax.transaction.Transactional;

import cv_project.models.Request;
import cv_project.repositories.RequestRepository;

@Transactional
@RequestScoped
public class ControllerRequest {
	
	@Inject
	RequestRepository db; 
		
	public void createRequest(Request r) {
		db.createEntity(r);
	}

	public void removeRequest(Request r) {
	
		db.removeEntity(r);
		db.updateEntity(r);
//		updateReq();
	}
	
	public void updateReq(Request r) {
		db.updateEntity(r);
	}

	public List<Request> getReq() {
		return db.getAllWithRecruiterAndManager();
	}
	
}
