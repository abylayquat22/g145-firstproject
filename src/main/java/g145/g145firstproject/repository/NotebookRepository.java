package g145.g145firstproject.repository;

import g145.g145firstproject.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
}
