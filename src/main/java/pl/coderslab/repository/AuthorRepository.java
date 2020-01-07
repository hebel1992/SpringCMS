package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.models.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Author author) {
        entityManager.persist(author);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Author a", Author.class);
        return query.getResultList();
    }

}
