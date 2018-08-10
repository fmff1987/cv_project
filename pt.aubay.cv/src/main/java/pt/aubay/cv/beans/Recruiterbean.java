package pt.aubay.cv.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import pt.aubay.cv.control.ControllerRecruiter;
import pt.aubay.cv.models.Recruiter;

@Named("RecBean")
@RequestScoped
public class Recruiterbean {

	private Recruiter recruiter = new Recruiter();
	private List<Recruiter> recruiterList;
	private List<Recruiter> activeRecruiterList;

	public List<Recruiter> getRecruiterList() {
		return recruiterList;
	}
	public List<Recruiter> getActiveRecruiterList() {
		return activeRecruiterList;
	}
	@Inject
	private ControllerRecruiter cr;

	@PostConstruct
	private void loadRecruiters() {
		recruiterList = cr.getRec();
		activeRecruiterList = cr.getRecruiterActive();
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public ControllerRecruiter getCr() {
		return cr;
	}

	public void setCr(ControllerRecruiter cr) {
		this.cr = cr;
	}

	public void createRec() {
		recruiter.setActive(true);
		cr.createRec(recruiter);
		loadRecruiters();

	}

	public void removeRec() {
		cr.removeRec(recruiter);
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Recrutador Editado", ((Recruiter) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		Recruiter recruta = (Recruiter) event.getObject();
		cr.updateRec(recruta);

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edição Cancelada", ((Recruiter) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
