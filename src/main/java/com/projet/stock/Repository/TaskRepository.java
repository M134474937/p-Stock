package com.projet.stock.Repository;

import com.projet.stock.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT ts from Task ts where ts.completed=TRUE ")
    List<Task> findallwherecompleted();
}
