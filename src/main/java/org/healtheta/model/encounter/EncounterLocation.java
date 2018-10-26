package org.healtheta.model.encounter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.*;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_EncounterLocation")
public class EncounterLocation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_location")
    private Reference location;

    @Column(name = "_code")
    private String code;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_period")
    private Reference period;

    public Long getId() {
        return id;
    }

    public Reference getLocation() {
        return location;
    }

    public String getCode() {
        return code;
    }

    public Reference getPeriod() {
        return period;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(Reference location) {
        this.location = location;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPeriod(Reference period) {
        this.period = period;
    }
}
