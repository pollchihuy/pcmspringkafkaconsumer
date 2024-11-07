package coid.bcafinance.pcmspringkafkaconsumer;

import coid.bcafinance.pcmspringkafkaconsumer.service.DemoKafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PcmspringbootApplication {

		public static void main(String[] args) {
			SpringApplication.run(PcmspringbootApplication.class, args);
//			new DemoKafkaService().consumerHitTopics();
		}
}