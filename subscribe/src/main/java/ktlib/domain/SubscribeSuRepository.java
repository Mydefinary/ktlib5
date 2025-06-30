package ktlib.domain;

import java.util.Date;
import java.util.List;
import ktlib.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "subscribeSus",
    path = "subscribeSus"
)
public interface SubscribeSuRepository
    extends PagingAndSortingRepository<SubscribeSu, Long> {}
