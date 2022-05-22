package pl.akoz.zadanie26;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akoz.zadanie26.category.CategoryRepository;
import pl.akoz.zadanie26.flower.Flower;
import pl.akoz.zadanie26.flower.FlowerRepository;

import java.util.List;

@Controller
public class ShopController {

    CategoryRepository categoryRepository;
    FlowerRepository flowerRepository;

    public ShopController(CategoryRepository categoryRepository, FlowerRepository flowerRepository) {
        this.categoryRepository = categoryRepository;
        this.flowerRepository = flowerRepository;
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

    @GetMapping("/flower")
    public String flower(Model model) {
        model.addAttribute("flower", categoryRepository.findAll());
        return "flower";
    }

    @GetMapping("/flowers")
    public String flowers(Model model) {
        List<Flower> flowers = flowerRepository.findAllByOrderByNameAsc();
        model.addAttribute("flowers", flowers);
        return "flowers";
    }

    @GetMapping("/discount")
    public String discount(Model model) {
        return "discount";
    }

    @GetMapping("/accessories")
    public String accessories(Model model) {
        return "accessories";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/account")
    public String account(Model model) {
        return "account";
    }

    @GetMapping("/wishlist")
    public String wishlist(Model model) {
        return "wishlist";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        return "contact";
    }

}
