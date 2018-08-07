package pt.aubay.cv.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import pt.aubay.cv.models.Manager;


@RequestScoped
public class ManagerRepository extends EntityRepository<Manager> {

	public List<Manager> getAll(){
		return em.createNamedQuery("Manager.getAll", Manager.class).getResultList();
	}

	public List<Manager> getManagerActive(){
		return em.createNamedQuery("Manager.managerActive", Manager.class).getResultList();
	}

}
