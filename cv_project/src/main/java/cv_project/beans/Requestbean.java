package cv_project.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import cv_project.control.ControllerCandidate;
import cv_project.control.ControllerRequest;
import cv_project.models.Candidate;
import cv_project.models.Request;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Named("ReqBean")
@RequestScoped
public class Requestbean {  

   
    
	
        private Request request = new Request();
	 
	 @Inject
	 private ControllerRequest cr;
	 
            
	
	
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

		public List<Request> getReq(){
			return cr.getReq();
		}

		public void createReq() {
			cr.createRequest(request);
		}
	
		public void removeReq() {
			cr.removeRequest(request);
		}
		
		public void updateReq() {
			cr.updateReq();
		}
}
