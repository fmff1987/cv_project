package cv_project.beans;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import cv_project.control.ControllerManager;
import cv_project.models.Manager;

@RequestScoped
@Named("ManBean")
public class Managerbean {
	
	//////////////////////////////ATRIBUTS
	private Manager manager = new Manager();

	@Inject
	private ControllerManager cm;
	
	//////////////////////////////GETTER & SETTER
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public ControllerManager getCm() {
		return cm;
	}

	public void setCm(ControllerManager cm) {
		this.cm = cm;
	}
	
	public List<Manager> getMan(){
		return cm.getMan();
	
	}
	public void createMan() {
		cm.createManager(manager);
	}
	
	public void removeMan() {
		cm.removeManage(manager);
	}
	
	public void updateMan() {
		cm.updateMan();
	}
	
}
