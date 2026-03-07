package g145.g145firstproject.db;

import g145.g145firstproject.dto.Notebook;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static Notebook notebook = Notebook.builder()
            .id(1L)
            .name("MacBook Pro 16")
            .brand("Apple")
            .price(2499.99)
            .memory("1TB")
            .ram("16GB")
            .description("The ultimate notebook for professionals, featuring a stunning Retina display and powerful performance.")
            .processor("Apple M1 Pro")
            .graphicsCard("Apple M1 Pro GPU")
            .build();

    private static Notebook notebook1 = Notebook.builder()
            .id(2L)
            .name("Dell XPS 15")
            .brand("Dell")
            .price(1499.99)
            .memory("512GB")
            .ram("16GB")
            .description("A high-performance notebook with a sleek design, perfect for both work and entertainment.")
            .processor("Intel Core i7-11800H")
            .graphicsCard("NVIDIA GeForce RTX 3050 Ti")
            .build();

    private static Notebook notebook2 = Notebook.builder()
            .id(3L)
            .name("HP Spectre x360")
            .brand("HP")
            .price(1299.99)
            .memory("256GB")
            .ram("8GB")
            .description("A versatile 2-in-1 notebook with a stunning design and powerful performance for on-the-go productivity.")
            .processor("Intel Core i7-1165G7")
            .graphicsCard("Intel Iris Xe Graphics")
            .build();


    @Getter
    private static List<Notebook> notebooks = new ArrayList<>(List.of(notebook, notebook1, notebook2));


    public static Notebook getNotebookById(Long id) {
        for (Notebook notebook : notebooks) {
            if (notebook.getId().equals(id)) {
                return notebook;
            }
        }

        return null;
    }

    public static List<Notebook> searchNotebooks(String name, Double price) {
        if ((name == null || name.isBlank()) && price == null) {
            return notebooks;
        }

        if ((name != null && !name.isBlank()) && price != null) {
            return notebooks.stream()
                    .filter(n -> n.getName().equalsIgnoreCase(name) && n.getPrice().equals(price))
                    .toList();
        }

        if (name != null && !name.isBlank()) {
            return notebooks.stream()
                    .filter(n -> n.getName().equalsIgnoreCase(name))
                    .toList();
        }

        return notebooks.stream()
                .filter(n -> n.getPrice().equals(price))
                .toList();
    }
}
