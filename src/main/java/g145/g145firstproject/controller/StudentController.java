package g145.g145firstproject.controller;

import g145.g145firstproject.db.DbManager;
import g145.g145firstproject.dto.Student;
import g145.g145firstproject.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public ResponseEntity<List<Student>> students() {
        List<Student> students = DbManager.getStudents();
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = null;
        return ResponseEntity.status(200).body(student);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String name) {
        List<Student> students = DbManager.getStudentsByName(name);
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        DbManager.addstudent(student);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student updated = DbManager.editStudent(student);
        return ResponseEntity.status(200).body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        DbManager.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
