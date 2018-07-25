package cv_project.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import cv_project.models.Manager;
import cv_project.repositories.ManagerRepository;

@Transactional
@RequestScoped
public class ControllerManager {

	@Inject
	ManagerRepository db;

	public void createManager(Manager p) {
		db.createEntity(p);
		
	}

	public List<Manager> getMan() {
		return db.getAll();
	}

	public void updateMan(Manager p) {
		db.updateEntity(p);
	}

	public void removeManage(Manager p) {
		db.removeEntity(p);
		
		//db.updateLocalList();
	}

	
}
