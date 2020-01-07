package pl.coderslab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.models.Category;
import pl.coderslab.repository.CategoryRepository;

import java.util.List;

@RequestMapping("/category")
@RequiredArgsConstructor
@Controller
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @RequestMapping("/list")
    public String allCategories(Model model) {
//        model.addAttribute("categories", categoryRepository.findAll());
        return "category/list";
    }

    @RequestMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/category/add";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:list";
    }

    @RequestMapping("/edit")
    public String editCategory() {
        return "/category/edit";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }
}
