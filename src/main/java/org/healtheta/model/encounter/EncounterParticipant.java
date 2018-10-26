package org.healtheta.model.encounter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.*;
import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_EncounterParticipant")
public class EncounterParticipant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_type")
    private List<CodeableConcept> type;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_period")
    private Period period;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_individual")
    private Reference individual;

    public Long getId() {
        return id;
    }

    public List<CodeableConcept> getType() {
        return type;
    }

    public Period getPeriod() {
        return period;
    }

    public Reference getIndividual() {
        return individual;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(List<CodeableConcept> type) {
        this.type = type;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public void setIndividual(Reference individual) {
        this.individual = individual;
    }
}
