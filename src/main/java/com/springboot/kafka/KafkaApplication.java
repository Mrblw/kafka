package com.springboot.kafka;

import com.springboot.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class KafkaApplication {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostConstruct
    public void init(){
        //for (int i = 0; i < 5; i++) {
            //调用消息发送类中的消息发送方法
            kafkaProducer.send();
        //}
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }


}

