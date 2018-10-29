package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boot_jpa_listopad.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
