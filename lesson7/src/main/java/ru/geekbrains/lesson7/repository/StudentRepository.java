package ru.geekbrains.lesson7.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.lesson7.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
