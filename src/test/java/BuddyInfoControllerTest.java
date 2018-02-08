import lab.BuddyInfo;
import lab.SpringBootApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Response;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BuddyInfoControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void createBuddyTest() throws Exception {
        String uri = "http://localhost:" + port + "/buddyinfos";
        BuddyInfo b = new BuddyInfo("Lava", "613-555-5555");
        BuddyInfo returns = this.restTemplate.postForObject(uri, b, BuddyInfo.class);
        assertEquals(b, returns);
    }
}
