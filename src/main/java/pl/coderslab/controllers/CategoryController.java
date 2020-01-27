package pl.coderslab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.models.Category;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/category")
@RequiredArgsConstructor
@Controller
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @RequestMapping("/list")
    public String allCategories(Model model) {
        return "category/list";
    }

    @RequestMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/category/add";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category") @Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/category/add";
        }
        categoryRepository.save(category);
        return "redirect:/category/list";
    }

    @RequestMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        Category category = categoryRepository.findById(id).get();
        model.addAttribute("category", category);
        return "/category/edit";
    }

    @PostMapping("/edit")
    public String editCategory(@ModelAttribute("category") @Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/category/edit";
        }
        categoryRepository.save(category);
        return "redirect:/category/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        Category category = categoryRepository.findById(id).get();
        model.addAttribute("category", category);
        return "/category/delete";
    }

    @RequestMapping("/deleteExecute/{id}/{statement}")
    public String deleteCategoryExecute(@PathVariable Long id, @PathVariable String statement) {
        if (Boolean.parseBoolean(statement)) {
            categoryRepository.delete(categoryRepository.findById(id).get());
        }
        return "redirect:/category/list";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }
}
