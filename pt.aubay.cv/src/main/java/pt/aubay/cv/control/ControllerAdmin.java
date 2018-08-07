package pt.aubay.cv.control;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import pt.aubay.cv.models.Admin;
import pt.aubay.cv.repositories.AdminRepository;

@Transactional
@RequestScoped

public class ControllerAdmin {

	@Inject
	AdminRepository db;

	public void createAdmin(Admin a) {
		db.createEntity(a);
	}

	public List<Admin> getAll() {
		return db.getAll();
	}

	public void updateAdmin(Admin a) {
		db.updateEntity(a);
	}

	public void removeAdmin(Admin a) {
		db.removeEntity(a);
	}

	public List<Admin> getAllActive() {
		return db.getAllActive();
	}

	public List<String> getAllActiveEmail() {
		return db.getAllActiveEmail();
	}
}