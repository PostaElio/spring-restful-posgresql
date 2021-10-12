package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Demo3Application implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        String sql = "INSERT INTO students (id,name,email) VALUES (" +
                "5,'Weon','wwwwwemail@gmail.com')";

        int rows = jdbcTemplate.update(sql);

        if(rows > 0){
            System.out.println("Se agrego");
        }*/
    }


}
