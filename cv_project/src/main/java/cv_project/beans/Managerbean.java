package cv_project.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import cv_project.control.ControllerManager;

import cv_project.models.Manager;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

@RequestScoped
@Named("ManBean")
public class Managerbean {
	
	
	private Manager manager = new Manager();

	@Inject
	private ControllerManager cm;
	
	
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
        
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Manager Editado", ((Manager) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada", ((Manager) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
}
