package bean;

import java.util.List;

public class EventBean {

	private int eventId;
	private String name;
	private List<EventBean> eventlist;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int id) {
		this.eventId = id;
	}

	public List<EventBean> getEventlist() {
		return eventlist;
	}

	public void setEventlist(List<EventBean> eventlist) {
		this.eventlist = eventlist;
	}

	private String venue;
	private String endDate;
	private String startDate;
	
	public enum Occurrence {daily, weekly, monthly, annually};
	  
	private String occurrence;

	public String getOccurrence() {
		return occurrence;
	}

	public void setOccurrence(String occurrence) {
		this.occurrence = occurrence;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

}
