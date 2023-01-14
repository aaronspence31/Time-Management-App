package com.aaron.todo.todoapp.todos;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//No longer used!!!
@Service
public class ToDoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(todosCount++, "aaron", "Learn Lambda Expressions", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todosCount++, "aaron", "Learn Spring Security", LocalDate.now().plusYears(2), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate< ? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList(); //return list of all todos with matching username
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

    public Todo findById(int id) {
        //Checks each todo and adds the first match
        Predicate< ? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
