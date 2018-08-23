package pt.aubay.cv.authentication;


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
import pt.aubay.cv.beans.SSLEmail;



@Named
@ViewScoped
public class Login implements Serializable{
 @Inject
 AdminEmailBean admMails;
 @Inject 
 SSLEmail mailService;
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String HOME_URL = "index.xhtml";

    private String username, password;
    


    public void submitAdm() throws IOException {
 
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
                       
         
          if(SecurityUtils.getSubject().hasRole("admin") ) {
        	  PrimeFaces.current().ajax().addCallbackParam("loggedIn", true);
        	  FacesContext.getCurrentInstance().addMessage(
  					null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Login bem sussedido"));
          	 Faces.redirect("adm.xhtml");
            } else
          if(SecurityUtils.getSubject().hasRole("user")) {
            	FacesContext.getCurrentInstance().addMessage(
    					null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", "Credenciais Invalidas"));
            	System.out.println("Erro");
            }
          
        }
        catch (AuthenticationException e) {
           
            e.printStackTrace(); // TODO: logger.
            FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", "Credenciais Invalidas"));
        }
		
    }
    
    public void submitRecruiter() throws IOException {
    	
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
            System.out.println(SecurityUtils.getSubject());
            //SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
            
           //Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : "adm.xhtml");
           // System.out.println(savedRequest );
           //System.out.println(this.getUsername());	
          
           if(SecurityUtils.getSubject().hasRole("user")){
        	   FacesContext.getCurrentInstance().addMessage(
     					null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Login bem sussedido"));
        	   PrimeFaces.current().ajax().addCallbackParam("loggedIn", true);
            	Faces.redirect("recruiter.xhtml");
            	} else if(SecurityUtils.getSubject().hasRole("admin")) {
            		FacesContext.getCurrentInstance().addMessage(
        					null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", "Credenciais Invalidas"));
            	}
          
        }
        catch (AuthenticationException e) {
           
            e.printStackTrace(); // TODO: logger.
            FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", "Credenciais Invalidas"));
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
    	mailService.SSl(admMails.getActiveadmEmailListString(), bodyMailpassAdmin +"\n\n" +bodyMailpassRecruiter);
    	FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Email enviado para "+ admMails.getActiveadmEmailListString()));
    }


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
	
	
	
}