package cv_project.beans;

import java.util.List;

<<<<<<< HEAD

=======
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
>>>>>>> Ricardo
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import cv_project.control.ControllerRequest;
import cv_project.models.Request;
import java.io.BufferedInputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

import org.primefaces.event.FileUploadEvent;

@Named("ReqBean")
@RequestScoped
public class Requestbean {  
<<<<<<< HEAD
	
    private Request request = new Request();
    
    private UploadedFile cvOrig;
=======

   
    
	
private Request request = new Request();
private List<Request> requestList;
>>>>>>> Ricardo

    @Inject
    private ControllerRequest cr;

    
<<<<<<< HEAD
    public Request getRequest() {
=======
    public List<Request> getRequestList() {
		return requestList;
	}
    
    @PostConstruct
    public void loadRequests() {
    	requestList = cr.getReq();
    }
    

	public Request getRequest() {
>>>>>>> Ricardo
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

//    public List<Request> getReq(){
//            return cr.getReq();
//    }

    public void createReq() {
        cr.createRequest(request);
        FacesMessage msg = new FacesMessage("Pedido registrado.");
        FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
    }
    
    public void upload() {
        try {
          File file = new File("/webapp/resources/cv/cv_Orig/", cvOrig.getFileName());

          OutputStream out = new FileOutputStream(file);
          out.write(cvOrig.getContents());
          out.close();

          FacesContext.getCurrentInstance().addMessage(
                     null, new FacesMessage("Upload completo", 
                     "O arquivo " + cvOrig.getFileName() + " foi salvo!"));
        } catch(IOException e) {
          FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }

      }
    
    /*public void handleFileUpload(FileUploadEvent event) throws IOException{
        //Cria um arquivo UploadFile, para receber o arquivo do evento
        UploadedFile cvOrig = event.getFile();
        InputStream in = new BufferedInputStream(cvOrig.getInputstream());
        //copia o arquivo para esta pasta
        File file = new File( "/resources/cvs" + cvOrig.getInputstream());
        //O método file.getAbsolutePath() fornece o caminho do arquivo criado  
        //Pode ser usado para ligar algum objeto do banco ao arquivo enviado
        request.setCvOrigPath(file.getAbsolutePath());
        FileOutputStream fout = new FileOutputStream(file);
            while (in.available() != 0) {
                fout.write(in.read());
            }
            fout.close();

        FacesMessage msg = new FacesMessage("O Ficheiro ", file.getName() + " foi carregado.");
        FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);

    }*/
    

    public void removeReq() {
            cr.removeRequest(request);
    }
//
//    public void updateReq() {
//            cr.updateReq();
//    }
    
    
<<<<<<< HEAD
=======
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
>>>>>>> Ricardo
}
