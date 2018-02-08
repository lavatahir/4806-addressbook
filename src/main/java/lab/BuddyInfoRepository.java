package lab;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buddyinfos", path = "buddyinfos")
public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Long>{
    List<BuddyInfo> findByName(String name);
    List<BuddyInfo> findByPhoneNumber(String number);
}
