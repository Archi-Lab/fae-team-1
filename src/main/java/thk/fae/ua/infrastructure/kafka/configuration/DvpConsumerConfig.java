package thk.fae.ua.infrastructure.kafka.configuration;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import thk.fae.ua.infrastructure.kafka.models.dvp.DvpMessageModel;

@Configuration
@EnableKafka
public class DvpConsumerConfig extends StandardConsumerConfig {

    @Bean
    @ConditionalOnMissingBean(name = "dvpListenerContainerFactory")
    public ConsumerFactory<String, DvpMessageModel> dvpConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                getConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(DvpMessageModel.class)
        );
    }

    @Bean(name = "dvpListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, DvpMessageModel> dvpListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, DvpMessageModel> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(dvpConsumerFactory());
        return factory;
    }
}
