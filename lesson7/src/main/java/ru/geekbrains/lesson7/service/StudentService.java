package ru.geekbrains.lesson7.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.lesson7.model.Student;
import ru.geekbrains.lesson7.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll().stream().collect(Collectors.toUnmodifiableList());
    }

    public void save(Student student){
        if (student.getId() == null){
            Student newStudent = new Student();
            newStudent.setMark(student.getMark());
            newStudent.setName(student.getName());
            studentRepository.save(newStudent);
        }else {
            studentRepository.save(student);
        }
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }
}
