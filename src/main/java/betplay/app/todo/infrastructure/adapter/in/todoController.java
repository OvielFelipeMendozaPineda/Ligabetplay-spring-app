package betplay.app.Todo.infrastructure.adapter.in;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import betplay.app.Todo.application.service.TodoService;
import betplay.app.Todo.domain.Todo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TodoController
 */
@Controller
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/getTodoById")
    @ResponseBody
    public ResponseEntity<Optional<Todo>> getTodo(@RequestParam Long id) {
        try {
            Optional<Todo> todo = todoService.findById(id);
            if (todo.isPresent()) {
                return new ResponseEntity<>(todo, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllTodos")
    @ResponseBody
    public ResponseEntity<List<Todo>> getAllTodos() {
        try {
            List <Todo> todos = todoService.findAll();
            if (todos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(todos, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/postTodo")
    public ResponseEntity<Optional<Todo>> postTodo(@RequestBody Todo todo) {
        try {
            Todo savedTodo = todoService.save(todo);
            if (savedTodo != null) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
