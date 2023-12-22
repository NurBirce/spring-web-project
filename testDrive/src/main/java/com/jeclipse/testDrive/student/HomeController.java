package com.jeclipse.testDrive.student;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

	public final StudentService servObj;
	
	@Autowired
	public HomeController(StudentService serviceClass) {
		this.servObj = serviceClass;
	}
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return "home";		
	}
	
	@GetMapping("/new")
	public String newStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "new";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		servObj.saveStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String updateStudent(@PathVariable ( value = "id") int id, Model model) {
		Student student = servObj.getStudentById(id);
		model.addAttribute("student", student);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateStudentById(@ModelAttribute Student student) {
		servObj.updateStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable (value = "id") int id,Model model) {
		Student student = servObj.getStudentById(id);
		model.addAttribute("student", student);
		return "delete";
	}
	
	@GetMapping("/delete")
	public String deleteStudentById(@RequestParam int id) {
		System.out.println("hey id budur: " + id);
		this.servObj.deleteStudent(id);
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	public String deletebyid(@ModelAttribute Student student) {
		servObj.deleteStudent(student.id);
		return "redirect:/";
	}
	
	
}
