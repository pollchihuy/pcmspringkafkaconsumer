package coid.bcafinance.pcmspringkafkaconsumer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TrxDemoKafka")
public class DemoKafka {

    @Id
    @Column(name = "IDDemo")
    private Long idDemo;

    @Column(name = "Email")
    private String email;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    public Long getIdDemo() {
        return idDemo;
    }

    public void setIdDemo(Long idDemo) {
        this.idDemo = idDemo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
