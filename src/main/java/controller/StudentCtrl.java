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

		return studentService.getAllStudents(pageNo);

	}

}
