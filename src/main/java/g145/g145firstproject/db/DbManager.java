package g145.g145firstproject.db;

import g145.g145firstproject.dto.Brand;
import g145.g145firstproject.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static List<Product> products = new ArrayList<>(List.of(
            new Product(1,"Jacket",250.0, "Chanel"),
            new Product(2,"Jacket",250.0, "LV")

    ));
    private static List<Brand> brands = new ArrayList<>(List.of(
            new Brand(1,"Chanel","Crated by XXX"),
            new Brand(2,"LV","Crated by XXX")
    ));

}
