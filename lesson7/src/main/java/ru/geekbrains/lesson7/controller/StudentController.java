package ru.geekbrains.lesson7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson7.model.Student;
import ru.geekbrains.lesson7.repository.StudentRepository;
import ru.geekbrains.lesson7.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public String findAll(Model model){
        model.addAttribute("students", studentService.findAll());
        return "student";
    }

    @PostMapping()
    public String save(@ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        studentService.deleteById(id);
        return "redirect:/student";
    }
}
