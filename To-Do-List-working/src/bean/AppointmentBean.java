package bean;


import java.util.List;

public class AppointmentBean {

	private int appointmentId;
	private String name;
    private String dateOfAppointment;
    private String purpose;
    private String location;
    private int duration;
    public enum Priority {low, medium, high};
    private String priority;
    
    private List<AppointmentBean> appointmentlist;

    
    public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(String dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public List<AppointmentBean> getAppointmentlist() {
		return appointmentlist;
	}
	public void setAppointmentlist(List<AppointmentBean> appointmentlist) {
		this.appointmentlist = appointmentlist;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}

	
}
