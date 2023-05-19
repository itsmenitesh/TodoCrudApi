package com.TodoApplication.DemoApplication.controllers;

import com.TodoApplication.DemoApplication.services.TodoService;
import com.TodoApplication.DemoApplication.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;
    //get me al todos in my present
    @GetMapping(value = "/getAllTodos")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping(value = "/addTodo")//to store multiple Todo
    public String addTodo(@RequestBody Todo todo){
        return todoService.addMyTodo(todo);
    }
    @RequestMapping(value = "/getTodoById/{id}",method = RequestMethod.GET)
    public Todo getTodoById(@PathVariable String id)
    {
        return todoService.getTodoBasedOnId(id);
    }
    @DeleteMapping(value = "/deleteTodoById/{id}")
    public String deleteTodoById(@PathVariable String id){
        return todoService.removeTodoById(id);
    }
    @PutMapping(value = "/updateTodoById/{id}/{status}")
    public String updateTodoStatusById(@PathVariable String id,@PathVariable String status){
        return todoService.updateTodoStatusById(id,status);
    }

}
