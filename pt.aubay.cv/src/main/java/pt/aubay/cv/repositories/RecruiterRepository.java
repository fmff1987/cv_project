package pt.aubay.cv.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import pt.aubay.cv.models.Recruiter;


@RequestScoped
public class RecruiterRepository extends EntityRepository<Recruiter> {

	public List<Recruiter> getAll(){
		return em.createNamedQuery("Recruiter.getAll", Recruiter.class).getResultList();
	}
	
	public List<Recruiter> getRecruiterActive(){
		TypedQuery<Recruiter> query = em.createNamedQuery("Recruiter.getRecruiterActive", Recruiter.class);
		return query.getResultList();
	}
}
