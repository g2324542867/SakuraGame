package com.sakura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 开启事务支持
public class SakuraApplication {
    public static void main(String[] args) {
        SpringApplication.run(SakuraApplication.class,args);
    }
}

