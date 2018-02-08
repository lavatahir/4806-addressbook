package lab;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String phoneNumber;
    private String name;


    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo(){
        this.name = "DEFAULT";
        this.phoneNumber = "DEFAULT";
    }
    public Long getId(){
        return this.Id;
    }
    public void setId(Long id){
        this.Id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){ return phoneNumber; }

    @Override
    public String toString(){
        return name + ": " + phoneNumber;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){ return true; }
        if(!(o instanceof BuddyInfo)){
            return false;
        }
        BuddyInfo b = (BuddyInfo) o;
        return (b.phoneNumber.equals(this.phoneNumber) && b.name.equals(this.name));
    }
}

