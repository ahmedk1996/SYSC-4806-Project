package Pack;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {


    private String description;
    private int max_Students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    private int id;
    private String restrictions;

    public Topic(){

    }
    public Topic(String description, String restrictions , int max_Students){
        this.description = description;
        this.max_Students = max_Students;
        this.restrictions = restrictions;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMax_Students() {
        return max_Students;
    }

    public void setMax_Students(int max_Students) {
        this.max_Students = max_Students;
    }

    public boolean equals(Object t){
        if(t instanceof Topic){
            Topic topic = (Topic) t;
           return  topic.description.equals(this.description) && topic.restrictions.equals(this.restrictions) && topic.max_Students == this.max_Students;
        }
        return false;
    }
    public String toString()
    {
        String s = "Topic Description : " + getDescription() +", Program Restrictions :" + getRestrictions() + ", Maximum Number of Students :" + getMax_Students();
        return s;
    }
}
