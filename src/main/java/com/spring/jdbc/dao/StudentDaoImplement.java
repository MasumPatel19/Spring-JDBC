package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

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

}
