package Campus.model;

public class Registration {
    private String eventName;
    private String regNo;
    private String date;

    public Registration(String eventName, String regNo, String date) {
        this.eventName = eventName;
        this.regNo = regNo;
        this.date = date;
    }

    public String toFileString() {
    return "----- REGISTRATION -----\n" +
           "Event Name : " + eventName + "\n" +
           "RegNo      : " + regNo + "\n" +
           "Date       : " + date + "\n" +
           "------------------------";
    }

}
