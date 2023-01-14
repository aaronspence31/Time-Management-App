package com.aaron.todo.todoapp.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {

    private ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping(value = "list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = toDoService.findByUsername("username");
        model.addAttribute("todos", todos);

        return "listTodos";
    }
}
