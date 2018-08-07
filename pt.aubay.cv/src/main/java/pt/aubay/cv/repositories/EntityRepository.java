package pt.aubay.cv.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pt.aubay.cv.models.Entity;

@Transactional
public abstract class EntityRepository<T extends Entity> {

	@PersistenceContext(unitName = "database")
	protected EntityManager em;

	public void createEntity(T ent) {
		em.persist(ent);
	}

	public T getEntity(Class<T> entClass, Long id) {
		return em.find(entClass, id);
	}

	public void updateEntity(T ent) {
		em.merge(ent);
	}

	public void removeEntity(T ent) {
		em.remove(em.merge(ent));
	}
}
