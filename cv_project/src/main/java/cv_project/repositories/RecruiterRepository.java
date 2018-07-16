package cv_project.repositories;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import cv_project.models.Recruiter;

@ApplicationScoped
public class RecruiterRepository extends EntityRepository<Recruiter> {
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void loadFromDB() {
		localList = em.createQuery("SELECT e FROM Recruiter e").getResultList();
	}
	
	@Override
	public void updateLocalList() {
		loadFromDB();
	}
}
