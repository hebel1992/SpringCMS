package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.models.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Author author) {
        em.persist(author);
    }

    public void delete(Author author) {
        em.remove(em.contains(author) ? author : em.merge(author));
    }

    public void update(Author author) {
        em.merge(author);
    }

}
