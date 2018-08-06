package pt.aubay.cv.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pt.aubay.cv.models.Admin;

@RequestScoped
@Named("AdmBean")
public class Adminbean {

	private Admin adm = new Admin();
	private List<Admin> admList;
	
	
	
	
	
	
	
}
