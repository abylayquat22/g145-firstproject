package g145.g145firstproject.controller;

import g145.g145firstproject.dto.Notebook;
import g145.g145firstproject.dto.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DemoController {

    @GetMapping("/home")
    public String home(Model model) {
        Phone phone = new Phone("iPhone 14 Pro Max", "Apple", 1099.99, "The latest iPhone with advanced features and a stunning design.");
        Phone phone1 = Phone.builder()
                .name("Samsung Galaxy S23 Ultra")
                .price(1199.99)
                .brand("Samsung")
                .build();

        List<Phone> phones = List.of(phone, phone1);
        model.addAttribute("phones", phones);

        return "home";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Notebook notebook1 = Notebook.builder()
                .name("MacBook Pro 16")
                .brand("Apple")
                .price(2499.99)
                .memory("1TB")
                .ram("16GB")
                .description("The ultimate notebook for professionals, featuring a stunning Retina display and powerful performance.")
                .processor("Apple M1 Pro")
                .graphicsCard("Apple M1 Pro GPU")
                .build();

        Notebook notebook2 = Notebook.builder()
                .name("Dell XPS 15")
                .brand("Dell")
                .price(1499.99)
                .memory("512GB")
                .ram("16GB")
                .description("A high-performance notebook with a sleek design, perfect for both work and entertainment.")
                .processor("Intel Core i7-11800H")
                .graphicsCard("NVIDIA GeForce RTX 3050 Ti")
                .build();

        Notebook notebook3 = Notebook.builder()
                .name("HP Spectre x360")
                .brand("HP")
                .price(1299.99)
                .memory("256GB")
                .ram("8GB")
                .description("A versatile 2-in-1 notebook with a stunning design and powerful performance for on-the-go productivity.")
                .processor("Intel Core i7-1165G7")
                .graphicsCard("Intel Iris Xe Graphics")
                .build();

        List<Notebook> notebooks = List.of(notebook1, notebook2, notebook3);
        model.addAttribute("notebooks", notebooks);
        return "dashboard";
    }
}
