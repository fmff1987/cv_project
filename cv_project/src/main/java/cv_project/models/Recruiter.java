package cv_project.models;

import java.util.ArrayList;
import java.util.List;

public class Recruiter extends Person {
	
	protected List<Order> ListO = new ArrayList<Order>();

	public List<Order> getListO() {
		return ListO;
	}

	public void setListO(List<Order> listO) {
		ListO = listO;
	}
	
}
