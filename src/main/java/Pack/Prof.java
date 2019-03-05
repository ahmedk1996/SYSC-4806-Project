package Pack;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;
@Entity
public class Prof {


    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Topic> topics;
    @Id
    private Integer id;

    public Prof(){
        topics = new ArrayList<Topic>();
    }

    public void addTopic(Topic budd){
        topics.add(budd);
    }

    public void removeTopic(int index){

        if(index >=0 && index < topics.size() ) {
            topics.remove(index);

        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Topic> getTopics() {
        return topics;
    }

    public String toString(){

        for(Topic e: topics){
            System.out.println(""+e.getDescription()+" "+e.getMax_Students());
        }
        return"";
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    public int getSize(){
        return topics.size();
    }

    /*
    public static void main(String[] args){
        Prof prof = new Prof();

        Topic topic1 = new Topic("Ahmed","software",232232);
        Topic topic2 = new Topic("AK","software",42232);
        Topic topic3 = new Topic("Ilham","software",65334);

        prof.addTopic(topic1);
        prof.addTopic(topic2);
        prof.addTopic(topic3);

        prof.toString();

    }
*/

}
