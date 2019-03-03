package Pack;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;
@Entity
public class Prof {



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

    public static void main(String[] args){
        Prof address = new Prof();

        Topic topic1 = new Topic("Ahmed",232232);
        Topic topic2 = new Topic("AK",42232);
        Topic topic3 = new Topic("Ilham",65334);

        address.addTopic(topic1);
        address.addTopic(topic2);
        address.addTopic(topic3);

        address.toString();

    }


}
