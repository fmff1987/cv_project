package pt.aubay.cv.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import pt.aubay.cv.models.Admin;

@RequestScoped
public class AdminRepository extends EntityRepository<Admin>{

	
	public List<Admin> getAll(){
		return em.createNamedQuery("Admin.getAll", Admin.class).getResultList();
	}
	public List<Admin>getAllActive(){
		return em.createNamedQuery("Admin.getAllActive", Admin.class).getResultList();
	}
	public List<String> getAllActiveEmail(){
		return (List<String>) em.createNamedQuery("Admin.getAllActiveEmail", String.class).getResultList();
	}
	
}
