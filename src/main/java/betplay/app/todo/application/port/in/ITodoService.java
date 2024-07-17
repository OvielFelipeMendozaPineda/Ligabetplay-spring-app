package betplay.app.Todo.application.port.in;

import java.util.List;
import java.util.Optional;

import betplay.app.Todo.domain.Todo;

/**
 * TodoService
 */
public interface ITodoService {

    Optional<Todo> findById(Long id);
    List<Todo> findAll();
    Todo update(Todo todo);
    Todo save(Todo todo);
    void delete(Todo todo);
}