package managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service.StatusService;
import util.Status;

@ManagedBean
@ViewScoped
@Component
public class StatusMb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<Status> statusList;
	@Autowired private StatusService stService;
	private String deskripsi;
	
	public Collection<Status> getStatusList() {
		try {
			this.statusList = this.stService.getStatus(deskripsi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.statusList;
	}
	public void setStatusList(Collection<Status> statusList) {
		this.statusList = statusList;
	}
	
}
