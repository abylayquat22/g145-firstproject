package g145.g145firstproject.controller;

import g145.g145firstproject.db.DbManager;
import g145.g145firstproject.dto.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @GetMapping("/student")
    public String student(Model model){
        List<Student> students= DbManager.getStudents();
        model.addAttribute("students",students);
        return "student";
    }
    @GetMapping("/student/add")
    public String studentAddPage(){

       return "studentaddpage";
    }
    @PostMapping("/student/add")
    public String addstudent(Student student){
        DbManager.addstudent(student);

        return "redirect:/student";
    }
}
