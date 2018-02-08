import junit.framework.TestCase;
import org.junit.Assert;
import lab.*;

public class AddressBookTest extends TestCase{
    AddressBook a;
    public void setUp()  {
        a = new AddressBook();
    }

    public void testAddBuddy() throws Exception {
        a.addBuddy(new BuddyInfo("L","613-222-2222"));
        Assert.assertTrue(a.getBuddies().size() == 1);
    }

    public void testRemoveBuddy() throws Exception {
        BuddyInfo b = new BuddyInfo("LT","613-222-2242");
        a.addBuddy(new BuddyInfo("L","613-222-2222"));
        a.addBuddy(b);
        a.removeBuddy(b);
        Assert.assertTrue(a.getBuddies().size() == 1);
    }

    public void testEquals() throws Exception {
        AddressBook b = new AddressBook();
        a.addBuddy(new BuddyInfo("L","613-222-2222"));
        b.addBuddy(new BuddyInfo("L","613-222-2222"));
        assertTrue(a.equals(b));
    }
    public void testNotEquals() throws Exception {
        AddressBook b = new AddressBook();
        a.addBuddy(new BuddyInfo("L","613-222-2223"));
        b.addBuddy(new BuddyInfo("L","613-222-2222"));
        assertFalse(a.equals(b));
    }

}