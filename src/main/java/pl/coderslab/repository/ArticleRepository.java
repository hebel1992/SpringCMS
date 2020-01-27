package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.models.Article;
import pl.coderslab.models.Category;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a WHERE a.draft=true")
    List<Article> findAllDrafts();

    @Query(value = "SELECT * FROM articles LIMIT 5", nativeQuery = true)
    List<Article> findLastFiveArticles();

    @Query("SELECT a FROM Article a WHERE :category MEMBER a.categories")
    List<Article> findFromCategory(@Param("category") Category category);
}
