package action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.print.attribute.IntegerSyntax;

import org.apache.struts2.interceptor.SessionAware;

import bean.EventBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.EventAddDAO;
import dao.EventEditDAO;
import dao.EventViewDAO;

public class ViewEventAction extends ActionSupport implements
		ModelDriven<EventBean>, SessionAware {
	
	String status = null;
	EventBean eb;

	public EventBean getEb() {
		return eb;
	}

	public void setEb(EventBean eb) {
		this.eb = eb;
	}


	public String viewEventForEdit() throws SQLException {
		System.out.println("id->" + eb.getEventId());
		EventViewDAO edo = new EventViewDAO();
		EventBean evb = edo.getEventInfo(eb.getEventId());
		Map session = (Map) ActionContext.getContext().getSession();
		session.put("eventBean", evb);
		return "done";
	}
	
	public String simpleViewOfEvents() throws SQLException {
		Map session = (Map) ActionContext.getContext().getSession();
		Integer user_id = (Integer)session.get("user_id");
		System.out.println("user id here is :"+user_id);
		if(session == null || user_id == null){
			return "not done";
		}
		EventViewDAO ev = new EventViewDAO();
		eb.setEventlist(ev.view(user_id));
		return "done";
	}
	

	public String deleteEvent() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Integer user_id = (Integer)session.get("user_id");
		if(session == null || user_id == null){
			return "not done";
		}
		EventEditDAO ead = new EventEditDAO();

		status = ead.deleteEvent(eb.getEventId());
		
		EventViewDAO evd = new EventViewDAO();
		
		List eventlist = evd.view(user_id);
		session.put("user_id", user_id);
		session.put("eventlist", eventlist);

		if (status.equals("success")) {
			return "done";
		}

		else {
			return "not done";
		}
	}


	public EventBean getModel() {
		if (eb == null)
			eb = new EventBean();
		return eb;

	}

	public void setSession(Map<String, Object> arg0) {

	}

}
