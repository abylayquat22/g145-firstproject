package g145.g145firstproject.controller;

import g145.g145firstproject.entity.Notebook;
import g145.g145firstproject.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notebooks")
public class NotebookController {

    @Autowired
    private NotebookRepository notebookRepository;

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
}
