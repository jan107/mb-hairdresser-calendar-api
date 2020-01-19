package mb.hairdresser.model;

import java.io.Serializable;
import java.util.List;

public class OutputLambdaResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<CalendarEvent> events;
		
	public OutputLambdaResponse() {
		super();
	}
		
	public OutputLambdaResponse(List<CalendarEvent> events) {
		super();
		this.events = events;
	}

	public List<CalendarEvent> getEvents() {
		return events;
	}

	public void setEvents(List<CalendarEvent> events) {
		this.events = events;
	}
}
