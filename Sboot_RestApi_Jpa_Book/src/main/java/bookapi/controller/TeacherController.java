package bookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookapi.entity.Teacher;
import bookapi.service.TeacherService_withoutDB;

@RestController
@RequestMapping("teacher") 												// Doing mapping on class level
public class TeacherController {

	@Autowired
	private TeacherService_withoutDB teacherService;

	@GetMapping("/") 													// Handler for - Getting All Teachers
	public List<Teacher> getTeachers() {
		return this.teacherService.getAllTeachers();
	}

	@GetMapping("/{tid}") 												// Handler for - Getting Single Teacher
	public Teacher getSingleTeacher(@PathVariable("tid") int id) {
		Teacher t = this.teacherService.getSingleTeacherById(id);
		System.out.println(t);
		return t;
	}

	@PostMapping("/") 													// Handler for - Creating new Book
	public Teacher addTeacher(@RequestBody Teacher teacher) 			// @RequestBody - same way @RequestParam
	{
		Teacher t = this.teacherService.saveTeacher(teacher);
		System.out.println(t);
		return t;
	}

	@DeleteMapping("/{tid}")												// Handler for - deleting single Teacher
	public List<Teacher> deleteTeacher(@PathVariable("tid") int teacherId) 
	{
		return this.teacherService.deleteTeacherById(teacherId);
	}

	@PutMapping("/{tid}") 													// Handler for - Updating existing Teacher
	public List<Teacher> updateTeacher(@PathVariable("tid") int teacherId, @RequestBody Teacher teacher) {
		return this.teacherService.updateTeacher(teacherId, teacher);
	}

}
