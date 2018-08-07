package pt.aubay.cv.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pt.aubay.cv.control.ControllerAdmin;

@RequestScoped
@Named("AdminEmailBean")
public class AdminEmailBean {

	private List<String> activeadmEmailList;

	public List<String> getActiveadmEmailList() {
		return activeadmEmailList;
	}

	public void setActiveadmEmailList(List<String> activeadmEmailList) {
		this.activeadmEmailList = activeadmEmailList;
	}

	@Inject
	private ControllerAdmin ca;

	public ControllerAdmin getCa() {
		return ca;
	}

	public void setCa(ControllerAdmin ca) {
		this.ca = ca;
	}

	@PostConstruct
	public void loadActiveListEmail() {
		activeadmEmailList = ca.getAllActiveEmail();
	}

	public String getActiveadmEmailListString() {
		String lista = "";
		for(String item : activeadmEmailList) {
			 lista += item + ", ";
		}
		return lista;
	}
}
