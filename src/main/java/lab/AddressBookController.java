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
    public void addBuddyInfo(@RequestParam(value="id", required=false) Long id, @RequestParam(value="phoneNumber", required=false) String phoneNumber){
        AddressBook book = addressBookRepository.findOne(id);
        BuddyInfo buddyToAdd = buddyInfoRepository.findOne(phoneNumber);
        book.addBuddy(buddyToAdd);
        addressBookRepository.save(book);
    }
    @RequestMapping(value = "/removeBuddyInfo")
    public void removeBuddyInfo(@RequestParam(value="id", required=false) Long id, @RequestParam(value="phoneNumber", required=false) String phoneNumber){
        AddressBook book = addressBookRepository.findOne(id);
        BuddyInfo buddyToRemove = buddyInfoRepository.findOne(phoneNumber);
        book.removeBuddy(buddyToRemove);
        addressBookRepository.save(book);
    }
    @RequestMapping("/getAllBooks")
    public Iterable<AddressBook> getAllBooks(){
        return addressBookRepository.findAll();
    }
    @RequestMapping(value = "createBook")
    public AddressBook createBook(){
        AddressBook book = new AddressBook();
        return addressBookRepository.save(book);
    }
}
