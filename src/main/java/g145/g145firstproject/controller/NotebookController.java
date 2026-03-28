package g145.g145firstproject.controller;

import g145.g145firstproject.entity.Country;
import g145.g145firstproject.entity.Notebook;
import g145.g145firstproject.repository.CountryRepository;
import g145.g145firstproject.repository.NotebookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notebooks")
@RequiredArgsConstructor
public class NotebookController {

    private final NotebookRepository notebookRepository;
    private final CountryRepository countryRepository;

    @PostMapping
    public void addNotebook(@RequestBody Notebook notebook) {
        notebookRepository.save(notebook);
    }

    @GetMapping
    public List<Notebook> getNotebooks() {
        return notebookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Notebook getNotebook(@PathVariable Long id) {
        return notebookRepository.findById(id).orElse(null);
    }

    @PutMapping
    public void editNotebook(@RequestBody Notebook notebook) {
        notebookRepository.save(notebook);
    }

    @GetMapping("/find-by-code")
    public Notebook getNotebook(@RequestParam String code) {
        return notebookRepository.findByCode(code).orElse(null);
    }

    @GetMapping("/find")
    public List<Notebook> getNotebooks(@RequestParam String ram,
                                       @RequestParam String memory) {
        return notebookRepository.find(ram, memory);
    }

    @PostMapping("/{notebookId}/add-country/{countryId}")
    public void addCountry(@PathVariable Long notebookId, @PathVariable Long countryId) {
        Notebook notebook = notebookRepository.findById(notebookId).orElseThrow();
        Country country = countryRepository.findById(countryId).orElseThrow();
        notebook.getCollectingCountries().add(country);
        notebookRepository.save(notebook);
    }

    @DeleteMapping("/{notebookId}/delete-country/{countryId}")
    public void deleteCoutnry(@PathVariable Long notebookId, @PathVariable Long countryId) {
        Notebook notebook = notebookRepository.findById(notebookId).orElseThrow();
        Country country = countryRepository.findById(countryId).orElseThrow();
        notebook.getCollectingCountries().remove(country);
        notebookRepository.save(notebook);
    }
}
