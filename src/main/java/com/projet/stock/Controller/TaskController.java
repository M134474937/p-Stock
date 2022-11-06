package com.projet.stock.Controller;
import com.projet.stock.Model.Client;
import com.projet.stock.Model.Task;
import com.projet.stock.Repository.TaskRepository;
import com.projet.stock.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskRepository TaskRepository;

    @GetMapping("/Task")
    public List<Task> getAllTasks(){
        System.out.println("Get all Tasks ........");
        List<Task> Tasks=new ArrayList<>();
        TaskRepository.findAll().forEach(Tasks::add);
        return Tasks;
    }

    @GetMapping("/Task/completed")
    public List<Task> getClientsCompleted() {
        List<Task> tasks = new ArrayList<>();
        TaskRepository.findallwherecompleted().forEach(tasks::add);
        return tasks;
    }

    @GetMapping("/Task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(value="id") long id) throws ResourceNotFoundException {
        Task Task=TaskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found"));
        return ResponseEntity.ok().body(Task);
    }

    @PostMapping("/Task")
    public ResponseEntity<String> saveTask(@Valid @RequestBody Task Task) throws ResourceNotFoundException {
        TaskRepository.save(Task);
        return ResponseEntity.ok("is OK");
    }

    @DeleteMapping("/Task/{id}")
    private Map<String, Boolean> deleteTask(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
        Task Task = TaskRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Impossible to delete Task cause is not found"));
        TaskRepository.delete(Task);
        Map<String,Boolean> response=new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return response;
    }

    @PutMapping("Task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") long id ,@Valid @RequestBody Task Task) throws ResourceNotFoundException {
        Optional<Task> Task1 =TaskRepository.findById(id);
        if(Task1.isPresent()) {
            Task ancienTask =Task1.get();
            ancienTask.setLabel(Task.getLabel());
            ancienTask.setCompleted(Task.isCompleted());
            return new ResponseEntity<>(TaskRepository.save(ancienTask), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("Task/{id}")
    public void AgainstComp(@PathVariable("id") long id,@RequestBody Task task){
        Optional<Task> Task1 =TaskRepository.findById(id);
        if(Task1.isPresent()) {
            Task ancienTask =Task1.get();
            ancienTask.setCompleted(task.isCompleted());
            TaskRepository.save(ancienTask);
        }

    }


}
