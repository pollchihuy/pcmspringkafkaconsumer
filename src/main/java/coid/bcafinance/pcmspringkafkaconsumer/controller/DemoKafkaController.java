package coid.bcafinance.pcmspringkafkaconsumer.controller;

import coid.bcafinance.pcmspringkafkaconsumer.broker.KafkaConsumer;
import coid.bcafinance.pcmspringkafkaconsumer.service.DemoKafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/demo")
public class DemoKafkaController {

    @Autowired
    KafkaConsumer kafkaConsumer;

    /**
     * KALAU MAU HIT API INI HARUS NYA ADA OTENTIKASI BERLAPIS
     * BIASA NYA SIS ADMIN YANG GENERATE KEY NYA
     */
    @GetMapping("/v1/hit")
    private String hitConsumer()
    {
       kafkaConsumer.consumerHitTopics();
        return "JALAN";
    }
}
