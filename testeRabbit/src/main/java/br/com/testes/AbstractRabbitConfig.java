package br.com.testes;

import java.util.HashMap;
import java.util.Map;

import org.aopalliance.aop.Advice;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;

/**
 * @author s2it_rrocha
 * @since 8/23/16.
 */
public abstract class AbstractRabbitConfig {

    private static final String X_DEAD_LETTER_EXCHANGE = "x-dead-letter-exchange";
    private static final String X_DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";
    private static final boolean durable = true;
    private static final boolean exclusive = false;
    private static final boolean autoDelete = false;

    abstract RabbitAdmin getAdmin();

    abstract ConnectionFactory getConnectionFactory();

    public final Queue createQueue(String queueName, Boolean durable) {
        return createQueue(queueName, durable, null, null);
    }

    public final Queue createQueue(String queueName, Boolean durable, String exchangeName, Queue queueDLX) {
        final Map<String, Object> args = new HashMap<>();
        if (queueDLX != null && exchangeName != null) {
            args.put(X_DEAD_LETTER_EXCHANGE, exchangeName);
            args.put(X_DEAD_LETTER_ROUTING_KEY, queueDLX.getName());
        }
        Queue queue = new Queue(queueName, durable, exclusive, autoDelete, args);
        getAdmin().declareQueue(queue);
        return queue;
    }

    public final TopicExchange createExchange(String queueExchangeName, Boolean durable) {
        final TopicExchange exchange = new TopicExchange(queueExchangeName, durable, false);
        getAdmin().declareExchange(exchange);
        return exchange;
    }

    public final Binding createBinding(Queue queue, TopicExchange exchange) {
        final Binding binding = BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(queue.getName());
        getAdmin().declareBinding(binding);
        return binding;
    }

    public void declareQueue(String queueName, String exchangeName, boolean durable, boolean isCreateDLX, MessageListener listener) {
        TopicExchange exchange = createExchange(exchangeName, durable);
        if (!isCreateDLX) {
            Queue queue = createQueue(queueName, durable);
            createBinding(queue, exchange);
        } else {
            String queueName_dlx = queueName.concat("_dlx");
            Queue queueDLX = createQueue(queueName_dlx, true);
            createBinding(queueDLX, exchange);

            Queue queue = createQueue(queueName, durable, exchangeName, queueDLX);
            createBinding(queue, exchange);

            SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
            container.setConnectionFactory(this.getConnectionFactory());
            container.setAdviceChain(new Advice[] { RetryInterceptorBuilder
                    .stateless()
                    .maxAttempts(4)
                    .backOffOptions(10000,2.0,10000)
                    .recoverer(new RejectAndDontRequeueRecoverer())
                    .build() });
            container.setQueueNames(queueName);
            container.setupMessageListener(listener);

            container.start();

        }
    }

}
