package com.nvd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.nvd.mapper")
public class JxcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JxcApplication.class, args);
    }

}
