package coid.bcafinance.pcmspringkafkaconsumer.repo;

import coid.bcafinance.pcmspringkafkaconsumer.model.DemoKafka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepo extends JpaRepository<DemoKafka,Long> {

}
