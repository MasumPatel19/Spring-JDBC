package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Spring JDBC");

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

//		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
//		String query = "insert into student(id,name,city) values(?,?,?)";
//		int result = template.update(query, 2, "Vishwa", "Surat");
//		System.out.println(result+" Record Inserted successfully.");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		Student student = new Student();

		/*
		 * For Insert
		 */

		// student.setId(201);
		// student.setName("XXX");
		// student.setCity("Delhi");
		//
		// int insert = studentDao.insert(student);
		// System.out.println(insert + " Record Inserted successfully.");

		// ------------------------------------------

		/*
		 * For update
		 */

		student.setId(201);
		student.setName("YYY");
		student.setCity("Ahmedabad");
		int updateStudent = studentDao.updateStudent(student);
		System.out.println(updateStudent + " record updated successfully.");

		/*
		 * For delete
		 */

//		int delete = studentDao.delete(2);
//		System.out.println(delete + " record deleted successfully.");

	}
}
