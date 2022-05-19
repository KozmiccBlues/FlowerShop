package pl.akoz.zadanie26.flower;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akoz.zadanie26.category.CategoryRepository;
import pl.akoz.zadanie26.category.CategoryRepository;

@Controller
public class FlowerController {

    private CategoryRepository categoryRepository;
    private FlowerRepository flowerRepository;

    public FlowerController(CategoryRepository categoryRepository, FlowerRepository flowerRepository) {
        this.categoryRepository = categoryRepository;
        this.flowerRepository = flowerRepository;
    }

    @GetMapping("/flower/add")
    public String addForm(Model model, @RequestParam Long categoryId) {
        Flower flower = new Flower();
        flower.setCategory(categoryRepository.findById(categoryId).orElse(null));
        model.addAttribute("flower", flower);
        model.addAttribute("categories", categoryRepository.findAll());
        return "addFlower";

    }

    @PostMapping("/flower/add")
    public String addForm(Flower flower) {
        flowerRepository.save(flower);
        return "redirect:/category/" + flower.getCategory().getId();

    }
}
