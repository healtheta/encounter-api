package org.healtheta.model.encounter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.CodeableConcept;
import org.healtheta.model.common.Reference;
import java.util.List;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_EncounterDiagnosis")
public class EncounterDiagnosis {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_condition")
    private Reference condition;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_role")
    private List<CodeableConcept> role;

    @Column(name = "_rank")
    private Integer rank;

    public Long getId() {
        return id;
    }

    public Reference getCondition() {
        return condition;
    }

    public List<CodeableConcept> getRole() {
        return role;
    }

    public Integer getRank() {
        return rank;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCondition(Reference condition) {
        this.condition = condition;
    }

    public void setRole(List<CodeableConcept> role) {
        this.role = role;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
