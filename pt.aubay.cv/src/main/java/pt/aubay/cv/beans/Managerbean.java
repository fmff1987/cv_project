package pt.aubay.cv.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import pt.aubay.cv.control.ControllerManager;
import pt.aubay.cv.models.Manager;

@RequestScoped
@Named("ManBean")
public class Managerbean {
	
	
	private Manager manager = new Manager();
	private List<Manager> managerList;
	private List<Manager> activeManagerList;
	
	public List<Manager> getManagerList() {
		return managerList;
	}

	@Inject
	private ControllerManager cm;
	
	
	public List<Manager> getActiveManagerList() {
		return activeManagerList;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	@PostConstruct
	public void loadManagers() {
		activeManagerList = cm.getManagerActive();
		managerList = cm.getMan();
	}
	// Nao se deve usar um getter para ir diretamente á base de dados.
	//em vez disso deve.se usar uma lista local para ir buscar á base de dados, assim só la vai uma vez
	// @PostConstruct garante que semre que se estanciar ManagerBean o metodo é corrido
	
	
//	public List<Manager> getMan(){
//		return cm.getMan();
//		}
	
	public void createMan() {
		manager.setActive(true);
		cm.createManager(manager);
		loadManagers();
	}
	
	public void removeMan() {
		cm.removeManage(manager);
		loadManagers();
	}
//	public void removeMan() {
//		cm.removeManage(manager);
//	}
	
//	public void updateMan() {
//		cm.updateMan();
//	}
        
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Manager Editado", ((Manager) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Manager manager = (Manager) event.getObject();
        cm.updateMan(manager);
    }
 
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada", ((Manager) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
}
