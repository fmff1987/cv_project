package pt.aubay.cv.control;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import pt.aubay.cv.models.Recruiter;
import pt.aubay.cv.repositories.RecruiterRepository;

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
	}

	public void removeRec(Recruiter p) {
		db.removeEntity(p);
	}	
	public void updateRec(Recruiter r) {
		db.updateEntity(r);
	}

	public List<Recruiter> getRecruiterActive() {
		return db.getRecruiterActive();
	}
}
