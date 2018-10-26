package org.healtheta.model.encounter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.Period;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_EncounterClassHistory")
public class EncounterClassHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_class")
    private String _class;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_period")
    private Period period;

    public Long getId() {
        return id;
    }

    public String get_class() {
        return _class;
    }

    public Period getPeriod() {
        return period;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
