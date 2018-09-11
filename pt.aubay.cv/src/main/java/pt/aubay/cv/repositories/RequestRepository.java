package pt.aubay.cv.repositories;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import pt.aubay.cv.models.Request;
import pt.aubay.cv.models.Status;

@RequestScoped
public class RequestRepository extends EntityRepository<Request>{

	public List<Request> getAllWithManagers(){
		return em.createNamedQuery("Request.getAllWithManagers", Request.class).getResultList();
	}
	public List<Request> getAll(){
		return em.createNamedQuery("Request.getAll", Request.class).getResultList();
	}
	public List<Request> getAllWithRecruiterAndManagers(){
		return em.createNamedQuery("Request.getAllWithRecruiterAndManagers", Request.class).getResultList();
	}
	public List<Request> getAllAprovado(){
		TypedQuery<Request> query = em.createNamedQuery("Request.getAllAprovado", Request.class );
		query.setParameter("estado", Status.APROVADO);
		return query.getResultList();
	}
	public List<Request> getAllNotAprovado(){
		TypedQuery<Request> query = em.createNamedQuery("Request.getAllNotAprovado", Request.class).setParameter("estado", Status.APROVADO);

		return query.getResultList();
	}

}
