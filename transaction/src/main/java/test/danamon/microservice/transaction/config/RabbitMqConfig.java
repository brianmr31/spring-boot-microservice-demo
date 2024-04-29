package test.danamon.microservice.transaction.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
public class RabbitMqConfig {
    
    @Value("${rabbitmq.queue}")
    String queueName;

    @Value("${rabbitmq.exchange}")
    String exchange;

    @Value("${rabbitmq.routingkey}")
    String routingkey;

    @Value("${rabbitmq.queue.balanceuser}")
    String queueNameBalanceUser;

    @Value("${rabbitmq.exchange.balanceuser}")
    String exchangeBalanceUser;

    @Value("${rabbitmq.routingkey.balanceuser}")
    String routingkeyBalanceUser;

    @Primary
    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Primary
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Primary
    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(routingkey);
    }

    @Bean
    Queue balanceUserNotificationQueue() {
        return new Queue(queueNameBalanceUser, false);
    }

    @Bean
    DirectExchange balanceUserNotificationExchange() {
        return new DirectExchange(exchangeBalanceUser);
    }

    @Bean
    Binding balanceUserNotificationBinding() {
        return BindingBuilder.bind(balanceUserNotificationQueue()).to(balanceUserNotificationExchange()).with(routingkeyBalanceUser);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setChannelTransacted(true);
		template.setMandatory(true);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

    // @Bean
    // public AmqpTemplate amqpTemplateBalanceUser(ConnectionFactory connectionFactory) {
    //     final RabbitTemplate template = new RabbitTemplate(connectionFactory);
    //     template.setDefaultReceiveQueue(queueNameBalanceUser);
    //     template.setRoutingKey(exchangeBalanceUser);
    //     template.setExchange(routingkeyBalanceUser);
    //     template.setChannelTransacted(true);
	// 	template.setMandatory(true);
    //     template.setMessageConverter(jsonMessageConverter());
    //     return template;
    // }
}
