package com.b2wdigital.selecao.cpfvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class CpfValidatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpfValidatorApplication.class, args);
    }

}
