package pt.aubay.cv.beans;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import pt.aubay.cv.control.ControllerRequest;
import pt.aubay.cv.models.Request;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

//import javax.enterprise.context.RequestScoped;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.io.Serializable;
import javax.faces.view.ViewScoped;



@Named("ReqBean")
@ViewScoped
public class Requestbean implements Serializable {  

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Request request = new Request();
    
    private UploadedFile cvOrig;

    private List<Request> requestList;

    @Inject
    private ControllerRequest cr;

    public List<Request> getRequestList() {
        return requestList;
    }

    @PostConstruct
    public void loadRequests() {
    	requestList = cr.getReq();
        System.out.println(requestList.size());
    }
    

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
            this.request = request;
    }

    public UploadedFile getCvOrig() {
        return cvOrig;
    }

    public void setCvOrig(UploadedFile cvOrig) {
        this.cvOrig = cvOrig;
    }
    
    public ControllerRequest getCr() {
            return cr;
    }

    public void setCr(ControllerRequest cr) {
            this.cr = cr;
    }

    public void createReq() {
        cr.createRequest(request);
        FacesMessage msg = new FacesMessage("Pedido registrado.");
        FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
    }
    

    public void removeReq() {
            cr.removeRequest(request);
    }    
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Pedido Editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Request request = (Request) event.getObject();
        
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
    
    public void upload() {
        try {
            File rootDir = new File(".");
            File applDir = new File(rootDir, "uploadedCVs");
            applDir.mkdirs();
            
            File file = new File(applDir, cvOrig.getFileName());
            
            OutputStream out = new FileOutputStream(file);
            out.write(cvOrig.getContents());
            out.close();
            
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Upload completo",
                            "O arquivo " + cvOrig.getFileName() + " foi salvo em " + file.getAbsolutePath()));
            request.setCvOrigPath(file.getAbsolutePath());
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }
}    

