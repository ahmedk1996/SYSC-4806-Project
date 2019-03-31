package Pack;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Coordinator {


    private String name;
    @Id
    private Integer id;

    public Coordinator(String name, Integer id){
        this.name=name;
        this.id=id;
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
