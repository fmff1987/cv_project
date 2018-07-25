package cv_project.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import cv_project.models.Entity;

@Transactional
public abstract class EntityRepository<T extends Entity> {

	@PersistenceContext(unitName = "database")
	protected EntityManager em;

	//	protected List<T> localList;

	public void createEntity(T ent) {
		em.persist(ent);
		//updateLocalList();
	}
	//
	//	public List<T> listEntity(Class<T> entClass) {
	//		return localList;
	//	}

	public T getEntity(Class<T> entClass, Long id) {
		return em.find(entClass, id);
	}
	//	public List<T> getList(Class<T> entClass) {
	//		return localList;
	//	}

	public void updateEntity(T ent) {
		em.merge(ent);
		//	updateLocalList();
	}

	public void removeEntity(T ent) {
		em.remove(em.merge(ent));
	}

	//public abstract void updateLocalList();

}
