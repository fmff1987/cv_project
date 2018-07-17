package cv_project.repositories;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import cv_project.models.Candidate;


@ApplicationScoped
public class CandidateRepository extends EntityRepository<Candidate> {
		
	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void loadFromDB() {
		localList = em.createQuery("SELECT e FROM Product e").getResultList();
	}
		
	@Override
	public void updateLocalList() {
		loadFromDB();
	}
}
