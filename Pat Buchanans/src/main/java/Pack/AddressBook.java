package Pack;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;
@Entity
public class AddressBook {



    @OneToMany(cascade = CascadeType.PERSIST)
    private List<JBuddy> jbuddies;
    @Id
    private Integer id;

    public AddressBook(){
        jbuddies = new ArrayList<JBuddy>();
    }

    public void addBuddy(JBuddy budd){
        jbuddies.add(budd);
    }

    public void removeBuddy(int index){

        if(index >=0 && index < jbuddies.size() ) {
            jbuddies.remove(index);

        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<JBuddy> getJbuddies() {
        return jbuddies;
    }

    public String toString(){

        for(JBuddy e:jbuddies){
            System.out.println(""+e.getName()+" "+e.getPhoneN());
        }
        return"";
    }

    public void setJbuddies(ArrayList<JBuddy> jbuddies) {
        this.jbuddies = jbuddies;
    }

    public int getSize(){
        return jbuddies.size();
    }

    public static void main(String[] args){
        AddressBook address = new AddressBook();

        JBuddy student1 = new JBuddy("Ahmed",232232);
        JBuddy student2 = new JBuddy("AK",42232);
        JBuddy student3 = new JBuddy("Ilham",65334);

        address.addBuddy(student1);
        address.addBuddy(student2);
        address.addBuddy(student3);

        address.toString();

    }


}
