package pt.aubay.cv.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import pt.aubay.cv.models.Request;
import pt.aubay.cv.repositories.RequestRepository;

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
//		updateReq();
	}
	
	public void updateReq(Request r) {
		db.updateEntity(r);
	}

	public List<Request> getReq() {

		return db.getAllWithRecruiterAndManagers();

	}
	
	public List<Request> getReqAll(){
		return db.getAll();
	}

	public List<Request> getReqAllAprovado() {
		return db.getAllAprovado();
	}

	public List<Request> getAllNotAprovado() {
		return db.getAllNotAprovado();
	}
	
}
