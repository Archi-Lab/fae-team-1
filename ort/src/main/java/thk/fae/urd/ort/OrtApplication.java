package thk.fae.urd.ort;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class OrtApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrtApplication.class, args);
	}

	@KafkaListener(topics = "tracker")
	public void listen(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println(cr.toString());
	}
}
