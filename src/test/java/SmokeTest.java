import lab.AddressBookController;
import lab.BuddyInfoController;
import lab.SpringBootApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApp.class)
public class SmokeTest {

    @Autowired
    private AddressBookController addressController;

    @Autowired
    private BuddyInfoController buddyInfoController;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(addressController);
        assertNotNull(buddyInfoController);
    }
}
