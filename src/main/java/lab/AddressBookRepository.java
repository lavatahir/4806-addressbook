package lab;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressBooks", path = "addressbooks")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long> {
}
