package com.example.demo.service;



import com.example.demo.Model.Tasks;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    public Tasks getTasksById(Long id) {
        return taskRepository.getById(id);
    }

    public Tasks createTask(Tasks task) {
        return taskRepository.save(task);
    }

    public Tasks updateTask(Long id, Tasks taskDetails) {
        Tasks task = getTasksById(id);
        if(task!=null){
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setDueDate(taskDetails.getDueDate());
            task.setStatus(taskDetails.isStatus());
            return taskRepository.save(task);
        }else{
           return  null;
        }

    }

    public void deleteTask(Long id) {
        Tasks task = getTasksById(id);
        taskRepository.delete(task);
    }


}
