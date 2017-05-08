package managed.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;

import service.StatusService;
import util.Status;

@ManagedBean
@ViewScoped
public class StatusMb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Status> statusList;
	private StatusService stService;
	private String deskripsi;
	
	public List<Status> getStatusList() {
		try {
			this.statusList = this.stService.getStatus(deskripsi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.statusList;
	}
	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}
	
}
