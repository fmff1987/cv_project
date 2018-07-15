package cv_project.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import cv_project.models.Manager;
import cv_project.repositories.EntityRepository;
import cv_project.repositories.ManagerRepository;

@RequestScoped
public class ControllerManager {
	
	@Inject
	ManagerRepository db;
	
	public List<Manager> getMan() {
		return db.getList(Manager.class);
	}
	
	
	
	public void removeManage(Manager p) {
		db.removeEntity(p);
		db.updateLocalList();
	}
	
	public void createManager(Manager p) {
	
		db.createEntity(p);
	}
}
