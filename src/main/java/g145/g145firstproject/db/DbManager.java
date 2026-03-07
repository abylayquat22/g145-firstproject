package g145.g145firstproject.db;

import g145.g145firstproject.dto.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static Long id = 6L;
    @Getter
    private static List<Student> students = new ArrayList<>(List.of(
            new Student(1L,"Lily","Alex",98,"A"),
            new Student(2L,"Lily2","Alex",98,"A"),
            new Student(3L,"Tom","Kaultz",85,"B"),
            new Student(4L,"Bill","Hero",100,"A"),
            new Student(5L,"Meru","Alex",98,"A")
    ));

    public static void addstudent(Student student) {
        student.setId(id);
        id++;
        if (student.getExam()>=90 && student.getExam()<=100){
            student.setMark("A");
        }else if (student.getExam()>=75 && student.getExam()<=89){
            student.setMark("B");
        }else if (student.getExam()>=60 && student.getExam()<=75){
            student.setMark("C");
        } else if (student.getExam()>=50 && student.getExam()<=59){
            student.setMark("D");
        }else {
            student.setMark("F");
        }
        students.add(student);
    }
}
