package pt.aubay.cv.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.primefaces.model.UploadedFile;

import pt.aubay.cv.control.ControllerRequest;
import pt.aubay.cv.models.Request;
import pt.aubay.cv.models.Status;

@Named("CreateRequestManager")
@RequestScoped

public class ManagerCreateRequestBean {
	private Request request = new Request();
	private List<Request> requestListAprovado;
	
	
	public List<Request> getRequestListAprovado() {
		return requestListAprovado;
	}
	
	@Inject
	ControllerRequest cr;
	


	public ControllerRequest getCr() {
		return cr;
	}


	public void setCr(ControllerRequest cr) {
		this.cr = cr;
	}

	
	
	public Request getRequest() {
		return request;
	}


	public void setRequest(Request request) {
		this.request = request;
	}
	@PostConstruct
	public void loadRequests() {
	
		requestListAprovado = cr.getReqAllAprovado();
	}
	
	public void uploadOrig() {

    	UploadedFile file = request.getCvOrig();
    	String fileName = file.getFileName();
		try {
	
			String dir = System.getProperty("jboss.server.base.dir") + "/deployments/uploadedCVs/cvOrig/";
			File folder = new File(dir);
			folder.mkdirs();

			File physicalFile = new File(dir, fileName);

			OutputStream out = new FileOutputStream(physicalFile);
			out.write(file.getContents());
			out.close();

			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage("Upload completo",
							"O arquivo " + fileName + " foi salvo em " + physicalFile.getAbsolutePath()));
			request.setCvOrigPath(physicalFile.getAbsolutePath());

		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
		}
		createReq();
	}

	public void createReq() {
		request.setEstado(Status.INICIADO);
		cr.createRequest(request);

		FacesMessage msg = new FacesMessage("Pedido registrado.");
		FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
	}
	
    public void download(String filePath) throws IOException{
    	try {
    		File file = new File(filePath);
            Faces.sendFile(file, true);
    	}
    	catch (IOException e ){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Erro", "Nenhum ficheiro encontrado" ));
    	}
      
    }
}
