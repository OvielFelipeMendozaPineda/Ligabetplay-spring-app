package betplay.app.Todo.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betplay.app.Todo.application.port.in.ITodoService;
import betplay.app.Todo.domain.Todo;
import betplay.app.Todo.infrastructure.adapter.out.TodoRepository;

/**
 * TodoService
 */
@Service
public class TodoService implements ITodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo update(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void delete(Todo todo) {
        todoRepository.delete(todo);
    }

    
}