package com.marketplace.usermanager.UserManager.Publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitPublisher {
   
	@Autowired
    private RabbitTemplate rabbitTemplate;
   
    @Value("${my.rabbitmq.exchange}")
    private String exchange;
   
    @Value("${my.rabbitmq.routingkey}")
    private String routingKey;
   
    public void produceMsg(String msg){
    	rabbitTemplate.convertAndSend(exchange, routingKey, msg);
        System.out.println("Send msg = " + msg);
   }
}
