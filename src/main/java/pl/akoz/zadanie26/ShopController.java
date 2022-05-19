package pl.akoz.zadanie26;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akoz.zadanie26.category.CategoryRepository;

@Controller
public class ShopController {

    public CategoryRepository categoryRepository;

    public ShopController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/category")
    public String category(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "category";

    }
}
