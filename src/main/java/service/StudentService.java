package service;

import domain.Student;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created on 2016/5/5 18:27
 */
public interface StudentService {

	List<Student> saveALLFromExcel(List<Student> list);

	Page<Student> getAllStudents(Integer pageNo);

	boolean toDelOneStudent(Integer id);

	void toUpdateOneStudent(Student student);


}
