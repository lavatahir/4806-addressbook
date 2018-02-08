import junit.framework.TestCase;
import org.junit.Test;
import lab.*;

public class BuddyInfoTest extends TestCase {
    private BuddyInfo b;
    public void setUp()  {
        b = new BuddyInfo("default","default");
    }

    @Test
    public void testSetName() throws Exception {
        b.setName("newNAme");
        assertTrue(b.getName() == "newNAme");
    }

    @Test
    public void testSetphoneNumber() throws Exception {
        b.setPhoneNumber("613");
        System.out.println(b.getPhoneNumber());
        assertTrue(b.getPhoneNumber() == "613");
    }

    @Test
    public void testGetName() throws Exception {
        assertTrue(b.getName() == "default");
    }

    @Test
    public void testGetphoneNumber() throws Exception {
        assertTrue(b.getPhoneNumber() == "default");
    }

    @Test
    public void testBuddyInfoEquals() throws Exception {
        BuddyInfo b2 = new BuddyInfo("lava", "613-454-4444");
        BuddyInfo b3 = new BuddyInfo("lava", "613-454-4444");
        assertTrue(b2.equals(b3));
    }
    public void testBuddyInfoNotEquals() throws Exception {
        BuddyInfo b2 = new BuddyInfo("lava", "613-454-4444");
        BuddyInfo b3 = new BuddyInfo("lava", "613-454-4446");
        assertFalse(b2.equals(b3));
    }

}