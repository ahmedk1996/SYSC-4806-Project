/*
package Pack;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;
@Entity
public class Coordinator {


    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Event> events;
    @Id
    private Integer id;

    public Coordinator(){
        events = new ArrayList<Event>();
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public void removeEvent(int index){

        if(index >=0 && index < events.size() ) {
            events.remove(index);

        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Event> getEvents() {
        return events;
    }

    public String toString(){

        for(Event e: events){
            System.out.println(""+e.getDescription()+" ");
        }
        return"";
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public int getSize(){
        return events.size();
    }


}
*/
