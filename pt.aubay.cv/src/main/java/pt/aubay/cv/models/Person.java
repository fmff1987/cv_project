package pt.aubay.cv.models;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person extends Entity{
	
	private static final long serialVersionUID = 1L;
	
	protected String name;
    protected String email;
    protected boolean active;

    public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getName() {
            return name;
    }
    public void setName(String name) {
            this.name = name;
    }
    public String getEmail() {
            return email;
    }
    public void setEmail(String email) {
            this.email = email;
    }
}
