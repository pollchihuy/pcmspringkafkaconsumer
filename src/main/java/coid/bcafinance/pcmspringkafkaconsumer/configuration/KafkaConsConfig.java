package coid.bcafinance.pcmspringkafkaconsumer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:kafkaconfig.properties")
public class KafkaConsConfig {
    private static String kafkaConsHost;
    private static String kafkaConsTopics;
    private static String kafkaConsGroup;
    private static String kafkaConsId;

    public static String getKafkaConsHost() {
        return kafkaConsHost;
    }
    @Value("${kafka.cons.host}")
    private void setKafkaConsHost(String kafkaConsHost) {
        KafkaConsConfig.kafkaConsHost = kafkaConsHost;
    }

    public static String getKafkaConsTopics() {
        return kafkaConsTopics;
    }

    @Value("${kafka.cons.topics}")
    private void setKafkaConsTopics(String kafkaConsTopics) {
        KafkaConsConfig.kafkaConsTopics = kafkaConsTopics;
    }

    public static String getKafkaConsGroup() {
        return kafkaConsGroup;
    }

    @Value("${kafka.cons.group}")
    private void setKafkaConsGroup(String kafkaConsGroup) {
        KafkaConsConfig.kafkaConsGroup = kafkaConsGroup;
    }

    public static String getKafkaConsId() {
        return kafkaConsId;
    }

    @Value("${kafka.cons.id}")
    private void setKafkaConsId(String kafkaConsId) {
        KafkaConsConfig.kafkaConsId = kafkaConsId;
    }
}