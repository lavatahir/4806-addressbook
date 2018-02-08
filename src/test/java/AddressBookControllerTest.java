import lab.AddressBook;
import lab.SpringBootApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        String buddyCreate = "{ \"name\": \"Lava\", \"phoneNumber\": \"613-555-5555\" }";
        String addBuddyToBook = "/addBuddyInfo?bookId=1&buddyId=5";
        String getAllBooks = "/getAllBooks";
        this.mockMvc.perform(post("/buddyinfos")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(buddyCreate))
                .andExpect(status()
                        .isCreated());
        this.mockMvc.perform(post("/addressbooks")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status()
                        .isCreated());
        this.mockMvc.perform(post(addBuddyToBook))
                    .andExpect(status().isOk());
        this.mockMvc.perform(get(getAllBooks))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("Lava")));
    }

    @Test
    public void removeBuddyFromBookTest() throws Exception {
        String buddyCreate = "{ \"name\": \"Lava\", \"phoneNumber\": \"613-555-5555\" }";
        String addBuddyToBook = "/addBuddyInfo?bookId=1&buddyId=5";
        String removeBuddyToBook = "/removeBuddyInfo?bookId=1&buddyId=5";
        String getAllBooks = "/getAllBooks";

        this.mockMvc.perform(post("/buddyinfos")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(buddyCreate))
                .andExpect(status()
                        .isCreated());
        this.mockMvc.perform(post("/addressbooks")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status()
                        .isCreated());
        this.mockMvc.perform(post(addBuddyToBook))
                .andExpect(status().isOk());
        this.mockMvc.perform(post(removeBuddyToBook))
                .andExpect(status().isOk());
        this.mockMvc.perform(get(getAllBooks))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("")));
    }
}
