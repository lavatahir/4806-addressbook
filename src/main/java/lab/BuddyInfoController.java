package lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuddyInfoController {
    @Autowired
    BuddyInfoRepository buddyRepo;

    @RequestMapping("/allBuddies")
    public Iterable<BuddyInfo> getAllBuddies(){
        return buddyRepo.findAll();
    }
    @RequestMapping("/deleteBuddy")
    public void deleteBuddy(@RequestParam(value="name", required=false) String name, @RequestParam(value="phoneNumber", required=false) String phoneNumber){
        BuddyInfo b = buddyRepo.findOne(phoneNumber);
        buddyRepo.delete(b);
    }
}