package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImplement implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int res = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return res;
	}

	public int updateStudent(Student student) {
		String query = "update student set name=? ,city=? where id=?";
		int res = jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return res;
	}

	public int delete(int studentId) {
		String query = "delete from student where id=?";
		int res = jdbcTemplate.update(query, studentId);
		return res;
	}

	public Student getStudent(int studentId) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImplementation();
		Student student = jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student> getStudents = jdbcTemplate.query(query, new RowMapperImplementation());
		return getStudents;
	}

}
