package thk.fae.ua.persistence.ort;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thk.fae.ua.core.domain.entities.Ort;

public interface OrtRepoDBBase extends CrudRepository<Ort, UUID> {
    Iterable<Ort> findAllByDemenziellVeraendertePerson_Id(UUID dvpId);

}
