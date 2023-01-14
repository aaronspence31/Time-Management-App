package com.aaron.todo.todoapp.todos;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "username", "Learn Lambda Expressions", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(1, "username", "Learn Spring Security", LocalDate.now().plusYears(2), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
