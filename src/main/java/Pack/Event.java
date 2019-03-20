package Pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event {

    @Id
    private int id;
    private String eventName;
    private String description;

    public Event(String eventName, String description, int id){
        this.eventName = eventName;
        this.description = description;
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String toString()
    {
        return  "Event Name : " + getEventName()+ "Event Description : " + getDescription();
    }
}
