package pt.aubay.cv.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

import pt.aubay.cv.control.ControllerRequest;
import pt.aubay.cv.models.Request;
import pt.aubay.cv.models.Status;



@Named("ReqBean")
@ViewScoped
public class Requestbean implements Serializable {  

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Request request = new Request();
    
    private UploadedFile cvOrig;
    private UploadedFile cvAubay;

    private List<Request> requestList;
    private List<Request> requestListAll;
    private List<Request> requestListAprovado;
    private List<Request> requestListNotAprovado;
    


	@Inject
    private ControllerRequest cr;

    public UploadedFile getCvAubay() {
        return cvAubay;
    }

    public void setCvAubay(UploadedFile cvAubay) {
        this.cvAubay = cvAubay;
    }
    
    public List<Request> getRequestList() {
        return requestList;
    }
    
    public List<Request> getRequestListAll(){
    	return requestListAll;
    }

    public List<Request> getRequestListAprovado() {
		return requestListAprovado;
	}

	public void setRequestListAprovado(List<Request> requestListAprovado) {
		this.requestListAprovado = requestListAprovado;
	}
	 public List<Request> getRequestListNotAprovado() {
			return requestListNotAprovado;
		}

		public void setRequestListNotAprovado(List<Request> requestListNotAprovado) {
			this.requestListNotAprovado = requestListNotAprovado;
		}


    @PostConstruct
    public void loadRequests() {
    	requestList = cr.getReq();
    	requestListAll = cr.getReqAll();
    	requestListAprovado = cr.getReqAllAprovado();
    	requestListNotAprovado = cr.getAllNotAprovado();
    	
       // System.out.println(requestList.size());
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
    	request.setEstado(Status.INICIADO);
        cr.createRequest(request);
        
        FacesMessage msg = new FacesMessage("Pedido registrado.");
        FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
    }
    

    public void removeReq(Request request) {
            cr.removeRequest(request);
    }    
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Pedido Editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Request request = (Request) event.getObject();
        cr.updateReq(request);
        loadRequests();
    }
    
    public void onRowEditOngoingList(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Pedido Editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Request request = (Request) event.getObject();
        if(request.getEstado()==null) {
        	request.setEstado(Status.INICIADO);
        }
        cr.updateReq(request);
    
    	requestListNotAprovado = cr.getAllNotAprovado();
        requestListAprovado = cr.getReqAllAprovado();
        
    }
 
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void uploadOrig() {
        try { 
            String dir = System.getProperty("jboss.server.base.dir") + "/deployments/uploadedCVs/cvOrig/";
            File folder = new File(dir);
            folder.mkdirs();
            
            File file = new File(dir, cvOrig.getFileName());
            
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
        createReq();
    }
    
     public void uploadAubay() {
        try { 
            String dir = System.getProperty("jboss.server.base.dir") + "/deployments/uploadedCVs/cvAubay/";
            File folder = new File(dir);
            folder.mkdirs();
            
            File file = new File(dir, cvAubay.getFileName());
            
            OutputStream out = new FileOutputStream(file);
            out.write(cvAubay.getContents());
            out.close();
            
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Upload completo",
                            "O arquivo " + cvAubay.getFileName() + " foi salvo em " + file.getAbsolutePath()));
            request.setCvAubayPath(file.getAbsolutePath());
            
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }
}    

