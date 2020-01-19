package mb.hairdresser.model;

import java.io.Serializable;

import org.joda.time.DateTime;


public class CalendarEvent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DateTime date;
	private String name;
	
	public CalendarEvent() {
		super();
	}
	public CalendarEvent(DateTime date, String name) {
		super();
		this.date = date;
		this.name = name;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime dateTime) {
		this.date = dateTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
