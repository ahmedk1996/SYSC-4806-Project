package Pack;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JBuddy {


    private String name;
    @Id
    private int phoneN;

    public JBuddy(){

    }
    public JBuddy(String name, int phoneN){
        this.name = name;
        this.phoneN=phoneN;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneN() {
        return phoneN;
    }

    public void setPhoneN(int phoneN) {
        this.phoneN = phoneN;
    }

    public boolean equals(Object bud){
        if(bud instanceof JBuddy){
            JBuddy buddy = (JBuddy) bud;
           return  buddy.name.equals(this.name) && buddy.phoneN == this.phoneN ;
        }
        return false;
    }
    public String toString()
    {
        String s = "Buddy Name : " + getName() + ", Buddy Phone :" + getPhoneN();
        return s;
    }
}
