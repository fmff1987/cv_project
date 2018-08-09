package pt.aubay.cv.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import pt.aubay.cv.control.ControllerRequest;
import pt.aubay.cv.models.Request;
import pt.aubay.cv.models.Status;


@RequestScoped
@Named("ReqCreateBean")
public class RequestCreateBean {
	
	private Request request = new Request();
	private UploadedFile cvOrig;
	
        @Inject
	ControllerRequest cr;
	
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
	
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
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

	public void createReq() {
		request.setEstado(Status.INICIADO);
		cr.createRequest(request);
		FacesMessage msg = new FacesMessage("Pedido registrado.");
		FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
	}
	
}
