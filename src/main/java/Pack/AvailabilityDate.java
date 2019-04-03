package Pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AvailabilityDate {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;

    private String date1;

    public String getDate1() {
        return date1;
    }

    public String getDate2() {
        return date2;
    }



    public String getnewTime1(){
        String aString = this.date1;
        String newString = aString.substring(11, 16);
        return newString;
    }

    public String getnewTime2(){
        String aString = this.date2;
        String newString = aString.substring(11, 16);
        return newString;
    }

    public String getnewTime3(){
        String aString = this.date3;
        String newString = aString.substring(11, 16);
        return newString;
    }

    public String getDate3() {
        return date3;
    }

    private String date2;
    private String date3;

    public String getnewDate1() {
        String aString = this.date1;
        String newString = aString.substring(0, 10);
        return newString;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getnewDate2() {
        String aString = this.date2;
        String newString = aString.substring(0, 10);
        return newString;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getnewDate3() {
        String aString = this.date3;
        String newString = aString.substring(0, 10);
        return newString;
    }

    public void setDate3(String date3) {
        this.date3 = date3;
    }




    public AvailabilityDate(){

    }

    public AvailabilityDate(String pref1, String pref2, String pref3){
        this.date1 = pref1;
        this.date2 = pref2;
        this.date3 = pref3;
    }




}
