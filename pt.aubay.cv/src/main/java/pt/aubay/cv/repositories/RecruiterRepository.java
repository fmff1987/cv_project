package pt.aubay.cv.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import pt.aubay.cv.models.Recruiter;

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
