package pl.coderslab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.models.Author;
import pl.coderslab.repository.AuthorRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorRepository authorRepository;

    @RequestMapping("/list")
    public String allCategories(Model model) {
        return "author/list";
    }

    @RequestMapping("/add")
    public String addAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "/author/add";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/author/list";
    }

    @RequestMapping("/edit/{id}")
    public String editAuthor(@PathVariable Long id, Model model) {
        Author author = authorRepository.findById(id);
        model.addAttribute("author", author);
        return "/author/edit";
    }

    @PostMapping("/edit")
    public String editAuthor(@ModelAttribute Author author) {
        authorRepository.update(author);
        return "redirect:/author/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id, Model model) {
        Author author = authorRepository.findById(id);
        model.addAttribute("author", author);
        return "/author/delete";
    }

    @RequestMapping("/deleteExecute/{id}/{statement}")
    public String deleteAuthorExecute(@PathVariable Long id, @PathVariable String statement) {
        if (Boolean.parseBoolean(statement)) {
            authorRepository.delete(authorRepository.findById(id));
        }
        return "redirect:/author/list";
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorRepository.findAll();
    }
}