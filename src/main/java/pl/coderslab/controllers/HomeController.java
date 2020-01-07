package pl.coderslab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.models.Article;
import pl.coderslab.repository.ArticleRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ArticleRepository articleRepository;


    @RequestMapping("/")
    public String homePage() {
        return "landingPage";
    }

    @ModelAttribute
    public List<Article> articles() {
        return articleRepository.findLastFive();
    }

}
