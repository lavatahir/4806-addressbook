package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {
    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    @RequestMapping(value = "/addBuddyInfo")
    public void addBuddyInfo(@RequestParam(value="bookId") Long bookId, @RequestParam(value="buddyId") Long buddyId){
        AddressBook book = addressBookRepository.findOne(bookId);
        BuddyInfo buddyToAdd = buddyInfoRepository.findOne(buddyId);
        book.addBuddy(buddyToAdd);
        addressBookRepository.save(book);
    }
    @RequestMapping(value = "/removeBuddyInfo")
    public void removeBuddyInfo(@RequestParam(value="bookId") Long bookId, @RequestParam(value="buddyId") Long buddyId){
        AddressBook book = addressBookRepository.findOne(bookId);
        BuddyInfo buddyToRemove = buddyInfoRepository.findOne(buddyId);
        book.removeBuddy(buddyToRemove);
        addressBookRepository.save(book);
    }
    @RequestMapping("/getAllBooks")
    public Iterable<AddressBook> getAllBooks(){
        return addressBookRepository.findAll();
    }

    @RequestMapping("/createBook")
    public void createBook(){
        addressBookRepository.save(new AddressBook());
    }
}
