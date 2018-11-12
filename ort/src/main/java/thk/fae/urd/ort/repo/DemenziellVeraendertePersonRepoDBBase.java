package thk.fae.urd.ort.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import thk.fae.urd.ort.domain.demenziellveraenderteperson.DemenziellVeraendertePerson;

public interface DemenziellVeraendertePersonRepoDBBase extends CrudRepository<DemenziellVeraendertePerson, UUID> {
}
