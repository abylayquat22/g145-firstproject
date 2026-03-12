package g145.g145firstproject.db;

import g145.g145firstproject.dto.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
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
        String mark = calculateExam(student.getExam());
        student.setMark(mark);
        students.add(student);
    }
    
    private static String calculateExam(Integer exam) {
        if (exam == null) {
            return null;
        }

        if (exam>=90 && exam<=100){
            return "A";
        }else if (exam>=75 && exam<=89){
            return "B";
        }else if (exam>=60 && exam<=75){
            return "C";
        } else if (exam>=50 && exam<=59){
            return "D";
        }else {
            return "F";
        }
    }

    public static Student getStudentById(Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static void editStudent(Student student) {
        Student current = getStudentById(student.getId());
        if (student.getName() != null) {
            current.setName(student.getName());
        }
        
        if (student.getSurname() != null) {
            current.setSurname(student.getSurname());
        }
        
        if (student.getExam() != null) {
            String mark = calculateExam(student.getExam());
            current.setExam(student.getExam());
            current.setMark(mark);
        }
    }

    public static void deleteById(Long id) {
//        Student student = getStudentById(id);
//        if (student != null) {
//            students.remove(student);
//        }

        students.removeIf(s -> s.getId().equals(id));
    }

    public static List<Student> getStudentsByName(String name) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .sorted(Comparator.comparing(Student::getExam).reversed())
                .toList();
    }
}
