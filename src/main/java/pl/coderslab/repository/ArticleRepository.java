package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.models.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Article article) {
        em.persist(article);
    }

    public void delete(Article article) {
        em.remove(em.contains(article) ? article : em.merge(article));
    }

    public void update(Article article) {
        em.merge(article);
    }

    public List<Article> findAll() {
        Query query = em.createQuery("SELECT a FROM Article a", Article.class);
        return query.getResultList();
    }

    public List<Article> findLastFive() {
        Query query = em.createQuery("SELECT a FROM Article a");
        query.setMaxResults(5);
        return query.getResultList();
    }

    public Article findById(Long id) {
        return em.find(Article.class, id);
    }
}
