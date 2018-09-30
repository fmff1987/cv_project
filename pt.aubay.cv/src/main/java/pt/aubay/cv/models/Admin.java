package pt.aubay.cv.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="adm")
@NamedQueries({
		@NamedQuery(name="Admin.getAll",
		query= "SELECT a FROM Admin a"),
		@NamedQuery(name="Admin.getAllActive",
		query = "SELECT a FROM Admin a WHERE a.active = true"),
		@NamedQuery(name= "Admin.getAllActiveEmail",
		query= "SELECT a.email FROM Admin a WHERE a.active = true")
	})

public class Admin extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	
}
