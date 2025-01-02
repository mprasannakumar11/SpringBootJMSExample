package com.example.consumer;

import com.example.model.Orders;
import jakarta.jms.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


import static com.example.config.ActiveMQConfig.ORDER_QUEUE;

@Component
public class OrderConsumer {

    private static Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    @JmsListener(destination = ORDER_QUEUE)
    public void receiveMessage(@Payload Orders orders,
                               @Headers MessageHeaders headers,
                               Message message, Session session) {
        log.info("received <" + orders + ">");

        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("######          Message Details           #####");
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("headers: " + headers);
        log.info("message: " + message);
        log.info("session: " + session);
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
    }

}
