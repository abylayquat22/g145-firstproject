package g145.g145firstproject.controller;

import g145.g145firstproject.db.DBManager;
import g145.g145firstproject.dto.Notebook;
import g145.g145firstproject.dto.Phone;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
        List<Notebook> notebooks = DBManager.getNotebooks();
        model.addAttribute("notebooks", notebooks);
        return "dashboard";
    }


    @GetMapping("/notebooks/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        Notebook notebook = DBManager.getNotebookById(id);
        model.addAttribute("notebook", notebook);
        return "notebook-details";
    }

    @GetMapping("/notebooks/search")
    public String search(@RequestParam(required = false) String name,
                         @RequestParam(required = false) Double price,
                         Model model) {
        List<Notebook> notebooks = DBManager.searchNotebooks(name, price);
        model.addAttribute("notebooks", notebooks);
        return "dashboard";
    }

}
