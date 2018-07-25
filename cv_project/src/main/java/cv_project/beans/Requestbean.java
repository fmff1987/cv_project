package cv_project.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import cv_project.control.ControllerRequest;
import cv_project.models.Request;


@Named("ReqBean")
@RequestScoped
public class Requestbean {  

   
    
	
private Request request = new Request();
private List<Request> requestList;

    @Inject
    private ControllerRequest cr;

    
    public List<Request> getRequestList() {
		return requestList;
	}
    
    @PostConstruct
    public void loadRequests() {
    	requestList = cr.getReq();
    }
    

	public Request getRequest() {
            return request;
    }

    public void setRequest(Request request) {
            this.request = request;
    }

    public ControllerRequest getCr() {
            return cr;
    }

    public void setCr(ControllerRequest cr) {
            this.cr = cr;
    }

//    public List<Request> getReq(){
//            return cr.getReq();
//    }

    public void createReq() {
            cr.createRequest(request);
    }

    public void removeReq() {
            cr.removeRequest(request);
    }
//
//    public void updateReq() {
//            cr.updateReq();
//    }
    
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Pedido Editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Request request = (Request) event.getObject();
        
        //request.getRecruiter().getRequestList().add(request);
        cr.updateReq(request);
        
    }
 
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
           
        }
    }
}
