package com.JDBC.JDBCdemo;

import com.JDBC.JDBCdemo.model.Alien;
import com.JDBC.JDBCdemo.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbcdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbcdemoApplication.class, args);
		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(10);
		alien1.setName("alien1");
		alien1.setAge(30);

		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.saveAlien(alien1);
		System.out.println("Rows saved" + repo.findAllAlien());
	}

}
