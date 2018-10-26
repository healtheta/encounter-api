package org.healtheta.model.encounter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.*;
import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_EncounterHospitalization")
public class EncounterHospitalization {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_preAdmissionIdentifier")
    private Identifier preAdmissionIdentifier;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_origin")
    private Reference origin;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_admitSource")
    private CodeableConcept admitSource;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_reAdmission")
    private CodeableConcept reAdmission;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_dietPreference")
    private List<CodeableConcept> dietPreference;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_specialCourtesy")
    private List<CodeableConcept> specialCourtesy;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_specialArrangement")
    private List<CodeableConcept> specialArrangement;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_destination")
    private Reference destination;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_dischargeDisposition")
    private CodeableConcept dischargeDisposition;

    public Long getId() {
        return id;
    }

    public Identifier getPreAdmissionIdentifier() {
        return preAdmissionIdentifier;
    }

    public Reference getOrigin() {
        return origin;
    }

    public CodeableConcept getAdmitSource() {
        return admitSource;
    }

    public CodeableConcept getReAdmission() {
        return reAdmission;
    }

    public List<CodeableConcept> getDietPreference() {
        return dietPreference;
    }

    public List<CodeableConcept> getSpecialCourtesy() {
        return specialCourtesy;
    }

    public List<CodeableConcept> getSpecialArrangement() {
        return specialArrangement;
    }

    public Reference getDestination() {
        return destination;
    }

    public CodeableConcept getDischargeDisposition() {
        return dischargeDisposition;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPreAdmissionIdentifier(Identifier preAdmissionIdentifier) {
        this.preAdmissionIdentifier = preAdmissionIdentifier;
    }

    public void setOrigin(Reference origin) {
        this.origin = origin;
    }

    public void setAdmitSource(CodeableConcept admitSource) {
        this.admitSource = admitSource;
    }

    public void setReAdmission(CodeableConcept reAdmission) {
        this.reAdmission = reAdmission;
    }

    public void setDietPreference(List<CodeableConcept> dietPreference) {
        this.dietPreference = dietPreference;
    }

    public void setSpecialCourtesy(List<CodeableConcept> specialCourtesy) {
        this.specialCourtesy = specialCourtesy;
    }

    public void setSpecialArrangement(List<CodeableConcept> specialArrangement) {
        this.specialArrangement = specialArrangement;
    }

    public void setDestination(Reference destination) {
        this.destination = destination;
    }

    public void setDischargeDisposition(CodeableConcept dischargeDisposition) {
        this.dischargeDisposition = dischargeDisposition;
    }
}
