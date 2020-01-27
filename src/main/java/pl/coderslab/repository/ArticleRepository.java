package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.models.Article;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a WHERE a.draft=true")
    List<Article> findAllDrafts();

    @Query(value = "SELECT * FROM articles LIMIT 5", nativeQuery = true)
    List<Article> findLastFiveArticles();
}
