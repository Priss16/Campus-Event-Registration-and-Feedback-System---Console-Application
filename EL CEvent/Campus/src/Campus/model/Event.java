package Campus.model;

public class Event {
    private String eventName;
    private String date;

    public Event(String eventName, String date) {
        this.eventName = eventName;
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public String toString() {
        return "Event Name : " + eventName + "\nEvent Date : " + date;
    }
}