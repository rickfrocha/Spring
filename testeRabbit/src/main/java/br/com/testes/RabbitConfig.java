package br.com.testes;

import javax.annotation.PostConstruct;

import org.aopalliance.aop.Advice;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author s2it_rrocha
 * @since 8/23/16.
 */
@Configuration
public class RabbitConfig extends AbstractRabbitConfig {

    public static final String QUEUE_NAME = "my-queue";
    public static final String QUEUE_NAME_EXCHANGE = "my-queue-exchange";

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private RabbitAdmin admin;

    @Autowired
    private QueueListener listener;

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @PostConstruct
    public void init() {
        System.out.println(">>>>>>>>>>>>>>>>>>>> RabbitConfig.init");
        declareQueue(QUEUE_NAME, QUEUE_NAME_EXCHANGE, true, true, listener);
    }

    @Override
    RabbitAdmin getAdmin() {
        return this.admin;
    }

    @Override
    ConnectionFactory getConnectionFactory() {
        return this.connectionFactory;
    }


}
