package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.models.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Category category) {
        em.persist(category);
    }

    public void delete(Category category) {
        em.remove(em.contains(category) ? category : em.merge(category));
    }

    public void update(Category category) {
        em.merge(category);
    }

    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    public List<Category> findAll() {
        Query query = em.createQuery("SELECT c FROM Category c", Category.class);
        return query.getResultList();
    }
}

