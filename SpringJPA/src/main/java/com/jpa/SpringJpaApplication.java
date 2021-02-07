package com.jpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.jdbc.PersonJdbcDao;
import com.jpa.model.Person;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJdbcDao personDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int id = 10001;
		Person person = new Person(id, null, "Bangalore", new Date());

		logger.info("Person Dao Details {}", personDao.findAll());
		logger.info("Person For ID " + id + " :: {}", personDao.getById(id));
		logger.info("Delete person For ID " + 10002 + " :: Rows Updated {}", personDao.deleteById(10002));
		logger.info("Update person For ID " + id + " :: Rows Updated {}", personDao.updateById(person));

	}

}
