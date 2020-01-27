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
import pl.coderslab.DraftValidationGroup;
import pl.coderslab.models.Article;
import pl.coderslab.models.Author;
import pl.coderslab.models.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/draft")
public class DraftController {
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final ArticleRepository articleRepository;

    @RequestMapping("/list")
    public String allArticles(Model model) {
        return "draft/list";
    }

    @RequestMapping("/add")
    public String addArticle(Model model) {
        model.addAttribute("draft", new Article());
        return "draft/add";
    }

    @PostMapping("/add")
    public String addArticle(@ModelAttribute("draft") @Validated(DraftValidationGroup.class) Article draft, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "draft/add";
        }
        draft.setDraft(true);
        articleRepository.save(draft);
        return "redirect:/draft/list";
    }

    @RequestMapping("/edit/{id}")
    public String editArticle(@PathVariable Long id, Model model) {
        Article draft = articleRepository.findById(id).get();
        model.addAttribute("draft", draft);
        return "draft/edit";
    }

    @PostMapping("/edit")
    public String editArticle(@ModelAttribute("draft") @Validated(DraftValidationGroup.class) Article draft, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "draft/edit";
        }
        draft.setDraft(true);
        articleRepository.save(draft);
        return "redirect:/draft/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id, Model model) {
        Article draft = articleRepository.findById(id).get();
        model.addAttribute("draft", draft);
        return "/draft/delete";
    }

    @RequestMapping("/deleteExecute/{id}/{statement}")
    public String deleteArticleExecute(@PathVariable Long id, @PathVariable String statement) {
        if (Boolean.parseBoolean(statement)) {
            articleRepository.delete(articleRepository.findById(id).get());
        }
        return "redirect:/draft/list";
    }

    @ModelAttribute("drafts")
    public List<Article> drafts() {
        return articleRepository.findAllDrafts();
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
