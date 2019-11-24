package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;
@Controller
public class HomeController {
@Autowired
    CourseRepository courseRepository;
@Autowired
    StudentRepository studentRepository;
@RequestMapping("/")
    public String index(Model model){
    Student student = new Student();
    student.setName("James Richard");

    Course course = new Course();
    course.setCredit("3");
    course.setName("Calculus");
    course.setDescription("Math class");

    Set<Course> courses = new HashSet<Course>();
    courses.add(course);
    student.setCourses(courses);

    studentRepository.save(student);
    model.addAttribute("student", studentRepository.findAll());
    return"index";
}

}
