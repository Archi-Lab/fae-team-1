package thk.fae.ua.infrastructure.kafka.configuration;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import thk.fae.ua.infrastructure.kafka.models.uaevent.UAEventMessageModel;

@Configuration
@EnableKafka
public class UngewoehnlicherAufenthaltsortEventProducerConfig extends StandardProducerConfig {

    private ProducerFactory<String, UAEventMessageModel> producerFactory() {
        return new DefaultKafkaProducerFactory<>(
                getProducerConfig(),
                new StringSerializer(),
                new JsonSerializer<>()
        );
    }

    @Bean
    public KafkaTemplate<String, UAEventMessageModel> uaEventKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
