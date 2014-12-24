package action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import bean.LoginBean;
import bean.RegisterBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.AppointmentViewDAO;
import dao.EventViewDAO;
import dao.ForgotPasswordDAO;
import dao.LoginDAO;

public class LoginCheck extends ActionSupport implements
		ModelDriven<LoginBean>, SessionAware {

	LoginBean lb;
	Map<String, Object> map;

	public LoginBean getLb() {
		return lb;
	}

	public void setLb(LoginBean lb) {
		this.lb = lb;
	}

	public String execute() {
		Map session = ActionContext.getContext().getSession();
		try {
			LoginDAO obj = new LoginDAO();
			LoginBean login = obj.validateLogin(lb.getUsername(),
					lb.getPassword());
			if (login.isValidated()) {
				map.put("name", lb.getUsername());
				EventViewDAO ev = new EventViewDAO();
				AppointmentViewDAO av = new AppointmentViewDAO();
				List appointmentList = av.view(login.getId());
				List eventlist = ev.view(login.getId());
				lb.setEventlist(eventlist);
				lb.setAppointmentlist(appointmentList);
				session.put("user_id", login.getId());
				session.put("eventlist", eventlist);
				session.put("appointmentlist", appointmentList);
				return "user";
			} else {
				return "error";
			}
		} catch (SQLException sqle) {
			return "error";
		}
	}
	
	public String homePageAction() {
		try {
			Map session = ActionContext.getContext().getSession();
			Integer user_id = (Integer) session.get("user_id");
			System.out.println("User Id -> " + user_id);
			if (session == null || user_id == null) {
				return "error";
			}
			EventViewDAO ev = new EventViewDAO();
			AppointmentViewDAO av = new AppointmentViewDAO();
			List eventlist = ev.view(user_id);
			List appointmentlist = av.view(user_id);
			lb.setEventlist(eventlist);
			lb.setAppointmentlist(appointmentlist);
			session.put("user_id", user_id);
			session.put("eventlist", eventlist);
			session.put("appointmenlist", appointmentlist);
			return "success";

		} catch (SQLException sqle) {
			return "error";
		}
	}
	
	
	public String displayCalendarAction() {
		try {
			Map session = ActionContext.getContext().getSession();
			Integer user_id = (Integer) session.get("user_id");
			if (session == null || user_id == null) {
				return "error";
			}
			session.put("user_id", user_id);
			session.put("display_month", lb.getMonth());
			session.put("display_year", lb.getYear());
			EventViewDAO ev = new EventViewDAO();
			AppointmentViewDAO av = new AppointmentViewDAO();
			List eventlist = ev.view(user_id);
			List appointmentlist = av.view(user_id); 
			lb.setEventlist(eventlist);
			lb.setAppointmentlist(appointmentlist);
			session.put("user_id", user_id);
			session.put("eventlist", eventlist);	
			session.put("appointmentlist", appointmentlist);
			return "success";

		} catch (Exception sqle) {
			return "error";
		}
	}

	public LoginBean getModel() {
		if (lb == null)
			lb = new LoginBean();
		return lb;
	}

	public void setSession(Map<String, Object> arg0) {
		this.map = arg0;
	}
}
