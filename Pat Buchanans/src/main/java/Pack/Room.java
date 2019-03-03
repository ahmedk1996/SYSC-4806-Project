package Pack;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    private int id;

    private boolean availability;
    private Coordinator assigner;

    public void Room(){

    }
    public void Room(int roomNumber){
        this.id = roomNumber;
        availability = false;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Coordinator getAssigner() {
        return assigner;
    }

    public void setAssigner(Coordinator assigner) {
        this.assigner = assigner;
    }
}