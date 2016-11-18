package br.com.testes;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author s2it_rrocha
 * @since 8/23/16.
 */
@RestController
@RequestMapping("/api")
public class TesteResource {

    @Autowired
    private RabbitTemplate template;

    @RequestMapping("/teste")
    public String teste() {
        String msg = "teste " + new Date();
        template.convertAndSend(RabbitConfig.QUEUE_NAME_EXCHANGE, RabbitConfig.QUEUE_NAME, msg);
        return msg;
    }

}
