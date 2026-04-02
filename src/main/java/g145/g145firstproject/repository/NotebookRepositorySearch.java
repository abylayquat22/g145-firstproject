package g145.g145firstproject.repository;

import g145.g145firstproject.dto.NotebookSearchRequest;
import g145.g145firstproject.entity.Notebook;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NotebookRepositorySearch {

    @Autowired
    private EntityManager entityManager;

    public List<Notebook> search(NotebookSearchRequest request) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Notebook> cq = cb.createQuery(Notebook.class);
        Root<Notebook> root = cq.from(Notebook.class);

        List<Predicate> predicates = new ArrayList<>();
        String name = request.getName();
        if (name != null && !name.isBlank()) {
            predicates.add(cb.equal(cb.lower(root.get("name")), name.toLowerCase()));
        }

        String code = request.getCode();
        if (code != null && !code.isBlank()) {
            predicates.add(cb.equal(root.get("code"), code));
        }

        String memory = request.getMemory();
        if (memory != null && !memory.isBlank()) {
            predicates.add(cb.equal(root.get("memory"), memory));
        }

        String ram = request.getRam();
        if (ram != null && !ram.isBlank()) {
            predicates.add(cb.equal(root.get("ram"), ram));
        }

        String graphicsCard = request.getGraphicsCard();
        if (graphicsCard != null && !graphicsCard.isBlank()) {
            predicates.add(cb.equal(root.get("graphicsCard"), graphicsCard));
        }

        String description = request.getDescription();
        if (description != null && !description.isBlank()) {
            predicates.add(cb.like(root.get("description"), "%" + description + "%"));
        }

        Double price = request.getPrice();
        if (price != null) {
            predicates.add(cb.le(root.get("price"), price));
        }

        Long brandId = request.getBrandId();
        if (brandId != null) {
            predicates.add(cb.equal(root.get("brand").get("id"), brandId));
        }

        cq.where(predicates);

        TypedQuery<Notebook> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}
