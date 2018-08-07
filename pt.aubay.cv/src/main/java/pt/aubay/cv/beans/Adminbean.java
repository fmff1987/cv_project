package pt.aubay.cv.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import pt.aubay.cv.control.ControllerAdmin;
import pt.aubay.cv.models.Admin;

@RequestScoped
@Named("AdmBean")
public class Adminbean {

	private Admin adm = new Admin();

	private List<Admin> admList;

	private List<Admin> activeAdmList;

	private List<String> activeadmEmailList;

	public List<String> getActiveadmEmailList() {
		return activeadmEmailList;
	}

	public void setActiveadmEmailList(List<String> activeadmEmailList) {
		this.activeadmEmailList = activeadmEmailList;
	}

	@Inject
	private ControllerAdmin ca;

	public Admin getAdm() {
		return adm;
	}

	public void setAdm(Admin adm) {
		this.adm = adm;
	}

	public List<Admin> getAdmList() {
		return admList;
	}

	public List<Admin> getActiveAdmList() {
		return activeAdmList;
	}

	@PostConstruct
	public void loadAdmin() {
		admList = ca.getAll();
		activeAdmList = ca.getAllActive();
	}

	public void createAdmin() {
		adm.setActive(true);
		ca.createAdmin(adm);
		admList = ca.getAll();
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Admin Editado", ((Admin) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		Admin adm = (Admin) event.getObject();
		ca.updateAdmin(adm);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edição Cancelada", ((Admin) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}