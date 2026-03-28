package g145.g145firstproject.repository;

import g145.g145firstproject.entity.Notebook;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {

    Optional<Notebook> findByCode(String code);

    @Query("select n from Notebook n where n.ram = :ram and n.memory = :memory")
    List<Notebook> find(String ram, String memory);
}
