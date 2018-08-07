package personsAndAcademies.authentication;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import pt.aubay.cv.beans.Adminbean;
import pt.aubay.cv.models.Admin;


@Named
@RequestScoped
public class Register  {

    private Admin user = new Admin();

    @Inject
    private Adminbean service;


    public void submit() {
        try {
            service.createAdmin();            
        }
        catch (RuntimeException e) {
            Messages.addGlobalError("Registration failed: {0}", e.getMessage());
            e.printStackTrace(); // TODO: logger.
        }
    }

    public Admin getUser() {
        return user;
    }
}

