package pl.akoz.zadanie26.flower;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akoz.zadanie26.category.Category;
import pl.akoz.zadanie26.category.CategoryRepository;
import pl.akoz.zadanie26.category.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class FlowerController {

    private CategoryRepository categoryRepository;
    private FlowerRepository flowerRepository;

    public FlowerController(CategoryRepository categoryRepository, FlowerRepository flowerRepository) {
        this.categoryRepository = categoryRepository;
        this.flowerRepository = flowerRepository;
    }

    @GetMapping("/flower/{id}")
    public String flower(@PathVariable Long id, Model model) {
        Optional<Flower> flowerOptional = flowerRepository.findById(id);

        if (flowerOptional.isPresent()) {
            Flower flower = flowerOptional.get();
            model.addAttribute("flower", flower);
            return "flower";
        } else {
            return "Błąd";

        }
    }

    @GetMapping("/flower/add")
    public String addForm(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("flower", new Flower());

        return "addFlower";
    }

    @PostMapping("/flower/add")
    public String addForm(Flower flower) {
        flowerRepository.save(flower);
        return "redirect:/flowers";
    }

}