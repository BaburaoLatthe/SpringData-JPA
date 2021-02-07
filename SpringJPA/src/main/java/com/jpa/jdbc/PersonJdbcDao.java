package com.jpa.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpa.model.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static BeanPropertyRowMapper<Person> personBeanPropertyRowMapper = new BeanPropertyRowMapper<>(
			Person.class);

	public List<Person> findAll() {

		String pstm = "SELECT * FROM PERSON";
		return jdbcTemplate.query(pstm, personBeanPropertyRowMapper);

	}

	public Person getById(int id) {

		String pstm = "SELECT * FROM PERSON WHERE ID = ?";
		return jdbcTemplate.queryForObject(pstm, new Object[] { id }, personBeanPropertyRowMapper);

	}

	public int deleteById(int id) {

		String pstm = "DELETE FROM PERSON WHERE ID = ?";
		return jdbcTemplate.update(pstm, new Object[] { id });

	}
	
	public int updateById(Person person) {
		
		String updateStmt = "UPDATE PERSON SET LOCATION = ?, BIRTH_DATE = ? WHERE ID = ?";
		return jdbcTemplate.update(updateStmt, new Object[] {person.getLocation(), 
				new Timestamp(person.getBirthDate().getTime()), person.getId()});
	}
}
