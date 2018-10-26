package org.healtheta.model.encounter.repo;

import org.healtheta.model.common.Reference;
import org.healtheta.model.encounter.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EncounterRepo extends JpaRepository<Encounter, Long> {
    public Encounter findEncounterById(Long id);
    public List<Encounter> findEncounterBySubject(Reference subject);
    public List<Encounter> findEncounterByAppointment(Reference appointment);
    public List<Encounter> findEncounterByServiceProvider(Reference serviceProvider);
    public List<Encounter> findAll();
}