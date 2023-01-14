package com.aaron.todo.todoapp.todos;

import java.time.LocalDate;
import java.util.List;

public class ToDoService {
    private static List<Todo> todos;

    static {
        todos.add(new Todo(1, "username", "Learn Lambda Expressions", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(1, "username", "Learn Spring Security", LocalDate.now().plusYears(2), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
