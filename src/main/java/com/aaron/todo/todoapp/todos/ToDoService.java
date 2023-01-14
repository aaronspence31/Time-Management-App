package com.aaron.todo.todoapp.todos;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(todosCount++, "username", "Learn Lambda Expressions", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todosCount++, "username", "Learn Spring Security", LocalDate.now().plusYears(2), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        //Checks each todo and removes if id is matching
        Predicate< ? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }
}
