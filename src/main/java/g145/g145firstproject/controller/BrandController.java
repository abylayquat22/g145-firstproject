package g145.g145firstproject.controller;

import g145.g145firstproject.entity.Brand;
import g145.g145firstproject.entity.Notebook;
import g145.g145firstproject.repository.BrandRepository;
import g145.g145firstproject.repository.NotebookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandRepository brandRepository;

    @PostMapping
    public void addBrand(@RequestBody Brand brand) {
        brandRepository.save(brand);
    }

    @GetMapping
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

}
