package pl.coderslab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.models.Article;
import pl.coderslab.models.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;


    @RequestMapping("/")
    public String homePage() {
        return "landingPage";
    }

    @RequestMapping("/articlesFromCategory/{id}")
    public String articlesFromCategory(@PathVariable Long id, Model model) {
        Category category = categoryRepository.findById(id).get();
        List<Article> articles = articleRepository.findFromCategory(category);
        model.addAttribute("category", category);
        model.addAttribute("articles", articles);
        return "articlesFromCategory";
    }

    @ModelAttribute("lastFiveArticles")
    public List<Article> getLastFiveArticles() {
        return articleRepository.findLastFiveArticles();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
