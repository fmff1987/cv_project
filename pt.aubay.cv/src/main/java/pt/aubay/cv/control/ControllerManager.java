package pt.aubay.cv.control;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import pt.aubay.cv.models.Manager;
import pt.aubay.cv.repositories.ManagerRepository;

@Transactional
@RequestScoped
public class ControllerManager {

	@Inject
	ManagerRepository db;

	public void createManager(Manager p) {
		db.createEntity(p);
		db.updateEntity(p);
	}

	public List<Manager> getMan() {
		return db.getAll();
	}
	
	public List<Manager> getManagerActive() {
		return db.getManagerActive();
	}

	public void updateMan(Manager p) {
		db.updateEntity(p);
	}

	public void removeManage(Manager p) {
		db.removeEntity(p);
	}
}