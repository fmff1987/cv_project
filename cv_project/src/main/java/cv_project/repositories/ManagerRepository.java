package cv_project.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import cv_project.models.Manager;

//@ApplicationScoped
@RequestScoped

public class ManagerRepository extends EntityRepository<Manager> {

	
	
	
	
//	protected void loadFromDB() {
//		localList = em.createQuery("SELECT e FROM Manager e").getResultList();
//	}
//	
//	@Override
//	public void updateLocalList() {
//		loadFromDB();
//	}
	
	public List<Manager> getAll(){
		return em.createNamedQuery("Manager.getAll", Manager.class).getResultList();
	}
	
	
}
