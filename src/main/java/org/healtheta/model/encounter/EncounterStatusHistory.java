package org.healtheta.model.encounter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.Period;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_EncounterStatusHistory")
public class EncounterStatusHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_status")
    private String status;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_period")
    private Period period;

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Period getPeriod() {
        return period;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
