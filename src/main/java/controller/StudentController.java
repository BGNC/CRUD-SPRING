package controller;

import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model){

        List<Student> liststudent = studentService.listAll();
        model.addAttribute("liststudent",liststudent);
        System.out.print("GET / ");
        return"index";

    }

    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("student",new Student());
        return "New Insertion";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/";

    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name="id") int id){
        ModelAndView modelAndView = new ModelAndView("new");

        Student student = studentService.get((long) id);
        modelAndView.addObject("student",student);
        return modelAndView;
    }
}
