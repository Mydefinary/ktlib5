package ktlib.infra;

import java.util.List;
import ktlib.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bookLists", path = "bookLists")
public interface BookListRepository
    extends PagingAndSortingRepository<BookList, Long> {
    List<BookList> findByManuscriptId(Long manuscriptId);
    List<BookList> findByPublicationId(Long publicationId);
}
