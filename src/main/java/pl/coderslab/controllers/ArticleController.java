package pl.coderslab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.ArticleValidationGroup;
import pl.coderslab.models.Article;
import pl.coderslab.models.Author;
import pl.coderslab.models.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final ArticleRepository articleRepository;

    @RequestMapping("/list")
    public String allArticles() {
        return "article/list";
    }

    @RequestMapping("/add")
    public String addArticle(Model model) {
        model.addAttribute("article", new Article());
        return "article/add";
    }

    @PostMapping("/add")
    public String addArticle(@ModelAttribute("article") @Validated(ArticleValidationGroup.class) Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "article/add";
        }
        article.setDraft(false);
        articleRepository.save(article);
        return "redirect:/article/list";
    }

    @RequestMapping("/edit/{id}")
    public String editArticle(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).get();
        model.addAttribute("article", article);
        return "article/edit";
    }

    @PostMapping("/edit")
    public String editArticle(@ModelAttribute("article") @Validated(ArticleValidationGroup.class) Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "article/edit";
        }
        articleRepository.save(article);
        return "redirect:/article/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).get();
        model.addAttribute("article", article);
        return "/article/delete";
    }

    @RequestMapping("/deleteExecute/{id}/{statement}")
    public String deleteArticleExecute(@PathVariable Long id, @PathVariable String statement) {
        if (Boolean.parseBoolean(statement)) {
            articleRepository.delete(articleRepository.findById(id).get());
        }
        return "redirect:/article/list";
    }

    @ModelAttribute("articles")
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }
}
