package cv_project.repositories;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import cv_project.models.Request;

@ApplicationScoped
public class RequestRepository  extends EntityRepository<Request>{
	
    @SuppressWarnings("unchecked")
    @PostConstruct
    protected void loadFromDB(){
        localList = em.createQuery("SELECT e FROM Request e").getResultList();
    }
    
    @Override
    public void updateLocalList() {
            loadFromDB();
    }
}
