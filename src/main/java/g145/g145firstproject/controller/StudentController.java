package g145.g145firstproject.controller;

import g145.g145firstproject.db.DbManager;
import g145.g145firstproject.dto.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public List<Student> student() {
        List<Student> students = DbManager.getStudents();
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        Student student = DbManager.getStudentById(id);
        return student;
    }

    @GetMapping("/search")
    public List<Student> getStudentsByName(@RequestParam String name) {
        List<Student> students = DbManager.getStudentsByName(name);
        return students;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        DbManager.addstudent(student);
    }

    @PutMapping
    public void editStudent(@RequestBody Student student) {
        DbManager.editStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        DbManager.deleteById(id);
    }
}
