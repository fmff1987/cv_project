/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import pt.aubay.cv.models.SSLEmail;
import pt.aubay.cv.models.Status;

@Named("CreateRequestManager")
@RequestScoped
public class ManagerCreateRequestBean {

    private Request request = new Request();
    private UploadedFile cvOrig;
    private List<Request> requestListAprovado;

    @Inject
    private AdminEmailBean admEmail;

    @Inject
    private SSLEmail email;

    @Inject
    ControllerRequest cr;

    @PostConstruct
    public void loadRequests() {
        requestListAprovado = cr.getReqAllAprovado();
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

    public List<Request> getRequestListAprovado() {
        return requestListAprovado;
    }

    public void setRequestListAprovado(List<Request> requestListAprovado) {
        this.requestListAprovado = requestListAprovado;
    }

    public AdminEmailBean getAdmEmail() {
        return admEmail;
    }

    public void setAdmEmail(AdminEmailBean admEmail) {
        this.admEmail = admEmail;
    }

    public SSLEmail getEmail() {
        return email;
    }

    public void setEmail(SSLEmail email) {
        this.email = email;
    }

    public ControllerRequest getCr() {
        return cr;
    }

    public void setCr(ControllerRequest cr) {
        this.cr = cr;
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
        if (admEmail.getActiveadmEmailListString().contains("@")) {
            String bodyMail = "O manager " + request.getManager().getName() + " criou um novo pedido com o candidato " + request.getCandidateName();
            this.sendMail(admEmail.getActiveadmEmailListString(), bodyMail);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Informação", "Email foi enviado para " + admEmail.getActiveadmEmailListString()));
        }
    }

    public void sendMail(String mail, String body) {
        email.SSl(mail, body);
    }

    public void createReq() {
        request.setEstado(Status.INICIADO);
        cr.createRequest(request);

        FacesMessage msg = new FacesMessage("Pedido registrado.");
        FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
    }
}
