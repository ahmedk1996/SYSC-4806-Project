package Pack;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;
@Entity
public class Coordinator {


    private String name;
    @Id
    private Integer id;
    //private AvailabilityDate date = new AvailabilityDate();


    public Coordinator(String name, Integer id){
        this.name=name;
        this.id=id;
        //this.date = new AvailabilityDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
