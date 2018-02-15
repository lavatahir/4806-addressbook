package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoutingController {
    public final BuddyInfoRepository buddyInfoRepository;
    public final AddressBookRepository addressBookRepository;

    @Autowired
    public RoutingController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository){
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @GetMapping("/addBuddy")
    public String addBuddyForm(Model m){
        m.addAttribute("buddy", new BuddyInfo());
        return "addBuddy";
    }

    @PostMapping("/addBuddy")
    public String addBuddySubmit(@ModelAttribute BuddyInfo buddy){
        buddyInfoRepository.save(buddy);
        return "addBuddyResult";
    }

    @PostMapping("/addBook")
    public String addBookSubmit(@ModelAttribute AddressBook book){
        addressBookRepository.save(book);
        return "book";
    }

    @GetMapping("/book")
    public String booksForm(Model m){
        Iterable<BuddyInfo> buddies = this.buddyInfoRepository.findAll();
        m.addAttribute("buddy", new BuddyInfo());
        m.addAttribute("buddies", buddies);
        return "book";
    }
}