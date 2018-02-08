package lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuddyInfoController {
    @Autowired
    BuddyInfoRepository buddyRepo;

    @RequestMapping("/allBuddies")
    public Iterable<BuddyInfo> getAllBuddies(){
        return buddyRepo.findAll();
    }
    @RequestMapping("/deleteBuddy")
    public void deleteBuddy( @RequestParam(value="id", required=false) Long id){
        BuddyInfo buddy = buddyRepo.findOne(id);
        buddyRepo.delete(buddy);
    }
}