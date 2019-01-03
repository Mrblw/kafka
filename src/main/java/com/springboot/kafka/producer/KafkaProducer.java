package com.springboot.kafka.producer;

import com.alibaba.fastjson.JSONObject;
import com.springboot.kafka.bean.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        String msg = JSONObject.toJSONString(message);
        log.info("+++++++++++++++++++++++++++ message {}", msg);
        kafkaTemplate.send("buliwen",msg);
    }

}
