package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.models.Article;
import pl.coderslab.models.Author;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.AuthorRepository;

import java.util.List;

@Controller
public class HomeController {
    final private ArticleRepository articleRepository = new ArticleRepository();
    final private AuthorRepository authorRepository = new AuthorRepository();

    @RequestMapping("/")
    public String homePage() {
        return "landingPage";
    }

    @ModelAttribute
    public List<Author> articles() {
        return authorRepository.findAll();
    }

}
