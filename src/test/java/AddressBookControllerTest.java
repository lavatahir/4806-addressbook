import lab.AddressBook;
import lab.BuddyInfo;
import lab.SpringBootApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressBookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getInitialEmptyAddressBookTest() throws Exception {
        AddressBook expected = new AddressBook();
        AddressBook response = this.restTemplate.getForObject("http://localhost:" + port + "/", AddressBook.class);
        assertEquals(expected, response);
    }

    /*
    @Test
    public void addBuddyToBookTest() throws Exception {
        AddressBook expected = new AddressBook();
        String uri = new String("http://localhost:"+port+"/buddyinfos");
        BuddyInfo b = new BuddyInfo("Lava", "613-555-5555");
        BuddyInfo buddyInfoResponse = this.restTemplate.postForObject(uri, b, BuddyInfo.class);

        String bookCreationUri = new String("http://localhost:"+port+"/createBook");

        AddressBook addressBookResponse = this.restTemplate.postForObject(bookCreationUri, expected, AddressBook.class);

        String addBuddyToBookUri = new String("http://localhost:"+port+"/addBuddyInfo/?bookId=" + addressBookResponse.getId() + "&buddyId=" + buddyInfoResponse.getId());

    }
    */
}
