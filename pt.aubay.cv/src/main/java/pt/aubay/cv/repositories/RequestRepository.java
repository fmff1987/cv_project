package pt.aubay.cv.repositories;


import java.util.List;

import javax.enterprise.context.RequestScoped;

import pt.aubay.cv.models.Request;

@RequestScoped
public class RequestRepository  extends EntityRepository<Request>{

	public List<Request> getAllWithManagers(){
		return em.createNamedQuery("Request.getAllWithManagers", Request.class).getResultList();
	}
	public List<Request> getAll(){
		return em.createNamedQuery("Request.getAll", Request.class).getResultList();
	}
	public List<Request> getAllWithRecruiterAndManagers(){
		return em.createNamedQuery("Request.getAllWithRecruiterAndManagers",Request.class).getResultList();
	public List<Request> getAllWithRecruiterAndManager(){
		return em.createNamedQuery("Request.getAllWithRecruiterAndManager",Request.class).getResultList();
	public List<Request> getAllWithRecruiterAndManagers(){
		return em.createNamedQuery("Request.getAllWithRecruiterAndManagers",Request.class).getResultList();
	}
	
}
	