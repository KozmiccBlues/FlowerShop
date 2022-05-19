package pl.akoz.zadanie26.flower;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akoz.zadanie26.category.Category;

import java.util.List;

public interface FlowerRepository extends JpaRepository<Flower, Long> {

    List<Flower> findByCategory(Category category);


}
