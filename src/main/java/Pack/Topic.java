package Pack;

import org.w3c.dom.DOMStringList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Topic {

    @Id
    @GeneratedValue
    private int id;
    private String restrictions;

    private int profID;
    private String topicName;
    private String description;
    private int max_Students;
    private Date start;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Topic(){

    }
    public Topic(String topicName, String description, String restrictions , int max_Students){
        this.topicName = topicName;
        this.description = description;
        this.max_Students = max_Students;
        this.restrictions = restrictions;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
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
    public int getProfID() {
        return profID;
    }

    public void setProfID(int profID) {
        this.profID = profID;
    }
}
