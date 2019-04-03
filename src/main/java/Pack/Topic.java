package Pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;


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
    private String preference1;
    private String preference2;
    private String preference3;


    public String getPreference1() {
        return preference1;
    }

    public void setPreference1(String preference1) {
        this.preference1 = preference1;
    }

    public String getPreference2() {
        return preference2;
    }

    public void setPreference2(String preference2) {
        this.preference2 = preference2;
    }

    public String getPreference3() {
        return preference3;
    }

    public void setPreference3(String preference3) {
        this.preference3 = preference3;
    }



    private ArrayList<Student> studentList;
    private ArrayList<String> announcement;

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    private boolean availability;


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
        this.studentList = new ArrayList<>();
        this.availability = true;
        this.announcement =  new ArrayList<>();
    }

    public ArrayList<String> getAnnouncementList() {
        return announcement;
    }
    public Boolean addStudent(Student student){
        if(this.isFull()){
            return false;
        }else{
            this.studentList.add(student);
            return true;
        }
    }

    public boolean isFull() {
        if(max_Students <= studentList.size()){
            return true;
        }else
            return false;
    }

    public void addAnnouncement(String announcement) {
        this.announcement.add(announcement);
    }

    public boolean isAvailability() {
        return availability;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;

    }

    public Topic(String topicName, String description, String restrictions , int max_Students, String preference1, String preference2, String preference3){
        this.topicName = topicName;
        this.description = description;
        this.max_Students = max_Students;
        this.restrictions = restrictions;
        this.preference1 = preference1;
        this.preference2 = preference2;
        this.preference3 = preference3;
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
