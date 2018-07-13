package cv_project.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import cv_project.control.ControllerManager;
import cv_project.models.Manager;

@RequestScoped
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
}
