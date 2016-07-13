package controller;


import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StudentService;

/**
 * Created on 2016/5/5 15:46
 */

@Controller
public class StudentCtrl {


	@Autowired
	private StudentService studentService;


	@ResponseBody
	@RequestMapping(value = "toGetAllStudent", method = RequestMethod.POST)
	public Page<Student> toGetAllStudent(@RequestParam("pageNo") Integer pageNo) {

		System.out.println(pageNo);

		return studentService.getAllStudents(pageNo);

	}


	@ResponseBody
	@RequestMapping(value = "toDelStudent", method = RequestMethod.POST)
	public String toDelStudent(@RequestParam("id") Integer id) {

		if (studentService.toDelOneStudent(id)) {

			return "1";
		} else {

			return "0";
		}
	}


	@ResponseBody
	@RequestMapping(value = "toUpdateStudent", method = RequestMethod.POST)
	public String toUpdateStudent(@RequestParam("student") String student) {

		Student student1 = com.alibaba.fastjson.JSON.parseObject(student, Student.class);

		studentService.toUpdateOneStudent(student1);

		return "1";
	}

}
