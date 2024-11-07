package coid.bcafinance.pcmspringkafkaconsumer.broker;


import coid.bcafinance.pcmspringkafkaconsumer.configuration.KafkaConsConfig;
import coid.bcafinance.pcmspringkafkaconsumer.core.SMTPCore;
import coid.bcafinance.pcmspringkafkaconsumer.dto.DemoKafkaDTO;
import coid.bcafinance.pcmspringkafkaconsumer.service.DemoKafkaService;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@Component
public class KafkaConsumer {

    @Autowired
    DemoKafkaService demoKafkaService ;

    public void consumerHitTopics(){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConsConfig.getKafkaConsHost());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConsConfig.getKafkaConsGroup());
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");
        properties.put("auto.commit.interval.ms","1000");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        org.apache.kafka.clients.consumer.KafkaConsumer<String,String> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("sendmail2"));
        while(true)
        {
            try{
                ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String,String> record : records)
                {
                    if(record.value() != null){
                        Gson gson = new Gson();
                        DemoKafkaDTO demoKafkaDTO = gson.fromJson(record.value(),DemoKafkaDTO.class);
                        System.out.println("Value demoKafkaDTO "+demoKafkaDTO);
                        System.out.println("ID demoKafkaDTO "+demoKafkaDTO.getIdDemo());
                        System.out.println("Email demoKafkaDTO "+demoKafkaDTO.getEmail());
                        if(demoKafkaDTO!=null){
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    demoKafkaService.save(demoKafkaDTO);
                                    new SMTPCore().sendSimpleMail(demoKafkaDTO.getEmail(),"Test - "+KafkaConsConfig.getKafkaConsId(),
                                            "INI ADALAH TESTING JADI JANGAN DI REPLAY","SSL");
                                }
                            }).start();
                        }
                    }
                }
            }catch (Exception e){
                System.out.println("Lanjut Terus "+e.getMessage());
            }
        }
    }
}
