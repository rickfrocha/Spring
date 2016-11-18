package br.com.testes;

import org.glassfish.hk2.runlevel.RunLevelException;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author s2it_rrocha
 * @since 8/23/16.
 */
@Component
public class QueueListener implements MessageListener{



    @PostConstruct
    public void init(){
        System.out.println("###################### QueueListener.init");
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    @Override
    public void onMessage(Message message) {

        System.out.println(">>>>>>>>>>>>>>>>>>> recebendo mensagem!!!! count: " + message.getMessageProperties().getMessageCount() + " redelivery "+
                message.getMessageProperties().getHeaders().get("x-redelivered-count"));

        //throw new RunLevelException("Mensagem rejeitada!!!" + new Date());
        throw new AmqpRejectAndDontRequeueException("Mensagem rejeitada!!!" + new Date());
    }
}
