package org.healtheta.web;

import org.healtheta.model.common.Identifier;
import org.healtheta.model.common.OperationOutcome;
import org.healtheta.model.common.Reference;
import org.healtheta.model.common.repos.HumanNameRepo;
import org.healtheta.model.common.repos.IdentifierRepo;
import org.healtheta.model.common.repos.ReferenceRepo;
import org.healtheta.model.encounter.Encounter;
import org.healtheta.model.encounter.repo.EncounterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/encounter")
public class EncounterController {
    @Autowired
    private EncounterRepo encounterRepo;
    @Autowired
    private IdentifierRepo identifierRepo;
    @Autowired
    private ReferenceRepo referenceRepo;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Encounter encounter){
        Identifier identifer = encounter.getIdentifier();
        if(identifer.getValue() == null){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InternalError(), HttpStatus.OK);
        }

        if ( identifierRepo.findIdentifierByValue(identifer.getValue()) != null){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordExists(), HttpStatus.OK);
        }

        try{
            Encounter tmp = new Encounter();
            tmp = encounterRepo.save(tmp);
            encounter.setId(tmp.getId());

            Reference ref = new Reference();
            ref.setIdentifier(encounter.getIdentifier());
            ref.setDisplay("encounter-reference");
            encounter.setReference(ref);
            encounter = encounterRepo.save(encounter);
            return new ResponseEntity<Encounter>(encounter, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InternalError(),
                                                                                HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> read(@PathVariable Long id){
        Encounter encounter = encounterRepo.findEncounterById(id);
        if(encounter != null){
            return new ResponseEntity<Encounter>(encounter, HttpStatus.OK);
        }else{
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(),
                                                                            HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Encounter encounter){
        Long id = encounter.getId();
        Encounter tmp = encounterRepo.findEncounterById(id);
        if(tmp != null){
            encounter.setReference(tmp.getReference());
            encounter = encounterRepo.save(encounter);
            return new ResponseEntity<Encounter>(encounter,
                                                                HttpStatus.OK);
        }else{
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(),
                                                                            HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> delete(String id) {
        return null;
    }

    @RequestMapping(value = "/search",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> search(@RequestParam(value = "subjectRefId", required=false) Long subject,
                                    @RequestParam(value = "appointmentRefId", required=false) Long appointment,
                                    @RequestParam(value = "serviceProviderRefId", required=false) Long serviceProvider){
        if(subject != null){
            Reference ref = referenceRepo.findReferenceById(subject);
            if(ref != null){
                List<Encounter> encounterList = encounterRepo.findEncounterBySubject(ref);
                return new ResponseEntity<List>(encounterList, HttpStatus.OK);
            }else{
                return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(),
                        HttpStatus.NOT_FOUND);
            }
        }else if ( appointment != null){
            Reference ref = referenceRepo.findReferenceById(appointment);
            if(ref != null){
                List<Encounter> encounterList = encounterRepo.findEncounterByAppointment(ref);
                return new ResponseEntity<List>(encounterList, HttpStatus.OK);
            }else{
                return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(),
                        HttpStatus.NOT_FOUND);
            }
        }else if ( serviceProvider != null){
            Reference ref = referenceRepo.findReferenceById(serviceProvider);
            if(ref != null){
                List<Encounter> encounterList = encounterRepo.findEncounterByServiceProvider(ref);
                return new ResponseEntity<List>(encounterList, HttpStatus.OK);
            }else{
                return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(),
                        HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<OperationOutcome>(OperationOutcome.OperationNotSupported(),
                                                                                            HttpStatus.OK);
        }


    }

    @RequestMapping(value = "/format",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> format(){
        Encounter enc = new Encounter();
        Identifier iden = new Identifier();
        iden.setValue("ENC-HAKA-AKAKAAK-LSDLDLDLD");
        enc.setIdentifier(iden);
        return new ResponseEntity<Encounter>(enc, HttpStatus.OK);
    }
}
