package cv_project.repositories;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import cv_project.models.Manager;

@ApplicationScoped
public class ManagerRepository extends EntityRepository<Manager> {

	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void loadFromDB() {
		localList = em.createQuery("SELECT e FROM Manager e").getResultList();
	}
	
	@Override
	public void updateLocalList() {
		loadFromDB();
	}
	
}
