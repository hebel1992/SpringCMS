package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.models.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryRepository {
    @PersistenceContext
    EntityManager em;

    public void save(Category category) {
        em.persist(category);
    }

    public void delete(Category category) {
        em.remove(em.contains(category) ? category : em.merge(category));
    }

    public void update(Category category) {
        em.merge(category);
    }
}

