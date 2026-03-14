package g145.g145firstproject.dbo;

import g145.g145firstproject.db.Task;
import g145.g145firstproject.exception.NotFoundException;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DbManager {
    private static Long id = 3L;
    @Getter
    private static List<Task> tasks = new ArrayList<>(List.of(
            new Task(1L,"Complete all tasks of the weekend","2026.05.02",true),
            new Task(2L,"Vocal","2026.12.06",true)
    ));

    public static void addTasks(Task task) {
        task.setId(id);
        id++;

        tasks.add(task);
    }

    public static void editTask(Task task) {
        Task current = tasks.stream()
                .filter(t->t.getId().equals(task.getId()))
                .findFirst()
                .orElse(null);
        if (task.getName() != null){
            current.setName(task.getName());
        }
        if (task.getDeadlineDate()!=null){
            current.setDeadlineDate(task.getDeadlineDate());
        }
        if (task.isCompleted()){
            current.setCompleted(task.isCompleted());
        }
    }

    public static void deleteTask(Long id) {
        Task task = tasks.stream()
                .filter(t->t.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new NotFoundException("Task not found ID: "+ id));
        tasks.remove(task);
    }

    public static Task getTaskById(Long id) {
        Task task =tasks.stream()
                .filter(t->t.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new NotFoundException("Task not found ID: "+ id));
        return task;
    }

    public static List<TaskDTO> getTasksUtilData(String deadlineDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(deadlineDate,formatter);

       return tasks.stream()
                .map(task -> mapToDTO(task))
                .filter(taskDTO -> taskDTO.getDeadlineDate().isBefore(date))
                .toList();
    }

    private static TaskDTO mapToDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setName(task.getName());
        taskDTO.setId(task.getId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(task.getDeadlineDate(),formatter);
        taskDTO.setDeadlineDate(date);
        taskDTO.setCompleted(task.isCompleted());
        return taskDTO;
    }
}
