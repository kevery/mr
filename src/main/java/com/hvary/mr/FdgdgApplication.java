package com.hvary.mr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ddfg.fdgdg.crawler.mapper")
public class FdgdgApplication {

    public static void main(String[] args) {
        SpringApplication.run(FdgdgApplication.class, args);
    }

}
