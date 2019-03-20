/*
package Pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;
    private Date deadline;

    private String eventName;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Event(){

    }
    public Event(String eventName, String description, Date deadline){
        this.eventName = eventName;
        this.description = description;
        this.deadline = deadline;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean equals(Object t){
        if(t instanceof Event){
            Event event = (Event) t;
            return  event.description.equals(this.description) && event.deadline.equals(this.deadline);
        }
        return false;
    }
    public String toString()
    {
        String s = "Event Name : " + getEventName()+ "Event Description : " + getDescription() +", Event Deadline: " + getDeadline();
        return s;
    }
}
*/
