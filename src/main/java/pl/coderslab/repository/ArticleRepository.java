package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.models.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ArticleRepository {
    @PersistenceContext
    EntityManager em;

    public void save(Article article) {
        em.persist(article);
    }

    public void delete(Article article) {
        em.remove(em.contains(article) ? article : em.merge(article));
    }

    public void update(Article article) {
        em.merge(article);
    }
}
