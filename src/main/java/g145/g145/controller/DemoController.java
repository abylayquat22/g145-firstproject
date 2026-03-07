package g145.g145.controller;

import g145.g145.dto.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class DemoController {
    @GetMapping("/index")
    public String controller(Model model){
        Item item = new Item(1L,"laptop","very good thing for programmer",1000);
        Item item1 = new Item(2L,"Car","very good thing for programmer",20000);
        Item item2 = new Item(3L,"Book","very good thing for programmer",100);
        Item item3 = new Item(4L,"TV","very good thing for programmer",1500);
        Item item4 = new Item(5L,"Jacket","very good thing for programmer",300);

        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        model.addAttribute("items", items);
        return "index";
    }

}
