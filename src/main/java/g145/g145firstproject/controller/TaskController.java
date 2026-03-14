package g145.g145firstproject.controller;

import g145.g145firstproject.db.Task;
import g145.g145firstproject.dbo.DbManager;
import g145.g145firstproject.dbo.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @GetMapping
    public ResponseEntity<List<Task>>tasks(){
        List<Task> tasks= DbManager.getTasks();
        return  ResponseEntity.status(200).body(tasks);
    }
    @PostMapping
    public ResponseEntity<Void> addTask(@RequestBody Task task){
        DbManager.addTasks(task);
        return ResponseEntity.status(201).build();
    }
    @PutMapping
    public ResponseEntity<Task> editTask(@RequestBody Task task){
        DbManager.editTask(task);
        return ResponseEntity.status(201).body(task);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id){
        DbManager.deleteTask(id);
        return ResponseEntity.status(204).build();
    }
    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id){
    Task task = DbManager.getTaskById(id);
    return task;
    }
    @GetMapping("/deadlineDate")
    public List<TaskDTO> getTasksUntilData(@RequestParam String deadlineDate){
        List<TaskDTO> tasks = DbManager.getTasksUtilData(deadlineDate);
        return tasks;
    }
}
