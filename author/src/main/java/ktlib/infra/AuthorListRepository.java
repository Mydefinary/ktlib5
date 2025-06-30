package ktlib.infra;

import java.util.List;
import ktlib.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "authorLists",
    path = "authorLists"
)
public interface AuthorListRepository
    extends PagingAndSortingRepository<AuthorList, Long> {}
