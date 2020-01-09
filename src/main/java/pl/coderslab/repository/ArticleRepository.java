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

    public List<Article> findAllArticle() {
        Query query = em.createQuery("SELECT a FROM Article a WHERE a.draft=false", Article.class);
        return query.getResultList();
    }

    public List<Article> findAllDrafts() {
        Query query = em.createQuery("SELECT a FROM Article a WHERE a.draft=true", Article.class);
        return query.getResultList();
    }

    public List<Article> findLastFiveArticles() {
        Query query = em.createQuery("SELECT a FROM Article a WHERE a.draft=false", Article.class   );
        query.setMaxResults(5);
        return query.getResultList();
    }

    public Article findById(Long id) {
        return em.find(Article.class, id);
    }
}
