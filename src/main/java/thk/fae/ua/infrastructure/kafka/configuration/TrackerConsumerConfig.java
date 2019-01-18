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
import thk.fae.ua.infrastructure.kafka.models.tracker.TrackerMessageModel;

@Configuration
@EnableKafka
public class TrackerConsumerConfig extends StandardConsumerConfig {

    @Bean
    @ConditionalOnMissingBean(name = "trackerListenerContainerFactory")
    public ConsumerFactory<String, TrackerMessageModel> trackerConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                getConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(TrackerMessageModel.class)
        );
    }

    @Bean(name = "trackerListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, TrackerMessageModel> trackerListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TrackerMessageModel> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(trackerConsumerFactory());
        return factory;
    }
}
