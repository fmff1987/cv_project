package cv_project.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import cv_project.models.Recruiter;

//@ApplicationScoped
@RequestScoped
public class RecruiterRepository extends EntityRepository<Recruiter> {
	

//	protected void loadFromDB() {
//		localList = em.createQuery("SELECT e FROM Recruiter e").getResultList();
//	}
//	
//	@Override
//	public void updateLocalList() {
//		loadFromDB();
//	}
//	
	public List<Recruiter> getAll(){
		return em.createNamedQuery("Recruiter.getAll", Recruiter.class).getResultList();
	}
}
