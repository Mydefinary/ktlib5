package ktlib.domain;

import ktlib.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "periodSubscribes",
    path = "periodSubscribes"
)
public interface PeriodSubscribeRepository
    extends PagingAndSortingRepository<PeriodSubscribe, Long> {}
