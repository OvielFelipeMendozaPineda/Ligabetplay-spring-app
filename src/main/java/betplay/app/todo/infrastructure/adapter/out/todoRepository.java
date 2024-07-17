package betplay.app.Todo.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import betplay.app.Todo.application.port.out.TodoRepositoryPort;
import betplay.app.Todo.domain.Todo;

/**
 * TodoRepository
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryPort {

    
}