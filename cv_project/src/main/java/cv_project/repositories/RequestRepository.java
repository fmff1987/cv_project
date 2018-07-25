package cv_project.repositories;


import java.util.List;

import javax.enterprise.context.RequestScoped;

import cv_project.models.Request;

@RequestScoped
public class RequestRepository  extends EntityRepository<Request>{

	public List<Request> getAllWithManagers(){
		return em.createNamedQuery("Request.getAllWithManagers", Request.class).getResultList();
	}
	public List<Request> getAll(){
		return em.createNamedQuery("Request.getAll", Request.class).getResultList();
	}
	public List<Request> getAllWithRecruiterAndManager(){
		return em.createNamedQuery("Request.getAllWithRecruiterAndManager",Request.class).getResultList();
	}
	
}
	