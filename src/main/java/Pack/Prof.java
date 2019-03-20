package Pack;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;
@Entity
public class Prof {

    @OneToMany(cascade = CascadeType.PERSIST)
    @Id
    private int id;
    private String name;
    public Prof(String name, int id){
        this.name = name;
        this.id=id;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {this.id=id;}
    public String toString(){
        return this.getName()+this.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
