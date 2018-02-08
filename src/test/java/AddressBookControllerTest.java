import lab.AddressBook;
import lab.BuddyInfo;
import lab.SpringBootApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

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

    @Test
    public void addBuddyToBookTest() throws Exception {
        //this.mockMvc.perform(post(/))
    }

    @Test
    public void removeBuddyFromBookTest() throws Exception {

    }
}
