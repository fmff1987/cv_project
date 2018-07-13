package cv_project.models;

public class Candidate extends Person {
	
	protected long idOrder;
	protected String cv;
	
	public long getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	
}
