package pt.aubay.cv.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.PreRemove;
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
		db.updateEntity(r);
//		updateReq();
	}
	
	public void updateReq(Request r) {
		db.updateEntity(r);
	}

	public List<Request> getReq() {
<<<<<<< HEAD:cv_project/src/main/java/cv_project/control/ControllerRequest.java
		return db.getAllWithRecruiterAndManager();
=======
		return db.getAllWithRecruiterAndManagers();
>>>>>>> Fernando:pt.aubay.cv/src/main/java/pt/aubay/cv/control/ControllerRequest.java
	}
	
}
