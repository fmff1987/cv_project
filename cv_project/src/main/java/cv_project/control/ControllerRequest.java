package cv_project.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import cv_project.models.Request;
import cv_project.repositories.RequestRepository;

@RequestScoped
public class ControllerRequest {
	
	@Inject
	RequestRepository db;
		
	public void createRequest(Request r) {
		db.createEntity(r);
	}
	
	public void removeRequest(Request r) {
		db.removeEntity(r);
		updateReq();
	}
	
	public void updateReq() {
		db.updateLocalList();
	}

	public List<Request> getReq() {
		return db.getList(Request.class);
	}
	
}
