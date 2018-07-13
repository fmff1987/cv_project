/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv_project.models;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    protected Long id; 

    public Long getId() {
            return id;
    }

    public void setId(Long id) {
            this.id = id;
    }
    
    @Override
    public boolean equals(Object other) {
            return (other instanceof Entity) && (id != null) ? id.equals(((Entity) other).id) : (other == this);
    }

    @Override
    public int hashCode() {
            return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
    }

    @Override
    public String toString() {
            return String.format("ExampleEntity[%d]", id);
    }
}
