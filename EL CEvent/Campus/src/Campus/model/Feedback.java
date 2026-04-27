package Campus.model;

public class Feedback {
    private String eventName;
    private int rating;
    private String comments;

    public Feedback(String eventName, int rating, String comments) {
        this.eventName = eventName;
        this.rating = rating;
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public String getEventName() {
        return eventName;
    }

    public String toFileString() {
    return "----- FEEDBACK -----\n" +
           "Event Name : " + eventName + "\n" +
           "Rating     : " + rating + "\n" +
           "Comments   : " + comments + "\n" +
           "---------------------";
    }
}