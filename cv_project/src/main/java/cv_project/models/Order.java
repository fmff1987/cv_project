package cv_project.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	protected long id;
	protected long idManager;
	protected List<Recruiter> ListR = new ArrayList<Recruiter>();
	protected List<Candidate> ListC = new ArrayList<Candidate>();
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdManager() {
		return idManager;
	}
	public void setIdManager(long idManager) {
		this.idManager = idManager;
	}
	public List<Recruiter> getListR() {
		return ListR;
	}
	public void setListR(List<Recruiter> listR) {
		ListR = listR;
	}
	public List<Candidate> getListC() {
		return ListC;
	}
	public void setListC(List<Candidate> listC) {
		ListC = listC;
	}

	
	
	
	
}
