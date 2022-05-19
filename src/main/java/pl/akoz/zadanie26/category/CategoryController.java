package pl.akoz.zadanie26.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.akoz.zadanie26.flower.FlowerRepository;
import pl.akoz.zadanie26.flower.FlowerRepository;

import java.util.Optional;

@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;
    private FlowerRepository flowerRepository;

    public CategoryController(CategoryRepository categoryRepository, FlowerRepository flowerRepository) {
        this.categoryRepository = categoryRepository;
        this.flowerRepository = flowerRepository;
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable Long id, Model model) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            model.addAttribute("category", category);
            return "category";
        } else {
            return "Błąd";

        }

    }
}




