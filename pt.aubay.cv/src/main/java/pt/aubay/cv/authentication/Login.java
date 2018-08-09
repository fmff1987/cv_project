package pt.aubay.cv.authentication;

import javax.faces.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;

import org.omnifaces.util.Faces;
import org.primefaces.PrimeFaces;
import pt.aubay.cv.beans.AdminEmailBean;
import pt.aubay.cv.models.SSLEmail;

@Named("login")
@ViewScoped
public class Login implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String HOME_URL = "index.xhtml";
    public static final String ADM_URL = "adm.xhtml";
    public static final String REC_URL = "recruiter.xhtml";
        
    @Inject
    private SSLEmail email;
    
    @Inject
    AdminEmailBean admMails;

    private String username, password;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void submitAdm(ActionEvent event) throws IOException {
        FacesMessage msg = null;
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));

            PrimeFaces.current().ajax().addCallbackParam("loggedIn", true);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, ":)", "Login efectuado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);

            if (SecurityUtils.getSubject().hasRole("adm")) {
                Faces.redirect(ADM_URL);
            }
        } catch (AuthenticationException e) {

            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", "Credenciais Inválidas");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            PrimeFaces.current().ajax().addCallbackParam("loggedIn", false);

            e.printStackTrace(); // TODO: logger.
        }

    }

    public void submitRec(ActionEvent event) throws IOException {
        FacesMessage msg = null;
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));

            PrimeFaces.current().ajax().addCallbackParam("loggedIn", true);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, ":)", "Login efectuado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);

            if (SecurityUtils.getSubject().hasRole("user")) {
                Faces.redirect(REC_URL);
            }
        } catch (AuthenticationException e) {

            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", "Credenciais Inválidas");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            PrimeFaces.current().ajax().addCallbackParam("loggedIn", false);

            e.printStackTrace(); // TODO: logger.
        }

    }

    public void logout() throws IOException {
        SecurityUtils.getSubject().logout();
        Faces.invalidateSession();
        Faces.redirect("index.xhtml");

    }

    public void recPassword() {
        System.out.println(admMails.getActiveadmEmailListString());
        String bodyMailpassAdmin = "Username = admin \nPalavra passe = adminaubay ";
        String bodyMailpassRecruiter = "Username = recruiter \nPalavra passe = recaubay";
        email.SSl(admMails.getActiveadmEmailListString(), bodyMailpassAdmin + "\n\n" + bodyMailpassRecruiter);
        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Email enviado para " + admMails.getActiveadmEmailListString()));
    }


}
