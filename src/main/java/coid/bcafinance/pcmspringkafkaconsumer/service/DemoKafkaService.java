package coid.bcafinance.pcmspringkafkaconsumer.service;

import coid.bcafinance.pcmspringkafkaconsumer.configuration.KafkaConsConfig;
import coid.bcafinance.pcmspringkafkaconsumer.dto.DemoKafkaDTO;
import coid.bcafinance.pcmspringkafkaconsumer.model.DemoKafka;
import coid.bcafinance.pcmspringkafkaconsumer.repo.DemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DemoKafkaService {

    @Autowired
    private DemoRepo demoRepo;


    /** INI BUKAN HTTP JADI GAK PERLU FORMAT LONG id untuk parameter nya
     * KEDEPAN NYA SESUAIKAN SAJA DENGAN KEBUTUHAN
     * */
    @Transactional
    public void save(DemoKafkaDTO demoKafkaDTO) {
        try{
            if(demoKafkaDTO!=null)
            {
//                Optional<DemoKafka> optionalDemoKafka = demoRepo.findById(demoKafkaDTO.getIdDemo());
//                if(!optionalDemoKafka.isEmpty()){
//                    System.out.println("Modified By : "+KafkaConsConfig.getKafkaConsId());
//                    DemoKafka demoKafkaNext = optionalDemoKafka.get();
//                    demoKafkaNext.setModifiedBy(KafkaConsConfig.getKafkaConsId());
//                }
                DemoKafka demoKafka = new DemoKafka();
                demoKafka.setIdDemo(demoKafkaDTO.getIdDemo());
                demoKafka.setEmail(demoKafkaDTO.getEmail());
                demoKafka.setModifiedBy(KafkaConsConfig.getKafkaConsId());
                demoRepo.save(demoKafka);
            }
        }catch(Exception e){
            System.out.println("Error Update : "+e.getMessage());
        }
    }

//    public void consumerHitTopics(){
//        Properties properties = new Properties();
//        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaConsConfig.getKafkaConsHost());
//        properties.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConsConfig.getKafkaConsId());
//        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");
//        properties.put("auto.commit.interval.ms","1000");
//        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
//        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(properties);
//        consumer.subscribe(Arrays.asList(KafkaConsConfig.getKafkaConsTopics()));
//        while(true)
//        {
//            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(1000));
//            for (ConsumerRecord<String,String> record : records)
//            {
//                if(record.value() != null){
//                    Gson gson = new Gson();
//                    DemoKafkaDTO demoKafkaDTO = gson.fromJson(record.value(),DemoKafkaDTO.class);
//                    System.out.println("Value demoKafkaDTO "+demoKafkaDTO);
//                    System.out.println("ID demoKafkaDTO "+demoKafkaDTO.getIdDemo());
//                    System.out.println("Email demoKafkaDTO "+demoKafkaDTO.getEmail());
//                    if(demoKafkaDTO!=null){
//                        update(demoKafkaDTO);
//                    }
//                }
//            }
//        }
//    }

//    DB_NAME=KurtCobain;DB_PWD=04314a220d233becd613f5d70d21dd78;DB_UNAME=sa;HOST=localhost;ID_CONS_KAFKA=CONSUMER-1;PORT=1433;SCHEMA=demokafka;SHOW_SQL=true;SVR_PORT=9091
}