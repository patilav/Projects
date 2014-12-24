package action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;


import bean.AppointmentBean;
import bean.EventBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.AppointmentAddDAO;
import dao.AppointmentDeleteDAO;
import dao.AppointmentEditDAO;
import dao.AppointmentViewDAO;
import dao.EventEditDAO;
import dao.EventViewDAO;



public class AppointmentAction extends ActionSupport implements
		ModelDriven<AppointmentBean>, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String status = null;
	AppointmentBean ab;

	public AppointmentBean getAb() {
		return ab;
	}

	public void setAb(AppointmentBean ab) {
		this.ab = ab;
	}

	public String execute() throws Exception {
		
		try {
			Map session = ActionContext.getContext().getSession();
			Integer userId = (Integer)session.get("user_id");
			AppointmentAddDAO aad = new AppointmentAddDAO();
			System.out.println("id->" + String.valueOf(userId));
			System.out.println("name->" + ab.getName());
			System.out.println("dateOfAppointment->" + ab.getDateOfAppointment());
			System.out.println("purpose->" + ab.getPurpose());
			System.out.println("location->" + ab.getLocation());
			System.out.println("duration->" + ab.getDuration());
			System.out.println("priority->" + ab.getPriority());
			status = aad.addAppointment(userId, ab);

			status = "success";
			if (status.equals("success")) {
				return "done";
			}

			else {
				return "not done";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public String appointmentEditAction() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Integer user_id = (Integer)session.get("user_id");
		if(session == null || user_id == null){
			return "not done";
		}
		AppointmentEditDAO ead = new AppointmentEditDAO();
		
		status = ead.editAppointment(ab.getAppointmentId(), ab.getName(), ab.getDateOfAppointment(), ab.getLocation(), ab.getPurpose(), ab.getDuration(), ab.getPriority());
		
		AppointmentViewDAO evd = new AppointmentViewDAO();
		
		List appointmentlist = evd.view(user_id);
		session.put("user_id", user_id);
		session.put("appointmentlist", appointmentlist);

		if (status.equals("success")) {
			return "done";
		}

		else {
			return "not done";
		}
	}

	
	
	
	public String simpleView() throws SQLException {
		Map session = (Map) ActionContext.getContext().getSession();
		Integer user_id = (Integer)session.get("user_id");
		System.out.println("user id here is :"+user_id);
		if(session == null || user_id == null){
			return "not done";
		}
		System.out.println("id->" + ab.getAppointmentId());
		AppointmentViewDAO ado = new AppointmentViewDAO();
		//AppointmentBean avb = ado.getAppointmentInfo(ab.getAppointmentId());
		ab.setAppointmentlist(ado.getAppointmentInfo(user_id));
		//session.put("appointmentBean", avb);
		return "done";
	}
	
	public String viewAppointmentForEdit() throws SQLException {
		System.out.println("id->" + ab.getAppointmentId());
		AppointmentViewDAO edo = new AppointmentViewDAO();
		AppointmentBean avb = edo.getAppointmentForEdit(ab.getAppointmentId());
		Map session = (Map) ActionContext.getContext().getSession();
		System.out.println(avb);
		session.put("appointmentBean", avb);
		return "done";
	}
	
	
	public String deleteAppointment() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Integer user_id = (Integer)session.get("user_id");
		if(session == null || user_id == null){
			return "not done";
		}
		AppointmentDeleteDAO ead = new AppointmentDeleteDAO();

		status = ead.deleteAppointment(ab.getAppointmentId());
		
		EventViewDAO evd = new EventViewDAO();
		
		List appointmentlist = evd.view(user_id);
		session.put("user_id", user_id);
		session.put("appointmentlist", appointmentlist);

		if (status.equals("success")) {
			return "done";
		}

		else {
			return "not done";
		}
	}
	
	public AppointmentBean getModel() {
		if (ab == null)
			ab = new AppointmentBean();
		return ab;

	}

	public void setSession(Map<String, Object> arg0) {

	}

}
