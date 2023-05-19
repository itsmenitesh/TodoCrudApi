package com.TodoApplication.DemoApplication.services;

import com.TodoApplication.DemoApplication.repository.TodoDao;
import com.TodoApplication.DemoApplication.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;

    public List<Todo> getAllTodos(){
        return todoDao.getTodosFromDataSources();

    }
    public String addMyTodo(Todo todo){
       boolean insertionStatus = todoDao.save(todo);
       if(insertionStatus){
           return "Todo added successfully...!!!!";
       }else {
           return "Failed !!!!!!....not able to save the Todo..!!!";
       }
    }
    public Todo getTodoBasedOnId(String id)
    {
        List<Todo> todoListRightNow =  todoDao.getTodosFromDataSources();

        for(Todo todo : todoListRightNow)
        {
            if(todo.getId().equals(id))
            {
                return todo;// multiple IDs may exist
            }
        }
        return null;
    }
    public  String removeTodoById(String id){

        boolean deleteResponse = false;
        String status;
        if(id!=null){
            List<Todo> todoListRightNow =  todoDao.getTodosFromDataSources();

            for(Todo todo : todoListRightNow)
            {
                if(todo.getId().equals(id))
                {
                   deleteResponse=todoDao.remove(todo);
                   if(deleteResponse){
                       status = "Todo with Id"+ id + "was deleted!!!!";
                   }else {
                       status="Todo with id"+ id + "Database error!!!";
                   }
                   return status;
                }
            }
            return "Todo with id " + id + "does not exist!!!";
        }else {
            return "Invalid id.... Cannot accept null";
        }
    }
//    public String updateTodoStatusById(String id,String status)
//    {
//        List<Todo> todoListRightNow =  todoDao.getTodosFromDataSources();
//
//        for(Todo todo : todoListRightNow)
//        {
//            if(todo.getId().equals(id))
//            {
//                todoDao.update(id,status);
//            }
//        }
//        return null;
//    }
    public String updateTodoStatusById(String id,String status)
    {
        boolean updateStatus =  todoDao.update(id,Boolean.parseBoolean(status));

        if(updateStatus)
        {
            return "Todo with id: " + id + " was updated!!!";
        }
        else
        {
            return "Todo with id: " + id + " does not exist!!!";
        }
}


}
