package service;

import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;

import java.util.List;

/**
 * Created on 2016/5/5 18:28
 */

@Service
public class SudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	@Override
	public List<Student> saveALLFromExcel(List<Student> list) {

		return studentRepository.save(list);

	}

	@Transactional(readOnly = true)
	@Override
	public Page<Student> getAllStudents(Integer pageNo) {

		PageRequest request = new PageRequest(pageNo - 1, 20);

		return studentRepository.toGetAllStudents(request);
	}


	@Transactional
	@Override
	public boolean toDelOneStudent(Integer id) {

		studentRepository.delete(id);

		if (studentRepository.findOne(id) == null) {

			return true;
		} else {

			return false;

		}
	}

	@Override
	public void toUpdateOneStudent(Student student) {

		studentRepository.saveAndFlush(student);

	}
}
