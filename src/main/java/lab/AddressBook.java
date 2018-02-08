package lab;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Collection<BuddyInfo> buddies;

    public AddressBook(){
        buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo b){
        buddies.add(b);
    }
    public void removeBuddy(BuddyInfo b){
        buddies.remove(b);
    }
    @Override
    public String toString(){
        String s = "";
        for (BuddyInfo buddy : buddies) {
            s+= buddy.toString();
            s+="\n";
        }
        return s;
    }
    public Collection<BuddyInfo> getBuddies(){
        return buddies;
    }
    public void setBuddies(List<BuddyInfo> a){
        this.buddies = a;
    }
    public Long getId(){
        return this.Id;
    }
    public void setId(Long id){
        this.Id = id;
    }
    public void printAddressBook(){
        System.out.println(this);
    }
    public void addBuddy(int index, BuddyInfo b){
        ArrayList<BuddyInfo> casterList = (ArrayList<BuddyInfo>) buddies;
        casterList.add(index, b);
    }
    public void removeBuddy(int index){
        ArrayList<BuddyInfo> casterList = (ArrayList<BuddyInfo>) buddies;
        casterList.remove(index);
    }
    public String getBuddy(int index){
        ArrayList<BuddyInfo> casterList = (ArrayList<BuddyInfo>) buddies;
        return casterList.get(index).toString();
    }
    @Override
    public boolean equals(Object o){
        if (this == o) { return true; }
        if (o == null) { return false; }
        if (getClass() != o.getClass()) { return false; }
        AddressBook a = (AddressBook) o;

        return buddies.containsAll(a.getBuddies()) && a.getBuddies().containsAll(buddies);
    }
    public static void main(String[] args){
        BuddyInfo b1 = new BuddyInfo("Lava", "613-555-5555");
        BuddyInfo b2 = new BuddyInfo("Me", "613-555-5557");
        AddressBook a = new AddressBook();
        a.addBuddy(b1);
        a.addBuddy(b2);
        a.printAddressBook();


    }

}
