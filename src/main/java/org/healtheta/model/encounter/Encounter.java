package org.healtheta.model.encounter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.CodeableConcept;
import org.healtheta.model.common.Identifier;
import org.healtheta.model.common.Period;
import org.healtheta.model.common.Reference;
import javax.persistence.*;
import java.util.List;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Encounter")
public class Encounter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_identifier")
    private Identifier identifier;

    @Column(name = "_status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_statusHistory")
    private List<EncounterStatusHistory> statusHistory;

    @Column(name = "_class")
    private String _class;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_classHistory")
    private List<EncounterClassHistory> classHistory;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_type")
    private List<CodeableConcept> type;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_priority")
    private CodeableConcept priority;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_subject")
    private Reference subject;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_episodeOfCare")
    private List<Reference> episodeOfCare;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_incomingReferal")
    private List<Reference> incomingReferal;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_participant")
    private List<EncounterParticipant> participant;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_appointment")
    private Reference appointment;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_period")
    private Period period;

    //TODO duration

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_reason")
    private List<CodeableConcept> reason;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_diagnosis")
    private List<EncounterDiagnosis> diagnosis;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_account")
    private List<Reference> account;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_hospitalization")
    private EncounterHospitalization hospitalization;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_specialArrangement")
    private List<EncounterLocation> location;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_serviceProvider")
    private Reference serviceProvider;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_partOf")
    private Reference partOf;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_reference")
    private Reference reference;

    public Long getId() {
        return id;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public String getStatus() {
        return status;
    }

    public List<EncounterStatusHistory> getStatusHistory() {
        return statusHistory;
    }

    public String get_class() {
        return _class;
    }

    public List<EncounterClassHistory> getClassHistory() {
        return classHistory;
    }

    public List<CodeableConcept> getType() {
        return type;
    }

    public CodeableConcept getPriority() {
        return priority;
    }

    public Reference getSubject() {
        return subject;
    }

    public List<Reference> getEpisodeOfCare() {
        return episodeOfCare;
    }

    public List<Reference> getIncomingReferal() {
        return incomingReferal;
    }

    public List<EncounterParticipant> getParticipant() {
        return participant;
    }

    public Reference getAppointment() {
        return appointment;
    }

    public Period getPeriod() {
        return period;
    }

    public List<CodeableConcept> getReason() {
        return reason;
    }

    public List<EncounterDiagnosis> getDiagnosis() {
        return diagnosis;
    }

    public List<Reference> getAccount() {
        return account;
    }

    public EncounterHospitalization getHospitalization() {
        return hospitalization;
    }

    public List<EncounterLocation> getLocation() {
        return location;
    }

    public Reference getServiceProvider() {
        return serviceProvider;
    }

    public Reference getPartOf() {
        return partOf;
    }

    public Reference getReference() {
        return reference;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusHistory(List<EncounterStatusHistory> statusHistory) {
        this.statusHistory = statusHistory;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public void setClassHistory(List<EncounterClassHistory> classHistory) {
        this.classHistory = classHistory;
    }

    public void setType(List<CodeableConcept> type) {
        this.type = type;
    }

    public void setPriority(CodeableConcept priority) {
        this.priority = priority;
    }

    public void setSubject(Reference subject) {
        this.subject = subject;
    }

    public void setEpisodeOfCare(List<Reference> episodeOfCare) {
        this.episodeOfCare = episodeOfCare;
    }

    public void setIncomingReferal(List<Reference> incomingReferal) {
        this.incomingReferal = incomingReferal;
    }

    public void setParticipant(List<EncounterParticipant> participant) {
        this.participant = participant;
    }

    public void setAppointment(Reference appointment) {
        this.appointment = appointment;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public void setReason(List<CodeableConcept> reason) {
        this.reason = reason;
    }

    public void setDiagnosis(List<EncounterDiagnosis> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setAccount(List<Reference> account) {
        this.account = account;
    }

    public void setHospitalization(EncounterHospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }

    public void setLocation(List<EncounterLocation> location) {
        this.location = location;
    }

    public void setServiceProvider(Reference serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public void setPartOf(Reference partOf) {
        this.partOf = partOf;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
}
