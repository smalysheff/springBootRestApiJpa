package ru.smal.springbootrestapijpa.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smal.springbootrestapijpa.persistence.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
