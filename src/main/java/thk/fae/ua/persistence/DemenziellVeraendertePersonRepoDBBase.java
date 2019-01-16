package thk.fae.ua.persistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;

@RepositoryRestResource(path = "dvp", collectionResourceRel = "dvp", itemResourceRel = "dvp")
public interface DemenziellVeraendertePersonRepoDBBase extends CrudRepository<DemenziellVeraendertePerson, UUID> {
}
