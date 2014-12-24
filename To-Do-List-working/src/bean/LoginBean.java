package bean;

import java.util.List;


public class LoginBean {

	private String username;
	private String password;
	private String role;
	private boolean validated;
	private int id;
	private String month;
	private String year;
	private List<EventBean> eventlist;
	private List<AppointmentBean> appointmentlist;
	private String secret_question;
	
	public String getSecret_question() {
		return secret_question;
	}

	public void setSecret_question(String secret_question) {
		this.secret_question = secret_question;
	}

	public List<AppointmentBean> getAppointmentlist() {
		return appointmentlist;
	}

	public void setAppointmentlist(List<AppointmentBean> appointmentlist) {
		this.appointmentlist = appointmentlist;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<EventBean> getEventlist() {
		return eventlist;
	}

	public void setEventlist(List<EventBean> eventlist) {
		this.eventlist = eventlist;
	}
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
