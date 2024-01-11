package com.ecommerce.order_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class KafkaConfig {

    @Bean
    public NewTopic orderTopic() {
        return TopicBuilder.name("orderPayment-topic")
                .build();
    }
}
