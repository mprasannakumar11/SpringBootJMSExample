package com.example;

import com.example.model.Orders;
import com.example.sender.OrderSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.Date;
import java.util.concurrent.TimeUnit;


// Enable if you want to configure an embedded activeMQ server using Spring XML Configuration
//@Configuration
//@ImportResource(value = "classpath:spring-activemq-config.xml")
@SpringBootApplication
public class SpringBootJmsExampleApplication implements ApplicationRunner {


    private static Logger log = LoggerFactory.getLogger(SpringBootJmsExampleApplication.class);

    @Autowired
    private OrderSender orderSender;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("Spring Boot Embedded ActiveMQ Configuration Example");

        for (int i = 0; i < 5; i++) {
            Orders myMessage = new Orders(i + " - Sending JMS Message using Embedded activeMQ", new Date());
            orderSender.send(myMessage);
        }

        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
        TimeUnit.SECONDS.sleep(3);
        System.exit(-1);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJmsExampleApplication.class, args);
    }
}
