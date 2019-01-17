package thk.fae.ua.persistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;

public interface DemenziellVeraendertePersonRepoDBBase extends CrudRepository<DemenziellVeraendertePerson, UUID> {
}
